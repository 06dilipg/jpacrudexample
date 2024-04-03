package com.spring.demo.dao;

import java.util.List;

import com.spring.demo.entity.Student;

public interface StudentDAO {
	
	public void save(Student std);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String thelastname);
	
	void update(Student theStudent);
	
	void delete(Integer id);
}
