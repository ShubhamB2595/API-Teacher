package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Teacher;
import com.main.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	@PostMapping("/saveteacher")
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
		
		return new ResponseEntity<Teacher>(teacherService.addTeacher(teacher), HttpStatus.CREATED);
	}
	
	@GetMapping("/getTeacher")
	public List<Teacher> getTeachers() {
		
		return teacherService.getTeacher();
	}
	
	@GetMapping("{id}")
	public Teacher getbyId(@PathVariable("id") int id) {
		
		return teacherService.getbyId(id);
	}
	
	@PutMapping("{id}")
	public Teacher updateTeacher(@PathVariable("id") int id, @RequestBody Teacher teacher) {
		
		return teacherService.updateTeacher(id, teacher);	
	}
	
	@DeleteMapping("{id}")
	public String deletebyId(@PathVariable("id") int id) {
		
		teacherService.deletebyId(id);
		return "Deleted Id: " + id;
	}
}
