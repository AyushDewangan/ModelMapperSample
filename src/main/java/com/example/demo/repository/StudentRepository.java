package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

	public Optional<Student> findBystudentName(String studentName);

	public void deleteBystudentName(String studentName);

}
