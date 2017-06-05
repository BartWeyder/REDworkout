package xyz.redworkout.controller;

import java.util.List;
import java.util.Locale;

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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import xyz.redworkout.model.User;
import xyz.redworkout.model.UserProfile;
import xyz.redworkout.service.UserProfileService;
import xyz.redworkout.service.UserService;
import xyz.redworkout.model.ExerciseInfo;
import xyz.redworkout.service.ExerciseInfoService;


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
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		if (isCurrentAuthenticationAnonymous())
			model.addAttribute("loggedinuser", getPrincipal());
		else
			model.addAttribute("loggedinuser", getPrincipalName());
		return "userslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipalName());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

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

	/**
	 * Update user by id.
	 * @param id - id of user.
	 * @param model - model for view.
	 * @return Generated Page.
	 */
	@RequestMapping(value = {"/edit/user/{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable Integer id, ModelMap model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipalName());
		return "registration";
	}

	/**
	 * This method handling POST request on updating user.
	 * @param user user object.
	 * @param result error-result.
	 * @param model view model.
	 * @param id id of user.
	 * @return Generated page of success.
	 */
	@RequestMapping(value = {"/edit/user/{id}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
							 ModelMap model, @PathVariable Integer id) {
		if(result.hasErrors())
			return "registration";
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