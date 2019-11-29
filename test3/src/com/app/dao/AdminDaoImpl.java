package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Topic;


@Repository
public class AdminDaoImpl implements AdminDao {
@Autowired
SessionFactory sf;
	
	@Override
	public List<Question> getQuestions(){ 
		
		String hql = "select c from Customer c";
		
		System.out.println("Inside the AdminDao ");
		
		List<Question> que = sf.getCurrentSession().createQuery(hql, Question.class).getResultList();
		
		if(que.size()==0)
		{
			System.out.println("Customer is not Available");
			que=null;
		}
		else
		{
			System.out.println("Customer is added Successfully");
			
		}
		
		return que;
	}

	
    @Override
    public  String updateQuestions(Question q){	
	String str = "question is not updated";	 
	System.out.println("DAO : Update");	
		Session hs =sf.getCurrentSession();
		String hql = "update Question q set q.name = :p_name, q.answer = :p_answer, q.option1 = :p_option1,q.option2 = :p_option2,q.option3 = :p_option3"
				+ ",q.option4 = :p_option4 where q.qid = :p_qid";
		int count =  hs.createQuery(hql).setParameter("p_name", q.getName()).setParameter("p_answer", q.getAnswer()).
				setParameter("p_option1", q.getOption1()).setParameter("p_option2", q.getOption2()).
				setParameter("p_option3", q.getOption3()).setParameter("p_option4", q.getOption4())
				.setParameter("p_qid", q.getQid()).executeUpdate();
		 if(count==1)
		    str = "ClientProfile is updated";	
	      
		return str;
	}

	@Override
    public  int deleteQuestions(Integer deleteId){
	
		System.out.println("Admin is in delete Dao"); 
		 String hql = "delete Question q Where q.id = :p_id";
		 int count = sf.getCurrentSession().createQuery(hql).setParameter("p_id", deleteId).executeUpdate();
		  return count;
	}

	@Override
	public String insertQuestions(Question q,int tid){
		Topic topic=q.getTopic(tid);  
		q.setTopic(topic);
		  System.out.println(topic.toString());
		  sf.getCurrentSession().save(q);
		  System.out.println("question is succcesffully inserted");
		return "The Mechanics ID of user is "+q.getQid();
	}


	@Override
	public List<Subject> fetchSub() {
		leftMenuDaoImpl menu= new leftMenuDaoImpl();
		return menu.fetchTitles();
	}


	@Override
	public List<Topic> fetchTopics(int Subid) {
		leftMenuDaoImpl menu= new leftMenuDaoImpl();
		return menu.fetchTopics(Subid);
	}


	@Override
	public List<Student> geyStudent() {
		 
		String hql = "select s from Student s"; 
		System.out.println(sf.getCurrentSession().createQuery(hql).getResultList());
		
		List<Student> student=  sf.getCurrentSession().createQuery(hql).getResultList();
		System.out.println("after query");
		for (Student subject : student) {
			
			System.out.println(subject.getName());
				
		}
		return student;
	}


	@Override
	public int deleteTopic(Integer deleteId) {
		String hql = "delete from Topic Where tid = :p_id";
		 int count = sf.getCurrentSession().createQuery(hql).setParameter("p_id", deleteId).executeUpdate();
		 System.out.println("inside delete dao"+count);
		 return count;		
   }



	@Override
	public String insertSub(Subject s) {
		System.out.println("inside insert sub dao");
		sf.getCurrentSession().save(s);
		return "return Success";
	}


	@Override
	public int updateSub(Subject s) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteSub(int tid) {
		String hql = "delete s from Subject Where s.sid = :p_id";
		 int count = sf.getCurrentSession().createQuery(hql).setParameter("p_id", tid).executeUpdate();
		 System.out.println("inside delete dao"+count);
		 return count;		
}
}
