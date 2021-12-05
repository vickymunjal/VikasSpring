package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.model.response.StudentResponse;

@Service
public interface StudentService {
	
	public Iterable<Student> listStudent();
	Optional<Student> findById(int id);
	public Student saveUpdateStudent(Student s);
 	public void deleteStudent(int id);
}
