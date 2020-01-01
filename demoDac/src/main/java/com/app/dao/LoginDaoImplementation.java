package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.app.pojos.Student;

@Repository
public class LoginDaoImplementation implements LoginDao 
{
	@Autowired
	private SessionFactory sf;
	public LoginDaoImplementation() {

		System.out.println("inside login dao impl");
		}

	@Override
	public Student getStudent (String email)
	{
		System.out.println("inside login dao loginr");
	
		String hql = "select s from Student s where s.email = :p_email";
		Student student = sf.getCurrentSession().createQuery(hql, Student.class).setParameter("p_email", email).getSingleResult();
		return student;
	}

	@Override
	public String registerStudent(Student s)
	{
		System.out.println("inside register dao");
		String msg = "Failed";
		Integer id = (Integer) sf.getCurrentSession().save(s);
		if( id != null)
			msg = "Registed Successfully";
		return msg;
	}
}
