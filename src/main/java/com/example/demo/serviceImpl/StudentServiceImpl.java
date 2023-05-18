package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ApiResponse.ResponseMV;
import com.example.demo.MV.StudentMV;
import com.example.demo.VM.StudentVM;
import com.example.demo.exception.CustomExceptionCode;
import com.example.demo.exception.StudentNotExist;
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
			Optional<Student> findStudent = studentRepository.findById(studentVm.getStudentId());
			if(!findStudent.isEmpty()) {
				
			}
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
			log.info("enter in getStudent method for id : {}", studentId);
			Optional<Student> student = studentRepository.findById(studentId);
			if (student.isEmpty()) {
				log.error("Student Not Exist : {}", studentId);
				throw new StudentNotExist(CustomExceptionCode.STUDENT_NOT_FOUND.getErrMsg(),
						CustomExceptionCode.STUDENT_NOT_FOUND.getErrCode());
			}
			return modelMapper.map(student, StudentMV.class);
		} catch (StudentNotExist e) {
			throw e;
		} catch (Exception e) {
			log.error("exception occurred while find student by id : {}", studentId);
			return null;
		}
	}

	@Override
	public StudentMV getStudentByName(String studentName) {
		try {
			log.info("enter in getStudentByName method for name : {}", studentName);
			Optional<Student> student = studentRepository.findBystudentName(studentName);
			return modelMapper.map(student.get(), StudentMV.class);
		} catch (Exception e) {
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
		} catch (Exception e) {
			log.error("exception occurred while deleteStudent for Id : {}", studentId);
			responseMv.setMessage("Record Deletion Failed");
			responseMv.setStatus(false);
			return responseMv;
		}
	}

	@Override
	public ResponseMV deleteStudentByName(String studentName) {
		try {
			log.info("enter in deleteStudentByName method for name : {}", studentName);
			Optional<Student> student = studentRepository.findBystudentName(studentName);
			if (student.isEmpty()) {
				log.error("Student Not Exist with Student Name : {}", studentName);
				throw new StudentNotExist(CustomExceptionCode.STUDENT_NOT_FOUND.getErrMsg(),
						CustomExceptionCode.STUDENT_NOT_FOUND.getErrCode());
			}
			studentRepository.deleteBystudentName(studentName);
			responseMv.setMessage("Record Deleted");
			responseMv.setStatus(true);
			return responseMv;
		} catch (StudentNotExist e) {
			throw e;
		} catch (Exception e) {
			log.error("exception occurred while deleteStudent for name : {}", studentName);
			responseMv.setMessage("Record Deletion Failed");
			responseMv.setStatus(false);
			return responseMv;
		}
	}

}
