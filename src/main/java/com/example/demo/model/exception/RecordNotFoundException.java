package com.example.demo.model.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class RecordNotFoundException extends RuntimeException{

	public RecordNotFoundException(){
		super();
	}

	public RecordNotFoundException(String msg){
		super(msg);
	}
}
