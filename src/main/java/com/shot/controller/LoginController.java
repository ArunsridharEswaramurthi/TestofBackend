package com.shot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shot.model.Login;
import com.shot.service.ILoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired

	private ILoginService loginService;

	@PostMapping("/login")
	public String addLogin(@RequestBody Login login) {
		return loginService.login(login);
	}

}
