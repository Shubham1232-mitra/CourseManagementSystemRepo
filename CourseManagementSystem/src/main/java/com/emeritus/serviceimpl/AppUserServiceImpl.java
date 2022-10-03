package com.emeritus.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emeritus.modal.AppUser;
import com.emeritus.repository.AppUserRepository;
import com.emeritus.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService{

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public List<AppUser> getAllUsers() {
		return appUserRepository.findAll();
	}

	@Override
	public AppUser getUser(int appUserId) {
		return appUserRepository.findById(appUserId).get();
	}

	@Override
	public void addUser(AppUser appUser) {
		appUserRepository.save(appUser);
		
	}

	@Override
	public void deleteUser(int userId) {
		appUserRepository.deleteById(userId);
	}

}
