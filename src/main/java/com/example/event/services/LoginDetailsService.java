package com.example.event.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.entities.LoginDetails;
import com.example.event.repository.LoginDetailsRepository;
import java.util.UUID;


@Service
public class LoginDetailsService {

	@Autowired
	LoginDetailsRepository repo;


	/*
	 *  validate credentials during login
	 */
	public Map<String,Object> validateCredentails(LoginDetails cred) {
		LoginDetails details= repo.findByUsername(cred.getUsername());

		//Iterable<LoginDetails> details= repo.findAll();
		System.out.println(details);
		//Iterator<LoginDetails> itr= details.iterator();
		Map <String,Object> response=new HashMap<>();
		if(details!=null)
		{
			UUID uniqueKey = UUID.randomUUID();

			response.put("success",true);
			response.put("token",uniqueKey);
			response.put("role",details.getRole());

			return response;
		}



		response.put("success",false);
		response.put("token","");
		return response;
	}
	/*
	 * create new credentials during registration
	 */
	public boolean createCredentails(LoginDetails cred) {
		if(repo.findById(cred.getUsername()).isEmpty())
		{
			repo.save(cred);
			return true;
		}
		return false;

	}



}
