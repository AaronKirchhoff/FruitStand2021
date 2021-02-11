package com.aaronkirchhoff.FruitStand.controllers;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aaronkirchhoff.FruitStand.models.User;
import com.aaronkirchhoff.FruitStand.models.Fruit;
import com.aaronkirchhoff.FruitStand.services.FruitService;
import com.aaronkirchhoff.FruitStand.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService uService;
	
	private final FruitService fService;

	public HomeController(FruitService fService) {
		this.fService = fService;
	}
	
	@RequestMapping("/fruitstand")
	public String homePage(@ModelAttribute("fruit") Fruit fruit, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");

		model.addAttribute("ideas", this.fService.getFruits());
		model.addAttribute("user", this.uService.getSingleUser(userId));
		return "dashboard.jsp";
	}
	
//	to get to the create page
	@RequestMapping("/fruitstand/addnew")
	public String newFruit(@ModelAttribute("fruit") Fruit newFruit, HttpSession session) {
		Long userID = (Long)session.getAttribute("user_id");
		User userCreatesFruit = this.uService.getSingleUser(userID);
		newFruit.setAuthor(userCreatesFruit);
		return "createfruit.jsp";
	}
	
//	run this to add a new fruit
	@RequestMapping(value="/addFruit", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("fruit") Fruit newFruit, BindingResult result, Model model, HttpSession session) {
		model.addAttribute("fruit");
		if(result.hasErrors()) {
			return "createfruit.jsp";
		}
		Long userID = (Long)session.getAttribute("user_id");
		User userCreatesFruit = this.uService.getSingleUser(userID);
		newFruit.setAuthor(userCreatesFruit);
		this.fService.createFruit(newFruit);
		return "redirect:/fruitstand";
	}
	
	@RequestMapping("/fruitstand/shopall")
	public String allFruit(@ModelAttribute("allfruit") Fruit okFruit, Model model) {
		model.addAttribute("fruit", this.fService.getFruits());
		return "allFruit.jsp";	
	}
	

	

	
//	link to get the This specific fruit
	@RequestMapping("/fruitstand/{name}/{id}")
	public String ThisFruit(@PathVariable("id") Long id, @ModelAttribute("fruit") Fruit fruit, Model model) {
		model.addAttribute("myFruit", this.fService.findFruit(id));
		return "thisFruit.jsp";
	}
	

//	edit fruit page
	@RequestMapping("/fruitstand/{id}/edit")
    public String editEntry(@PathVariable("id") Long id, Model model) {
		Fruit fruitId = fService.findFruit(id);
        if (fruitId != null){
            model.addAttribute("theFruit", fruitId);
            return "editPage.jsp";
        }else{
            return "redirect:/fruitstand/shopall";
        }
    }
	
//	postmapping edit method, binding result NEEDS to come after model attribute for validations to work.
    @PostMapping("/updated/{id}")
    public String updateEntry(@PathVariable("id") Long id, @Valid @ModelAttribute("theFruit") Fruit fruit, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "editPage.jsp";
        }else{
        	Long userID = (Long)session.getAttribute("user_id");
    		User userCreatesFruit = this.uService.getSingleUser(userID);
    		fruit.setAuthor(userCreatesFruit);
            fService.updateFruit(id, fruit);
            return "redirect:/fruitstand";
        }
    }
    
    @RequestMapping(value="/delete/{id}")
    public String destroyFruit(@PathVariable("id") Long id) {
        fService.deleteFruit(id);
        return "redirect:/fruitstand/shopall";
    }
}
