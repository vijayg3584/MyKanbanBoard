package com.vijay.kanbanboard.login;

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
import com.vijay.kanbanboard.common.model.User;
import com.vijay.kanbanboard.common.model.UserDetails;

@Controller
@SessionAttributes("userDetails")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails login(@RequestBody User user) {

		if ("user".equals(user.getUsername()) && "pass".equals(user.getPassword())) {
			UserDetails userDetails = new UserDetails();
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

	@ExceptionHandler(KanbanBoardException.class)
	public @ResponseBody ErrorMessage handleUserErrors(KanbanBoardException ex) {

		return ex.getErrorMessage();
	}
}
