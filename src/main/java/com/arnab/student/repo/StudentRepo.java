/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.student.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.arnab.student.entity.Student;

@Repository
public class StudentRepo {

	@Autowired
	private JdbcTemplate jdbc;
	
	public void save() {
		String sql = "INSERT INTO STUDENT(NAME, CITY) VALUES('ARNAB', 'KOL')";
		jdbc.update(sql);
	}
	
	public List<Student> getStudents() {
		String sql = "SELECT ID, NAME, CITY FROM STUDENT";
		return jdbc.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Student(rs.getInt("ID"), rs.getString("NAME"), rs.getString("CITY"));
			}			
		});
	}
}
