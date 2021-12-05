package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	//@Query("select i from Student i where i.id = ?1")
	//List<Student> getById(int id); 


    
}
