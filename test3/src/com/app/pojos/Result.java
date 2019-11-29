package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Result database table.
 * 
 */
@Entity
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Rid")
	private int rid;

	@Column(name="Marks")
	private double marks;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="Sid")
	private Student student;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="Tid")
	private Topic topic;

	public Result() {

		System.out.println("insid result pojo");
	}

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public double getMarks() {
		return this.marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}