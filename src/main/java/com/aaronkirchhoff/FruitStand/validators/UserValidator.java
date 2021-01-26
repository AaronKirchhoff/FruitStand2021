package com.aaronkirchhoff.FruitStand.validators;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.aaronkirchhoff.FruitStand.models.User;
import com.aaronkirchhoff.FruitStand.repositories.UserRepository;

@Component
public class UserValidator {
	
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		// Make Sure Password and Confirm Password matches
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Passwords Do Not Match! try again.");
		}
		
		// Make sure Email is Unique in the Database
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "That email has already been registered. Pick another!");
		}
		
//		// No Matts Allowed 
//		if(user.getFirstName().equals("Matthew")){
//			errors.rejectValue("firstName", "NoMattsAllowed", "Sorry, we're not accepting matts at this time");
//		}
	}

}
