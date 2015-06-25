package com.vijay.kanbanboard.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Value("${username}")
	private String user;

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("greeting", "Hey "+user+"!!");
		return "login";
	}

}
