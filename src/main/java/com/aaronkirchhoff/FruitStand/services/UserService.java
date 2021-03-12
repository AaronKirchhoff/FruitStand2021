package com.aaronkirchhoff.FruitStand.services;

import java.util.List;


import org.mindrot.jbcrypt.BCrypt;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronkirchhoff.FruitStand.models.User;
import com.aaronkirchhoff.FruitStand.repositories.UserRepository;

@Service
public class UserService {
//	dependency injenction
	@Autowired
	private UserRepository uRepo;
	
	
//	register a User
	public User registerUser(User user) {
//		generate a Hash 
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return this.uRepo.save(user);
	}

	// Authenticate / Login a user
		public boolean authenticateUser(String email, String password) {
			// make sure the user logging in is who they say they are
			// step 1: try and query for a user by email
			User user = this.uRepo.findByEmail(email);
			
			if(user == null) {
				return false;
			}
			
			// Step 2: check provided email against email in database for user
			return BCrypt.checkpw(password, user.getPassword());
		}
		
		public User getByEmail(String email) {
			return this.uRepo.findByEmail(email);
		}
		
		public User getSingleUser(Long id) {
			return this.uRepo.findById(id).orElse(null);
		}
		
		public List<User> getAllUsers() {
			return this.uRepo.findAll();			
		}
		
//		public User updateUser(Long id) {
//	        return this.uRepo.save();
//
//		}
		
		public User updateUser(Long id, User updateLanguage) {
	        return this.uRepo.save(updateLanguage);

		}
}

