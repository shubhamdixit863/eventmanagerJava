package com.example.event.controller;

import com.example.event.models.LoginDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.entities.LoginDetails;
import com.example.event.services.LoginDetailsService;

import java.util.Map;

@RestController
public class LoginDetailsController {

	@Autowired
	LoginDetailsService service;

	@PostMapping("/login")
	public Map<String,Object> validateCredentials(@RequestBody LoginDetails cred)
	{
		return service.validateCredentails(cred);
	}

	@PostMapping("/createcred")
	public boolean addNewCredentials(@RequestBody LoginDetailsModel cred)
	{
		return service.createCredentails(cred);
	}


}
