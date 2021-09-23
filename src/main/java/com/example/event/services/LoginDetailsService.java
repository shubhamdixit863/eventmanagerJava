package com.example.event.services;

import java.util.HashMap;
import java.util.Map;

import com.example.event.entities.Volunteer;
import com.example.event.models.LoginDetailsModel;
import com.example.event.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.entities.LoginDetails;
import com.example.event.repository.LoginDetailsRepository;
import java.util.UUID;


@Service
public class LoginDetailsService {

	@Autowired
	LoginDetailsRepository repo;

	@Autowired
	VolunteerRepository volunteerRepository;


	/*
	 *  validate credentials during login
	 */
	public Map<String,Object> validateCredentails(LoginDetails cred) {
		LoginDetails details= repo.findByUsername(cred.getUsername());
		Volunteer volunteer=volunteerRepository.findByEmail(cred.getUsername());

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
			if(volunteer!=null){
				response.put("volunteerName",volunteer.getFirstName()+""+volunteer.getLastName());
				response.put("volunteerUsername",volunteer.getEmail());
			}


			return response;
		}



		response.put("success",false);
		response.put("token","");
		return response;
	}
	/*
	 * create new credentials during registration
	 */
	public boolean createCredentails(LoginDetailsModel cred) {
		if(repo.findById(cred.getUsername()).isEmpty())
		{
			LoginDetails loginDetails=new LoginDetails();
			loginDetails.setPassword(cred.getPassword());
			loginDetails.setUsername(cred.getUsername());
			loginDetails.setRole(cred.getRole());
			repo.save(loginDetails);
			Volunteer volunteer=new Volunteer();
			volunteer.setAddress1(cred.getAddress1());
			volunteer.setAddress2(cred.getAddress2());
			volunteer.setCity(cred.getCity());
			volunteer.setCounty(cred.getCounty());
			volunteer.setTown(cred.getTown());
			volunteer.setEmail(cred.getEmail());
			volunteer.setFirstName(cred.getFirstName());
			volunteer.setLastName(cred.getLastName());
			volunteer.setMobile(cred.getMobile());
			volunteer.setPostcode(cred.getPostcode());

			volunteerRepository.save(volunteer); // can be moved to another thread
			return true;
		}
		return false;

	}



}
