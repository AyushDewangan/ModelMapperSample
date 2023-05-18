package com.example.demo.VM;

public class StudentVM {
	private int studentId;
	private String studentName;
	private String className;
	private String sectionName;
	private AddressVM address;

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

	public AddressVM getAddress() {
		return address;
	}

	public void setAddress(AddressVM address) {
		this.address = address;
	}

	public StudentVM(int studentId, String studentName, String className, String sectionName, AddressVM address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.className = className;
		this.sectionName = sectionName;
		this.address = address;
	}

	public StudentVM() {
		super();
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", className=" + className
				+ ", sectionName=" + sectionName + "]";
	}

}
