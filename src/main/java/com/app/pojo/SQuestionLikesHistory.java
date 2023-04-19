package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Question_like")
public class SQuestionLikesHistory extends BaseEntity {
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student; 
	@OneToOne
	@JoinColumn(name = "question_id")
	private Questions question;
	public SQuestionLikesHistory() {
		super();
	}
	public SQuestionLikesHistory(Student student, Questions question) {
		super();
		this.student = student;
		this.question = question;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "SQuestionLikesHistory [student=" + student + ", question=" + question + "]";
	}
	
	
	
}
