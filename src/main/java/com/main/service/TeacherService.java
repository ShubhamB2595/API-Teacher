package com.main.service;

import java.util.List;


import com.main.model.Teacher;

public interface TeacherService {

	public Teacher addTeacher(Teacher teacher);
	
	public List<Teacher> getTeacher();

	public Teacher getbyId(int id);

	Teacher updateTeacher(int id, Teacher teacher);
	
	void deletebyId(int id);
}
