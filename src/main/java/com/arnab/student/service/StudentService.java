/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.student.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.student.entity.Student;
import com.arnab.student.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	public long save() {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			CompletableFuture.runAsync(() -> repo.save());
		}
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		return timeTaken;
	}
	
	public List<Student> getStudents() {
		return repo.getStudents();
	}
	
}
