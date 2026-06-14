package com.thymeleaf.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
//    @RequestMapping(value = "/about", method = RequestMethod.GET)
//	public String serve( Model model) {
//    	model.addAttribute("name","yash");
//    	return "about";
//    }
    @GetMapping("/iterate")
    public String get(Model model) {
    	
    	List<String> names=List.of("yash","yak","yard");
    	model.addAttribute("names", names);
    	return "example";
    }
    @GetMapping("/condition")
    public String conditionHsndler(Model model) {
    	
    	List<String> names=List.of("yash","yak","yard");
    	model.addAttribute("names", names);
    	model.addAttribute("isACTIVE", true);
    	List<Integer> list = List.of(233,23,44,34);
    	model.addAttribute("list", list);
    	return "condition";
    }
    @GetMapping("/service")
    public String serviceHandler(Model model) {
    	
    	List<String> names=List.of("yash","yak","yard");
    	model.addAttribute("names", names);
    	model.addAttribute("isActive", true);
    	model.addAttribute("gender", "M");
    	List <Integer> list=List.of(233,23,44,34);
    	model.addAttribute("list", list);
    	model.addAttribute("title", "I like java");
    	model.addAttribute("title", LocalDateTime.now().toString());
    	return "service";
    }
    @GetMapping("/newabout")
    public String newHandler(Model model) {
    	
    	
    	return "aboutnew";
    }
    @GetMapping("/contact")
    public String wrapHandler(Model model) {
    	
    	
    	return "contact";
    }

}
