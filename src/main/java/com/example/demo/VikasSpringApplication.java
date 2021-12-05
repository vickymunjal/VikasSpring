package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repositary.StudentRepo;

@SpringBootApplication

public class VikasSpringApplication {//implements CommandLineRunner {

	@Autowired
	StudentRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(VikasSpringApplication.class, args);
		System.out.println("vvvvvv");
	}
	// @Override
	public void run(String... args) throws Exception
	{
		List<Student> al = new ArrayList<Student>();
		al.add(new Student("Vikas","Munjal",30 , new Date(90,3,07) ));
		al.add(new Student("Amit","Munjal",34 , new Date(95,11,15) ));
		al.add(new Student("Sumit","Munjal",43 , new Date(80,5,03) ));
		al.add(new Student("Sagar","Munjal",18 , new Date(97,8,29) ));
		al.add(new Student("Ved","Munjal",29 , new Date(99,10,11) ));
		
		al.add(new Student("Himanshu","Raheja",30 , new Date(71,3,27) ));
		al.add(new Student("Joginder","Madaan",64 , new Date(72,11,05) ));
		al.add(new Student("Manish","Malhotra",53 , new Date(73,5,13) ));
		al.add(new Student("Krishan","Kumar",58 , new Date(74,8,19) ));
		al.add(new Student("Bansi","Raheja",69 , new Date(75,10,31) ));
		
		repo.saveAll(al);
	}
	
}
