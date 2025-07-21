package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public UserResponse addUser(AddUserRequest request) {
		Users userTable = new Users();

		userTable.setFirstName(request.getFirstName());
		userTable.setLastName(request.getLastName());
		userTable.setLoginName(request.getLoginName());
		userTable.setPasword(request.getPasword());
		userTable.setEmail(request.getEmail());
		userTable.setMobile(request.getMobile());
		// userTable.setId(1);

		Users dataInsertedbyUserRepoIncludingGeneratedValue = userRepo.save(userTable);
		UserResponse response = new UserResponse();
		response.setResponseCode("0000");
		response.setResponseMessage("User Added Successfully");
		response.setRequest(request);
		response.setId(dataInsertedbyUserRepoIncludingGeneratedValue.getId());
		return response;
	}

	public Users getUserbyid(long id) {

		return userRepo.findById((int) id).orElse(null);
	}

	public Users getUserByName(String firstName) {

		return userRepo.findByFirstName(firstName);
	}

	public UserResponse removeUser(String name) {
		UserResponse response = new UserResponse();
	
		if (userRepo.findByFirstName(name) == null) {
			response.setResponseCode("0911");
			response.setResponseMessage("User not present");
		}

		int result = userRepo.deleteByFirstName(name);
		if (result > 0) {
			response.setResponseCode("0000");
			response.setResponseMessage("User deleted Successfully");

//			return response;
		}
		return response;
	}
	
	// Display all
		public List<Users> allUser() {
			return userRepo.findAll();
		}
	
}
