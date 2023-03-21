package com.calender.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calender.api.entities.User;
import com.calender.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;

	@Override
	public User createUser(User user) {
		
		return this.ur.save(user);
	}

	@Override
	public User updateUser(User user, int id) {
		User u1 = this.ur.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		u1.setEmail(user.getEmail());
		u1.setSheetId(user.getSheetId());
		u1.setStatus(user.getStatus());
		u1.setExpiryDate(user.getExpiryDate());

		User savedUser = this.ur.save(u1);
		return savedUser;
	}

	@Override
	public void deleteUser(int id) {
		User u1 = this.ur.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		this.ur.delete(u1);

	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User u1 = this.ur.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return u1;
	}

	@Override
	public List<User> getAll() {
		List<User> list = this.ur.findAll();
		return list;
	}

	@Override
	public Boolean checkLicense(String email,String sheetId) {
		List<User> list = this.ur.findAll();
		LocalDate date = LocalDate.now();
		for (User u : list) {
			if (u.getEmail().equals(email)) {
				if (date.isBefore(u.getExpiryDate())) {
					
					if(u.getSheetId()==null) {
						u.setSheetId(sheetId);
						this.ur.save(u);
						return true;
					}
					else {
						if(u.getSheetId().equals(sheetId)) {
							return true;
						}
						else {
							return false;
						}
					}
				} 
			}
		}
		return false;
	}

	@Override
	public List<User> checkStatus() {
		List<User> list = this.ur.findAll();
		LocalDate date = LocalDate.now();
		for (User u : list) {
			if (date.isBefore(u.getExpiryDate())) {
				u.setStatus(true);
				
			}else {
				u.setStatus(false);
			}
		}
		return list;
	}



}
