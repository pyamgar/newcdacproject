package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.leftMenuDao;
import com.app.pojos.Question;
import com.app.pojos.Subject;
import com.app.pojos.Topic;
@Service
@Transactional
public class leftMenuServiceImpl implements leftMenuService{
	
	@Autowired
	private leftMenuDao dao;
	
	@Override
	public List<Subject>fetchTitles() {
		
		return dao.fetchTitles();
	}

	@Override
	public List<Topic> fetchTopics(int Subid) {
		return dao.fetchTopics(Subid);
	}

	@Override
	public List<Question> fetchQuestions(int Tid) {
			return dao.fetchQuestions(Tid);
	}

}
