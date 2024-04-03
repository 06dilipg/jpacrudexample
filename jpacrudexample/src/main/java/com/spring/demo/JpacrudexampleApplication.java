package com.spring.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.spring.demo.dao.StudentDAO;
import com.spring.demo.entity.Student;

@SpringBootApplication
@ComponentScan({ "com.spring.demo.dao", "com.spring.demo.entity" })
public class JpacrudexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacrudexampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudents(studentDAO);
			//queryForStudents(studentDAO);
			 //queryForStudentLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		};
	}



	private void deleteStudent(StudentDAO studentDAO) {
		int stdID =3;
		System.out.println("Deleting student with id"+stdID);
		studentDAO.delete(stdID);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int stdID =1;
		System.out.println("Getting student with id"+stdID);
		Student byId = studentDAO.findById(stdID);
		System.out.println("updating student");
		//change fn;
		byId.setFirstName("Dilip");
		studentDAO.update(byId);
		System.out.println("updated student " +byId);
	}

	private void queryForStudentLastName(StudentDAO studentDAO) {
		System.out.println("Retriving  the student by lastname :");
		List<Student> allstud = studentDAO.findByLastName("Roe");
		for(Student tempstd:allstud){
			System.out.println(tempstd);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Retriving all the student using query :");
		List<Student> allstud = studentDAO.findAll();
		for(Student tempstd:allstud){
			System.out.println(tempstd);
		}
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating Student Object");
		Student student = new Student("Dilip", "Gopal", "dilip@email.com");

		// save the student object
		System.out.println("Save Student Object");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved Student generated id" + student.getId());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating Student Object");
		Student student1 = new Student("DilipG", "Gopal", "dilip@email.com");
		Student student2 = new Student("Tom", "Jeery", "tomJerry@email.com");
		Student student3 = new Student("doe", "roe", "doe@email.com");

		// save the student object
		System.out.println("Save Student Object");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}
	private void readStudents(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating Student Object");
		Student student = new Student("Dilip", "Gopal", "dilip@email.com");

		// save the student object
		System.out.println("Save Student Object");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved Student generated id :" + student.getId());

		// retrive Student based on id
		System.out.println("\nRetriving Student by id :" + student.getId());

		Student stdDetails = studentDAO.findById(student.getId());
		System.out.println("Student Details : " + stdDetails); 

	}

}
