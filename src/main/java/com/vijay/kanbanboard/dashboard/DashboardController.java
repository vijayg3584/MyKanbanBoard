package com.vijay.kanbanboard.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping(value = "/profile")
	public String showProfile(@ModelAttribute ("profile") UserProfile userProfile)
	{
		System.out.println("First Name: " + userProfile.getFirstName());
		return "profile";
	}
}
