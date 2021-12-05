package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.model.exception.RecordNotFoundException;
import com.example.demo.model.response.StudentResponse;
import com.example.demo.repositary.StudentRepo;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	
	@Autowired
	StudentRepo repo;

	
	public Iterable<Student> listStudent(){
	
		return repo.findAll();
	}
	@Override
	public Optional<Student> findById(int id) {
		return repo.findById(id);

	}

	public Student saveUpdateStudent(Student s) throws RecordNotFoundException{
		//return repo.saveAndFlush(s);
		throw new RecordNotFoundException("No  Record found");
		//return  s;
	}
	
 	public void deleteStudent(int id) {
 		repo.deleteById(id);
 	}	

    
}
