package com.example.demo.model.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentResponse {

	private int  id;

	private String fname;

	private String lname;

	private long age;

	private Date updatedat;


}
