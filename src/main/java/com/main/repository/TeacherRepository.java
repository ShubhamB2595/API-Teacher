package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.main.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	Teacher getByEmail(String email);
}
