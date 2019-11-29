package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.LoginDao;
import com.app.pojos.Student;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
   private LoginDao dao; 
   
   public LoginServiceImpl() {

		System.out.println("inside login service impl");
		}
	
	@Override
	public Student getStudent(String email) {
		System.out.println("inside login service register");

		return dao.getStudent(email);
		
	}

	@Override
	public String registerStudent(Student s) {
		System.out.println(s);
		System.out.println("inside login service register");
		return dao.registerStudent(s);
		 
	}

}
