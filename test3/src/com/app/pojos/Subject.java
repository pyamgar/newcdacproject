package com.app.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Subject database table.
 * 
 */
@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SubId")
	private int subId;

	@Column(name="Description")
	private String description;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to Topic
	@OneToMany(mappedBy="subject")
	private List<Topic> topics;

	public Subject() {

		System.out.println("insid subject pojo");
	}

	public int getSubId() {
		return this.subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
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

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic addTopic(Topic topic) {
		getTopics().add(topic);
		topic.setSubject(this);

		return topic;
	}

	public Topic removeTopic(Topic topic) {
		getTopics().remove(topic);
		topic.setSubject(null);

		return topic;
	}

}