package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="Student")
@Data 
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
 
public class Student implements Serializable {
	
	public Student(String fname, String lname, long age, Date updatedat) {
		this.fname = fname;
		this.lname =  lname;
		this.age = age;
		this.updatedat = updatedat;
	}

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "age")
	private long age;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedat")
	private Date updatedat;

	
	
}
