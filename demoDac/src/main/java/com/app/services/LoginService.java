package com.app.services;

import com.app.pojos.Student;

public interface LoginService {

	public Student getStudent(String email);
	public String registerStudent(Student s);
}
