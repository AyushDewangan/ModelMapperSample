package com.example.demo.MV;

public class StudentMV {
	private int studentId;
	private String studentName;
	private String className;
	private String sectionName;
	private AddressMV address;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public AddressMV getAddress() {
		return address;
	}

	public void setAddress(AddressMV address) {
		this.address = address;
	}

	public StudentMV(int studentId, String studentName, String className, String sectionName, AddressMV address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.className = className;
		this.sectionName = sectionName;
		this.address = address;
	}

	public StudentMV() {
		super();
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", className=" + className
				+ ", sectionName=" + sectionName + "]";
	}

}
