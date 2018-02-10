package io.javabrians.springbootstarter.course;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.javabrians.springbootstarter.topic.Topic;

@Entity
public class Course {
	@Id @GeneratedValue
	private Integer id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dateAjout;
	private String description;
	@ManyToOne
	private Topic topic;
	
	public Course() {

	}
	
	public Course( String name, String description, Integer topicId , Date dateAjout) {
		super();
		this.name = name;
		this.description = description;
		this.topic= new Topic(topicId, "", "");
		this.dateAjout=dateAjout;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	

}
