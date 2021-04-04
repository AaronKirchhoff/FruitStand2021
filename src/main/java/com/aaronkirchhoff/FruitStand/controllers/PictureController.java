package com.aaronkirchhoff.FruitStand.controllers;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aaronkirchhoff.FruitStand.models.Fruit;
import com.aaronkirchhoff.FruitStand.models.User;
import com.aaronkirchhoff.FruitStand.services.FruitService;
import com.aaronkirchhoff.FruitStand.services.PictureService;
import com.aaronkirchhoff.FruitStand.services.UserService;

@Controller
// add a layer below on line 15? needs to be blank in the first function then.
@RequestMapping("/allFruit")
public class PictureController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private PictureService pService;
	@Autowired
	private FruitService fService;
	
//	file path where you save pictures to...
	private static String UPLOADED_FOLDER = "src/main/resources/static/pictures/";
	
//	i dont htink i'll use this controller. it should be as easy as adding info into the function fruitstand/shopall that renders the allFruit page. but i'll practic ehere for now.
	
	
	@RequestMapping("")
	public String allFruit(@ModelAttribute("allfruit") Fruit okFruit, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		model.addAttribute("fruit", this.fService.getFruits());
		model.addAttribute("user", this.uService.getSingleUser(userId));
		return "allFruit.jsp";	
	}
	
//	pick up here wheni  code next, 4/1/21
	@PostMapping("/upload")
	public String upload(@RequestParam("image") MultipartFile file, @RequestParam("description") String desc, HttpSession session, RedirectAttributes redirectAttrs) {
//		save the uploaded file to static folder
		if (file.isEmpty()) {
			redirectAttrs.addFlashAttribute("message", "This field cannot be empty");
			return "redirect:/fruitstand/shopall";
		}
		try {
			Long userId = (Long)session.getAttribute("user_id");
			User user = this.uService.getSingleUser(userId);
//			get the file and save it somewhere..
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
//			get url of file just uploaded
			String url = "/pictures/" + file.getOriginalFilename();
			this.pService.uploadPic(user, url, desc);
			} catch(IOException e) {
				e.printStackTrace();
			}	
		return "redirect:/fruitstand/shopall";

	}
}
