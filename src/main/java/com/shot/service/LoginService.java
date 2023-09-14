package com.shot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shot.model.Login;
import com.shot.repository.ILoginRepository;

@Service
public class LoginService implements ILoginService {
	@Autowired

	private ILoginRepository loginRepository;

	/**
	 * checked login username and password
	 * 
	 * @return is login successful
	 */
	public String login(Login login) {
		if (login.getUsername().equals("admin") && login.getPassword().equals("admin")) {
			return "Login Successful";
		} else {
			return "Login Failed";
		}
	}

}
