package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Qid")
	private int qid;

	@Column(name="Answer")
	private String answer;

	@Column(name="Description")
	private String description;

	@Column(name="Name")
	private String name;

	@Column(name="Option1")
	private String option1;

	@Column(name="Option2")
	private String option2;

	@Column(name="Option3")
	private String option3;

	@Column(name="Option4")
	private String option4;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="TopicId")
	private Topic topic;

	public Question() {
		System.out.println("insid question pojo");
	}

	public int getQid() {
		return this.qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public String getOption1() {
		return this.option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return this.option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return this.option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return this.option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public Topic getTopic(int tid) {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", answer=" + answer + ", description=" + description + ", name=" + name
				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", topic=" + topic + "]";
	}

}