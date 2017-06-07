package xyz.redworkout.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.redworkout.dao.UserDao;
import xyz.redworkout.model.Course;
import xyz.redworkout.model.CourseInfo;
import xyz.redworkout.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		User user = dao.findByEmail(email);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setWeight(user.getWeight());
			entity.setHeight(user.getHeight());
			entity.setUserProfiles(user.getUserProfiles());
			entity.setCourseInfoList(user.getCourseInfoList());
			entity.setCourseList(user.getCourseList());
			entity.setExerciseInfoList(user.getExerciseInfoList());
		}
	}


    @Override
    public void deleteUserById(Integer id) { dao.deleteById(id); }

    public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public boolean isUserEmailUnique(Integer id, String email) {
		User user = findByEmail(email);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public Course findActiveCourse(User user) {
		List<Course> courses = user.getCourseList();

		for (Course course : courses) {
			if (course.isActive())
				return course;
		}

		return null;
	}
}

