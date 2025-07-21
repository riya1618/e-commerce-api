package org.dnyanyog.controller;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authentication {
	
	
	@Autowired
	private AuthenticationService authService;
	
	@PostMapping(path="/login",produces= {"application/json","application/xml"},consumes= {"application/json","application/xml"})
	public LoginResponse login(@RequestBody LoginRequest loginRequest ) {
		
		return authService.login(loginRequest.getLoginName(),loginRequest.getPasword());
		
	}

}
