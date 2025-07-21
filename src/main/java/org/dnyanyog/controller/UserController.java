package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/api/user/AddUser" ,produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public UserResponse addUser(@RequestBody AddUserRequest request) {
		return userService.addUser(request);
		
	}

//	@PutMapping(path="/api/user/UpdateUser", produces = {"application/json" , "application/xml"} , consumes = {"application/json" , "application/xml"})
//	public UserResponse updateUser(@RequestBody UpdateUserRequest request) {
//		return userManagementService.updateUser(request);
//	}
	
	// Search
		@GetMapping(path = "/user/{id}")
		public Users getUserbyid(@PathVariable long id) {
			return userService.getUserbyid(id);
		}
		//Search by first_name
		@GetMapping(path = "/username/{firstName}")
		public Users getUserByName(@PathVariable String firstName) {
			return userService.getUserByName(firstName);
		}
		// Delete
		@DeleteMapping(path = "/user/{name}")
		public UserResponse removeUser(@PathVariable String name) {
			return userService.removeUser(name);
		}

		// Display all
		@GetMapping(path = "/userall")
		public List<Users> getallUser() {
			return userService.allUser();
		}
		
}
