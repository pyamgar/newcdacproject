package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Topic database table.
 * 
 */
@Entity
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Tid")
	private int tid;

	@Column(name="Description")
	private String description;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="topic")
	private List<Question> questions;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="topic")
	private List<Result> results;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="SubId")
	private Subject subject;

	public Topic() {

		System.out.println("insid topic pojo");
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setTopic(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setTopic(null);

		return question;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setTopic(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setTopic(null);

		return result;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}