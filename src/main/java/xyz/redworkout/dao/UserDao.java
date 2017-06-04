package xyz.redworkout.dao;

import java.util.List;

import xyz.redworkout.model.User;


public interface UserDao {

	User findById(int id);

	User findByEmail(String email);
	
	void save(User user);

	void deleteById(Integer id);
	
	List<User> findAllUsers();

}

