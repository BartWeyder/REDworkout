package xyz.redworkout.service;

import java.util.List;

import xyz.redworkout.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
