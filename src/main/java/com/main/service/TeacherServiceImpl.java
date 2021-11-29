package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Teacher;
import com.main.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepo;

	public TeacherServiceImpl(TeacherRepository teacherRepo) {
		super();
		this.teacherRepo = teacherRepo;
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {
	
		return teacherRepo.save(teacher);
	}

	@Override
	public List<Teacher> getTeacher() {
		
		return teacherRepo.findAll();
	}

	@Override
	public Teacher getbyId(int id) {
		
		return teacherRepo.findById(id).get();
	}

	@Override
	public Teacher updateTeacher(int id, Teacher teacher) {
	
		Teacher newTeacher = teacherRepo.findById(id).get();
		newTeacher.setFirstName(teacher.getFirstName());
		newTeacher.setLastName (teacher.getLastName());
		return teacherRepo.save(newTeacher);
		
	}

	@Override
	public void deletebyId(int id) {
		
		teacherRepo.deleteById(id);
		
	}
	
	
}
