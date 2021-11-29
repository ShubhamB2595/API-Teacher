package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.LoginDTO;
import com.main.model.Teacher;
import com.main.repository.TeacherRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	TeacherRepository tRepo;
	
	
	@Override
	public String login(LoginDTO loginDTO) {
		
		if(validate(loginDTO)) {
			return "false";
		}
		
		Teacher teacher = tRepo.getByEmail(loginDTO.getEmail());
		if(teacher == null) {
			return "false";
		}
		
		if(teacher.getPassword().equals(loginDTO.getPassword())) {
			return "true";
		}
			return "false";
		
	}


	private boolean validate(LoginDTO loginDTO) {
		
		return loginDTO.getEmail().isEmpty();
	}

}
