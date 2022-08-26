package org.college;

public class Student extends Department{

	public void studentName() {
		System.out.println("Student Name: Brindha");
	}
	
	public void studentDept() {
		System.out.println("Student Department: CSE");
	}
	
	public void studentId() {
		System.out.println("Student ID: 24792");
	}
	public static void main(String[] args) {
		College college = new College();
		college.collegeCode();
		college.collegeName();
		college.collegeRank();
		
		Department dept = new Department();
		dept.deptName();
		dept.collegeCode();
		dept.collegeName();
		dept.collegeRank();
		
		Student student = new Student();
		student.collegeCode();
		student.collegeName();
		student.collegeRank();
		student.deptName();
		student.studentDept();
		student.studentId();
		student.studentName();

	}

}
