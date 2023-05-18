package com.example.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiResponse.CustomResponse;
import com.example.demo.ApiResponse.ResponseMV;
import com.example.demo.MV.StudentMV;
import com.example.demo.VM.StudentVM;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRest {

	@Autowired
	private StudentService studentService;
	
	private Logger log = LoggerFactory.getLogger(StudentRest.class);
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentMV>> getAllStudent(){
		log.info("enter in getAllStudent rest api");
		return ResponseEntity.ok().body(studentService.getStudents());
	}
	
	@GetMapping("/getStudentById/{studentId}")
	public ResponseEntity<StudentMV> getStudentById(@PathVariable int studentId){
		log.info("enter in getById rest");
		return ResponseEntity.ok().body(studentService.getStudent(studentId));
	}
	
	@GetMapping("/getByName/{studentName}")
	public ResponseEntity<StudentMV> getStudentByName(@PathVariable String studentName){
		log.info("enter in getByName rest");
		return new ResponseEntity<>(studentService.getStudentByName(studentName), HttpStatus.OK);
	}
	
	/*
	 {
    "studentId":3,
    "studentName":"XYZ",
    "className":"XYZ",
    "sectionName":"XYZ",
    "address":{
        "locationPin":2001,
        "localAddress":"ABC",
        "landMark":"ABC"
    }
}
	 */
	@PostMapping("/register")
	public ResponseEntity<CustomResponse> registerStudent(@RequestBody StudentVM studentVm) {
		log.info("enter in student register rest api");
		return new ResponseEntity<>(new CustomResponse(studentService.addStudent(studentVm)),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent")
	public ResponseMV deleteStudent(@RequestParam int studentId) {
		log.info("enter in deleteStudent rest");
		return studentService.deleteStudent(studentId);
	}
	
	@DeleteMapping("/deleteStudentByName")
	public ResponseMV deleteStudent(@RequestParam String studentName) {
		log.info("enter in deleteStudentByName rest");
		return studentService.deleteStudentByName(studentName);
	}
	
	
}
