package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDao;
import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Topic;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;
	
	@Override
	public String insertQuestions(Question q,int tid){
		System.out.println("Inside the admin Service");
		return dao.insertQuestions(q, tid);
		
	}



	@Override
	public List<Question> getQuestions() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String updateQuestions(Question q) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int deleteQuestions(Integer deleteId) {
		return dao.deleteQuestions(deleteId);
	}
	



	@Override
	public List<Subject> fetchSub() {
		
		return dao.fetchSub();
	}



	@Override
	public List<Topic> fetchTopics(int t) {
		return dao.fetchTopics(t) ;
	}



	@Override
	public List<Student> geyStudent() {
		return dao.geyStudent();
	}



	@Override
	public int deleteTopic(int tid) {
		return dao.deleteQuestions(tid);
		
	}



	

	@Override
	public String insertSub(Subject s) {
	    return dao.insertSub(s);
	}



	@Override
	public String updateSub(Subject s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deleteSub(int tid) {
		return dao.deleteSub(tid);
	}




	
	
}
