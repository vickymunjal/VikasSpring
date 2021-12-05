package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.exception.RecordNotFoundException;
import com.example.demo.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
    private final Logger log = LoggerFactory.getLogger(StudentController.class);


	@GetMapping("/greeting")
	public String getName() {
	
		System.out.println("Vikas hit");
		log.info("Vikas  Munjal hit it");
		return "Vikas";
	}
    
	@GetMapping("/students")
	public ResponseEntity<ApiResponse> listAllStudent() {
		
		log.info("Vikas listAllStudent....");
		Iterable<Student> iter = service.listStudent();
		List<Student> al = new ArrayList<Student>();
		iter.forEach(al::add);
		
        ApiResponse apiResponse = 	ApiResponse.builder().status(HttpStatus.OK.value())
        							.message("OK").data(al).build();
		
        log.info("Vikas end listAllStudent.....");
        return ResponseEntity.ok().body(apiResponse);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<ApiResponse> getStudent(@PathVariable int id) {

		log.info("Vikas getStudent start....");

		Optional<Student> s = service.findById(id);

		ApiResponse apiResponse ;
		
		if(s.isPresent()) {
			apiResponse = 	ApiResponse.builder().status(HttpStatus.OK.value())
	       					.message("OK").data(s.get()).build();
		}else {
			apiResponse = 	ApiResponse.builder().status(HttpStatus.NOT_FOUND.value())
		       			.message("No Recorrd Found").data(s).build();
		}
        log.info("Vikas getStudent end.....");
        return ResponseEntity.ok().body(apiResponse);
	}

	
	@PostMapping("/student")
	public ResponseEntity<ApiResponse> saveStudent(@RequestBody Student req) {
		log.info("Vikas getStudent start....");
		Student s = service.saveUpdateStudent(req);
		ApiResponse apiResponse = 	ApiResponse.builder().status(HttpStatus.OK.value())
	       					.message("OK").data(s).build();
        log.info("Vikas getStudent end.....");
        return ResponseEntity.ok().body(apiResponse);
	}
	
	@PutMapping("/student")
	public ResponseEntity<ApiResponse> updateStudent(@RequestBody Student req) {
		log.info("Vikas getStudent start....");
		
		ApiResponse apiResponse;

		Student s = service.saveUpdateStudent(req);
		apiResponse = 	ApiResponse.builder().status(HttpStatus.OK.value()).message("OK").data(s).build();
		log.info("Vikas getStudent end.....");
		
        return ResponseEntity.ok().body(apiResponse);
	}
	

}
