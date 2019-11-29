package com.app.dao;

import com.app.pojos.Student;

public interface LoginDao
{
		public Student getStudent(String email) ;
		public String registerStudent(Student s);
}
