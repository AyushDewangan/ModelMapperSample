package com.example.demo.service;

import java.util.List;

import com.example.demo.ApiResponse.ResponseMV;
import com.example.demo.MV.StudentMV;
import com.example.demo.VM.StudentVM;
import com.example.demo.model.Student;

public interface StudentService {

	public StudentMV addStudent(StudentVM studentVm);
	
	public List<StudentMV> getStudents();

	public StudentMV getStudent(int studentId);

	public StudentMV getStudentByName(String studentName);

	public ResponseMV deleteStudent(int studentId);

	public ResponseMV deleteStudentByName(String studentName);

}
