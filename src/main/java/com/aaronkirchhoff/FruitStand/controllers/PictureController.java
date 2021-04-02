package com.aaronkirchhoff.FruitStand.controllers;

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
		
	}

}
