package com.emeritus.service;

import java.util.List;

import com.emeritus.modal.AppUser;

public interface AppUserService {

	public List<AppUser> getAllUsers();
	
	public AppUser getUser(int appUserId);
	
	public void addUser(AppUser appUser);
	
	public void deleteUser(int userId);
}
