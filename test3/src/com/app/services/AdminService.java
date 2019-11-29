package com.app.services;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Topic;


public interface AdminService {
	public  int deleteTopic(int tid);
	public List<Subject> fetchSub();
	public List<Topic> fetchTopics(int t);
	public String insertQuestions(Question q,int tid);
	public List<Question> getQuestions(); 
    public  String updateQuestions(Question q); 	
    public  int deleteQuestions(Integer deleteId);
	public List<Student> geyStudent(); 
	public String insertSub(Subject s);
	public  String updateSub(Subject s); 	
    public  int deleteSub(int deleteId);


}
