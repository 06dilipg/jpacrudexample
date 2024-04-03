package com.person.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.example.entity.PersonEntity;

public interface PersonRepo extends JpaRepository<PersonEntity,Integer> {

}
