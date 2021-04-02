package com.aaronkirchhoff.FruitStand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronkirchhoff.FruitStand.models.Picture;
import com.aaronkirchhoff.FruitStand.models.User;
import com.aaronkirchhoff.FruitStand.repositories.PictureRepository;

@Service
public class PictureService {
	@Autowired
	private PictureRepository pRepo;
	
//	create image object and save to database,
	public void uploadPic(User owner, String image_url, String desc) {
		Picture newPic= new Picture(owner, image_url, desc);
		this.pRepo.save(newPic);
	}
	
	

}
