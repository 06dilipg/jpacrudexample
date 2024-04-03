package com.person.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.example.entity.PersonEntity;
import com.person.example.repo.PersonRepo;

@Service
public class PersonService {
	@Autowired
	public PersonRepo personrep;
	public  PersonEntity savePersonDetails(PersonEntity person){
		return personrep.save(person);
	}
	
	public  List<PersonEntity> getPersonDetails(){
		return personrep.findAll();
	}
}
