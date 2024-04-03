package com.spring.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
public class StudentImpl implements StudentDAO {
	// define field for entity manager
	private EntityManager entityManager;
	//inject entity manager using constructor injection
	@Autowired
	public StudentImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
	@Override
	@Transactional
	public void save(Student std) {
		entityManager.persist(std); //it save the student
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("From Student",Student.class);
		return query.getResultList();
	}

	@Override
	public List<Student> findByLastName(String thelastname) {
		//create query
		TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:theData",Student.class);
		//set the parameter
		query.setParameter("theData", thelastname);
		//return query result
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}

	

}
