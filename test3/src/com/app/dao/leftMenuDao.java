package com.app.dao;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Subject;
import com.app.pojos.Topic;

public interface leftMenuDao {
	
	public List<Subject> fetchTitles();
	public List<Topic> fetchTopics(int Subid);
	public List<Question> fetchQuestions(int Tid);

}
