package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Sid")
	private int sid;

	@Column(name="Email")
	private String email;

	@Column(name="MobileNo")
	private int mobileNo;

	@Column(name="Name")
	private String name;

	@Column(name="Password")
	private String password;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="student")
	private List<Result> results;

	public Student() {

		System.out.println("insid student pojo");
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setStudent(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setStudent(null);

		return result;
	}

}