package com.thymeleaf.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.entities.LoginData;

import jakarta.validation.Valid;
@Controller
public class FormController {
 @GetMapping("/form")
 public String FormHandler(Model model){
	 System.out.println("opening form");
	 model.addAttribute("loginData", new LoginData());
	 return "form";
	 
 }
 @PostMapping("/process")
 public String processForm(@Valid @ModelAttribute("loginData") LoginData logindata,BindingResult result,Model model) {
	 if(result.hasErrors()) {
		 System.out.println(result);
		   model.addAttribute("loginData", logindata);
		 return "form";
	 }
	 System.out.println(logindata);
	 return "success";
 }
 
}
