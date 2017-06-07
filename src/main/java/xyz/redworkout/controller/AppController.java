package xyz.redworkout.controller;

import java.nio.charset.CoderResult;
import java.util.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import xyz.redworkout.model.*;
import xyz.redworkout.service.*;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;

	@Autowired
	ExerciseInfoService exerciseInfoService;

	@Autowired
	TrainingInfoService trainingInfoService;

	@Autowired
	CourseInfoService courseInfoService;

	@Autowired
	CourseService courseService;

	@Autowired
	TrainingService trainingService;

	@Autowired
	ExerciseService exerciseService;

	@Autowired
	ExerciseSetService exerciseSetService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;


	/**
	 *
	 *
	 */
	@Transactional
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String mainPage(ModelMap model) {
		if (isCurrentAuthenticationAnonymous())
			return "redirect:/login";
		else {
			//Course course1 = courseService.findById(1);
			User user = userService.findByEmail(getPrincipal());
			Course course = userService.findActiveCourse(userService.findByEmail(getPrincipal()));
			CourseInfo activeCourse;

			if (course != null) {
				activeCourse = course.getCourseInfo();
				model.addAttribute("courseName", activeCourse.getCourseName());
				model.addAttribute("courseDescription", activeCourse.getCourseDescription());
				model.addAttribute("trainingsDone", course.getTrainingsDone());
				model.addAttribute("trainingsAmount", activeCourse.getDuration() * activeCourse.getTrainingsPerWeek());
				model.addAttribute("active", true);
			}
			else
				model.addAttribute("active", false);



			model.addAttribute("loggedinuser", getPrincipalName());
			return "main";
		}
	}

	@Transactional
	@RequestMapping(value = "/active-course", method = RequestMethod.GET)
	public String activeCoursePage (ModelMap model) {
		User user = userService.findByEmail(getPrincipal());
		Course activeCourse = userService.findActiveCourse(user);
		CourseInfo courseInfo = activeCourse.getCourseInfo();
		model.addAttribute("trainingsDone", activeCourse.getTrainingsDone());
		model.addAttribute("trainingsAmount", courseInfo.getDuration() * courseInfo.getTrainingsPerWeek());
		model.addAttribute("course", courseInfo);
		model.addAttribute("loggedinuser", getPrincipalName());
		return "ActiveCoursePage";
	}

	@Transactional
	@RequestMapping(value = "/set/training", method = RequestMethod.GET)
	public String setTrainingPage (ModelMap model) {
		User user = userService.findByEmail(getPrincipal());
		Course course = userService.findActiveCourse(user);
		List<TrainingInfo> trainingInfoList = course.getCourseInfo().getTrainingInfoList();
		List<TrainingInfo> doneTrainings = new ArrayList<>();
		List<Training> trainings = 	course.getTrainings();
		for (Training training : trainings) {
			doneTrainings.add(training.getTrainingInfo());
		}
		TrainingInfo lastTraining = doneTrainings.get(doneTrainings.size() - 1);
		TrainingInfo newTraining = new TrainingInfo();
		for (int i = 0; i < trainingInfoList.size(); i++) {
			if (trainingInfoList.get(i).equals(lastTraining)) {
				if (i == trainingInfoList.size() - 1)
					newTraining = trainingInfoList.get(0);
				else
					newTraining = trainingInfoList.get(i);
			}
		}

		List<ExerciseInfo> exerciseInfoList = newTraining.getExercises();
		model.addAttribute("exercises", exerciseInfoList);

		/*
		Training training = new Training();
		training.setName("Training #" + doneTrainings.size() + 1);
		training.setDate(new Date());
		training.setCourse(course);
		training.setTrainingInfo(newTraining);

		List<Exercise> exercises = new ArrayList<>();
		List<ExerciseInfo> exerciseInfoList = newTraining.getExercises();
		Exercise exercise = new Exercise();
		for (ExerciseInfo exerciseInfo : exerciseInfoList) {
			exercise.setTraining(training);
			exercise.setSets();
		}

		training.setTrainingInfo(newTraining);
		training.se*/
		return "setTraining";
	}

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		if (isCurrentAuthenticationAnonymous())
			model.addAttribute("loggedinuser", getPrincipal());
		else
			model.addAttribute("loggedinuser", getPrincipalName());
		return "userslist";
	}




	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(ModelMap model)  {

		boolean anon;
		try {
			anon = isCurrentAuthenticationAnonymous();
		} catch (NullPointerException e) {
			anon = true;
		}

		if (!anon)
			return "redirect:/main";

		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("admin", false);
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {
		List<UserProfile> set = new ArrayList<>();

		set.add(userProfileService.findById(1));
		user.setUserProfiles(set);

		if (result.hasErrors()) {
			return "registration";
		}

		if(!userService.isUserEmailUnique(user.getId(), user.getEmail())) {
			FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.unique.email", new String[]{user.getEmail()}, Locale.getDefault()));
			result.addError(emailError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}

	@Transactional
	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public String editProfile (ModelMap model) {
		User user = userService.findByEmail(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipalName());
		return "registration";
	}

	@Transactional
	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public String saveProfile (User user, BindingResult result, ModelMap model) {
		if(result.hasErrors())
			return "registration";
		User temp = userService.findById(user.getId());
		user.setUserProfiles(temp.getUserProfiles());
		user.setExerciseInfoList(temp.getExerciseInfoList());
		user.setCourseList(temp.getCourseList());
		user.setCourseInfoList(temp.getCourseInfoList());
		userService.updateUser(user);
		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipalName());
		return "registrationsuccess";
	}

	@RequestMapping(value = {"/delete/user/{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable Integer id) {
		userService.deleteUserById(id);
		return "redirect:/list";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipalName());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/list";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * Adds new exercise.
	 * TODO: change return when new form will be created, make new POST method.
	 * 	 */
	@RequestMapping(value = "/add/exercise", method = RequestMethod.GET)
	public String addExercisePage(ModelMap model) {
		ExerciseInfo exerciseInfo = new ExerciseInfo();
		exerciseInfo.setPublicAccess(false);
		exerciseInfo.setDescription("That's really hard");
		exerciseInfo.setTags("Arms");
		exerciseInfo.setExerciseName("Jerking very hard");
		User user = userService.findById(1);
		if (user == null)
			System.out.println("USER IS EMPTY");
		else
			exerciseInfo.setAuthor(user);

		if (!exerciseInfoService.isNameUnique(exerciseInfo.getId(), exerciseInfo.getExerciseName()))
			return "redirect:/error";

		exerciseInfoService.saveExerciseInfo(exerciseInfo);
		List<ExerciseInfo> list = exerciseInfoService.findAllExercises();
		ExerciseInfo info = list.get(0);
		model.addAttribute("info", info);
		return "index";
	}

	/**
	 *TODO:change this method, add for post.
	 */
	@RequestMapping(value = "/add/training", method = RequestMethod.GET)
	public String addTraining(ModelMap model) {
		TrainingInfo trainingInfo = trainingInfoService.findById(1);
		List<ExerciseInfo> exerciseInfoList = trainingInfo.getExercises();
		return "index";
	}

	@Transactional
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String allCourses(ModelMap model) {
		List<CourseInfo> courses = courseInfoService.findAllPublicCourseInfos();
		if (courses != null)
			model.addAttribute("courses", courses);
		model.addAttribute("loggedinuser", getPrincipalName());
		return "allcourses";
	}

	@Transactional
	@RequestMapping(value = "/delete/courseinfo/{id}", method = RequestMethod.GET)
	public String deleteCourseInfo(ModelMap model, @PathVariable Integer id) {
		courseInfoService.deleteCourseInfoById(id);
		return "redirect:/myprofile";
	}

	@Transactional
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String getMyProfile(ModelMap model) {
		User user = userService.findByEmail(getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("loggedinuser", getPrincipalName());
		return "myprofile";
	}


	@RequestMapping(value = "/add/test", method = RequestMethod.GET)
	public String addMethod(ModelMap model) {

		User user = userService.findById(12);
		Course course = courseService.findById(3);
		return "fragments/NewCourseForm";
	}


	@RequestMapping(value = "/start/course/{id}", method = RequestMethod.GET)
	public String startCourse(ModelMap model, @PathVariable Integer id) {
		CourseInfo courseInfo = courseInfoService.findCourseInfoById(id);
		Course course = new Course();
		course.setUser(userService.findByEmail(getPrincipal()));
		course.setTrainingsDone(0);
		course.setTrainings(null);
		course.setDone(false);
		course.setActive(true);
		course.setCourseInfo(courseInfo);
		courseService.saveCourse(course);
		return "redirect:/index";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	private String getPrincipalName(){
		User user = userService.findByEmail(getPrincipal());
		return user.getFirstName() + " " + user.getLastName();
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}


}