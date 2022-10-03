package com.emeritus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emeritus.modal.AppUser;
import com.emeritus.serviceimpl.AppUserServiceImpl;

@RestController
public class AppUserController {

	@Autowired
	private AppUserServiceImpl appUserServiceImpl;
	
	@GetMapping("/getAllUsers")
	public List<AppUser> getAllUsers(){
		return appUserServiceImpl.getAllUsers();
	}
	
	@GetMapping("/getUser/{userId}")
	public AppUser getUser(@PathVariable int userId) {
		return appUserServiceImpl.getUser(userId);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody AppUser appUser) {
		appUserServiceImpl.addUser(appUser);
		return new ResponseEntity<Object>("User Created", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable int userId) {
		appUserServiceImpl.deleteUser(userId);
	}
}
