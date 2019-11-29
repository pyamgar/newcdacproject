package com.app.dao;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Topic;

public interface AdminDao {
	public  int deleteSub(int tid);
	public  int updateSub(Subject s);
	public List<Subject> fetchSub();
	public List<Topic> fetchTopics(int t);
	public String insertQuestions(Question q,int tid);
	public List<Question> getQuestions(); 
    public  String updateQuestions(Question q); 	
    public  int deleteQuestions(Integer deleteId);
	public List<Student> geyStudent(); 
    public  int deleteTopic(Integer deleteId);
	public String insertSub(Subject s);


	

}
