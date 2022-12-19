package com.practice.demo2.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

	@Autowired
	private final StudentService studentservice ;
	
	
	
	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}



//	@GetMapping(path = "/api")
//	public List<Student> getSudents(){
//		return studentservice.getStudents();
//		
//	}
	
	@GetMapping("/student")
	public List<Student> getStudents(){
		return studentservice.getStudents();
		
	}
	
	@PostMapping("/api/student")
	public void registerNewStudent(@RequestBody Student student) {
		studentservice.addNewStudent(student);
	}
	
	@DeleteMapping(path="/api/{studentId}")
	public void deleteStudent(@PathVariable("studentId")Long id) {
		
		studentservice.deleteStudent(id);
	}
	
}
