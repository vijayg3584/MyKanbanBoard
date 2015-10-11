package com.vijay.kanbanboard.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vijay.kanbanboard.common.exception.KanbanBoardException;
import com.vijay.kanbanboard.common.model.ErrorMessage;
import com.vijay.kanbanboard.common.model.Person;
import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.common.service.UserService;

@Controller
@SessionAttributes("userDetails")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/newuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody NewUserDTO newUserCreation(@RequestBody NewUserDTO newUser) {
		
		System.out.println("LoginController.newUserCreation() "+newUser.getFirstName());
		System.out.println("LoginController.newUserCreation() "+newUser.getLastName());
		
//		newUser.setUserId(""+(i++));
//		return newUser;
		return userService.saveNewUser(newUser);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Person login(@RequestBody User user, Person userDetails) {

		if ("user".equals(user.getUsername()) && "pass".equals(user.getPassword())) {
			// UserDetail userDetails = new UserDetail();
			userDetails.setFirstName("UserFirstName");
			userDetails.setLastName("userLastName");
			return userDetails;
		} else {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setErrId(1);
			errorMessage.setCode("InvalidLogin");
			errorMessage.setDescription("Invalid username/password entered");
			throw new KanbanBoardException(errorMessage);
		}
	}

//	@RequestMapping(value = "/readuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody NewUserDTO readUser(@RequestBody NewUserDTO userReq) {
//
//		User user = new User();
//		user.setId(Long.valueOf(userReq.getUserId()));
//		Person person = userService.readUser(user);
//		// userReq.setUsername(user.getUsername());
//		// userReq.setPassword(user.getPassword());
//		userReq.setFirstName(person.getFirstName());
//		userReq.setLastName(person.getLastName());
//		userReq.setEmailId(person.getEmailId());
//		return userReq;
//	}


	@ExceptionHandler(KanbanBoardException.class)
	public @ResponseBody ErrorMessage handleUserErrors(KanbanBoardException ex) {
		return ex.getErrorMessage();
	}
}
