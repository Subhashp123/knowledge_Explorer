package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Faculty_Question_like")
public class FQuestionLikesHistory extends BaseEntity {
	@OneToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty; 
	@OneToOne
	@JoinColumn(name = "question_id")
	private Questions question;
	public FQuestionLikesHistory() {
		super();
	}
	public FQuestionLikesHistory(Faculty faculty, Questions question) {
		super();
		this.faculty = faculty;
		this.question = question;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "FQuestionLikesHistory [faculty=" + faculty + ", question=" + question + "]";
	}
	
	
}
