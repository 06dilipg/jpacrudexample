package com.person.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.person.example.entity.PersonEntity;
import com.person.example.service.PersonService;

@RestController
public class PersonController {
 @Autowired
 PersonService personserv;
 
 @RequestMapping(value="/person",method = RequestMethod.POST)
 public PersonEntity savePerson(@RequestBody PersonEntity personenty){
	return personserv.savePersonDetails(personenty);
 }
 
 @RequestMapping(value="/persons",method = RequestMethod.GET)
 public List<PersonEntity> getPerson(){
	return personserv.getPersonDetails();}
 
}

