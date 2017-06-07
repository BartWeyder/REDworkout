package xyz.redworkout.service;

import java.util.List;

import xyz.redworkout.model.Course;
import xyz.redworkout.model.User;


public interface UserService {
	
	User findById(int id);

	User findByEmail(String email);
	
	void saveUser(User user);
	
	void updateUser(User user);

	void deleteUserById(Integer id);

	List<User> findAllUsers();

	boolean isUserEmailUnique(Integer id, String email);

	Course findActiveCourse (User user);

}