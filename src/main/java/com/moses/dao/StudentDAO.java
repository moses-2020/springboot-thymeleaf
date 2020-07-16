package com.moses.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moses.pojo.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{
	
}
