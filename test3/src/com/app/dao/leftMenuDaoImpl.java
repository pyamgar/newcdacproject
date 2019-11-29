package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Topic;

import sun.text.normalizer.UBiDiProps;

@Repository
public class leftMenuDaoImpl implements leftMenuDao{

	@Autowired
	private SessionFactory sf;
	@Override
	public List<Subject> fetchTitles() {
		System.out.println("inside my fetch titles");
		String hql = "select s from Subject s"; 
		System.out.println(sf.getCurrentSession().createQuery(hql).getResultList());
		List<Subject> sub;
		sub=  sf.getCurrentSession().createQuery(hql).getResultList();
		System.out.println("after query");
		for (Subject subject : sub) {
			
			System.out.println(subject.getName());
				
		}
		return sub;
	}
	@Override
	public List<Topic> fetchTopics(int Subid) {

		System.out.println("Subject"+Subid);	
		Subject s=sf.getCurrentSession().get(Subject.class,Subid);
			System.out.println("Subject"+s);
			System.out.println("inside fetch topics 2"+s);

			List<Topic> top=s.getTopics();
			
			
			System.out.println(top.size());
			for (Topic topic : top) {
				System.out.println(topic.getName());
			}
			return top;
		}

	@Override
	public List<Question> fetchQuestions(int Tid) {
		
		System.out.println("Subject"+Tid);	
		Topic t=sf.getCurrentSession().get(Topic.class,Tid);
			System.out.println("Topic"+t);
			System.out.println("inside fetch questions 2");

			List<Question> que=t.getQuestions();
			
			
			System.out.println(que.size());
			for (Question question : que) {
				System.out.println(question.getName());
			}
			return que;
      }

}
