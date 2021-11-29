package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.LoginDTO;
import com.main.service.LoginService;

@RestController
@RequestMapping(value = "/teachers/api")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		
		String id = loginService.login(loginDTO);
		if(id.equals("true")) {
			return new ResponseEntity<String>("Sucess", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
}
