package com.arnab.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.student.entity.Student;
import com.arnab.student.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping(value = "/get")
	public List<Student> getStudents() {
		return service.getStudents();
	}
	
	@GetMapping(value = "/save")
	public long save() {
		return service.save();
	}
	
}
