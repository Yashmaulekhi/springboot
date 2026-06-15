package com.firstproject.Java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
	
	@RequestMapping("/test")
	public String Tester() {
		return "testing it";
	}
}
