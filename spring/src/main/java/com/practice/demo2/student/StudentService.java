package com.practice.demo2.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository ;
	
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	public List<Student> getStudents(){
		return studentRepository.findAll();
	}



	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository.findStudentbyEmail(student.getEmail());
		
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		studentRepository.save(student);
	}



	public void deleteStudent(Long id) {
		
	boolean exists= studentRepository.existsById(id);
		if(!exists) {
			
		}
		studentRepository.deleteById(id);
	}
}
