package com.calender.api.services;

import java.util.List;

import com.calender.api.entities.User;

public interface UserService {

	User createUser(User user);

	User updateUser(User user, int id);

	void deleteUser(int id);

	User getUserById(int id);

	List<User> getAll();

	Boolean checkLicense(String email,String SheetId);
	
	List<User> checkStatus();

//	List<User> checkLicenseForAll();

}
