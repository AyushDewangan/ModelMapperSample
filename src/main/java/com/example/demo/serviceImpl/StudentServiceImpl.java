package com.example.demo.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ApiResponse.ResponseMV;
import com.example.demo.MV.StudentMV;
import com.example.demo.VM.StudentVM;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	ResponseMV responseMv = new ResponseMV();

	@Override
	public StudentMV addStudent(StudentVM studentVm) {
		try {
			log.info("enter in add student method with request data : {}", studentVm);
			Student student = modelMapper.map(studentVm, Student.class);
			studentRepository.save(student);
			return modelMapper.map(student, StudentMV.class);
		} catch (Exception e) {
			log.error("exception occurrred while saving student : {}", e);
			return null;
		}
	}

	@Override
	public List<StudentMV> getStudents() {
		try {
			log.info("enter getStudents method");
			List<Student> student = studentRepository.findAll();
			return student.stream().map(t -> modelMapper.map(t, StudentMV.class)).toList();
		} catch (Exception e) {
			log.error("exception occurred while getting students : ", e);
			return null;
		}
	}

	@Override
	public StudentMV getStudent(int studentId) {
		try {
			log.info("enter in getStudent method for id : {}",studentId);
			Student student = studentRepository.findById(studentId).get();
			return modelMapper.map(student, StudentMV.class);
		}
		catch(Exception e) {
			log.error("exception occurred while find student by id : {}",studentId);
			return null;
		}
	}

	@Override
	public StudentMV getStudentByName(String studentName) {
		try {
			log.info("enter in getStudentByName method for name : {}",studentName);
			Student student = studentRepository.findBystudentName(studentName).get();
			return modelMapper.map(student, StudentMV.class);
		}
		catch(Exception e) {
			log.error("exception occurred in getStudentByName method : {}", e);
			return null;
		}
	}

	@Override
	public ResponseMV deleteStudent(int studentId) {
		try {
			log.info("enter in deleteStudent method for id : {}", studentId);
			studentRepository.deleteById(studentId);
			responseMv.setMessage("Record Deleted");
			responseMv.setStatus(true);
			return responseMv;
		}
		catch(Exception e) {
			log.error("exception occurred while deleteStudent for Id : {}", studentId);
			responseMv.setMessage("Record Deletion Failed");
			responseMv.setStatus(false);
			return responseMv;
		}
	}

	@Override
	public ResponseMV deleteStudentByName(String studentName) {
		try {
			log.info("enter in deleteStudent method for id : {}", studentName);
			studentRepository.deleteBystudentName(studentName);
			responseMv.setMessage("Record Deleted");
			responseMv.setStatus(true);
			return responseMv;
		}
		catch(Exception e) {
			log.error("exception occurred while deleteStudent for name : {}", studentName);
			responseMv.setMessage("Record Deletion Failed");
			responseMv.setStatus(false);
			return responseMv;
		}
	}

}
