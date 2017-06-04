package xyz.redworkout.dao;

import java.util.List;

import xyz.redworkout.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
