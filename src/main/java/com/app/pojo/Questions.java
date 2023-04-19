package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question_tbl")
public class Questions extends BaseEntity {

	@Column(name = "question", length = 100000)
	private String question;
	private String subject;
	@Column(name = "raised_date", length = 20)
	private String date;
	@Column(name = "raised_time")
	private String time;
	@Column(name = "visiblity", length = 10)
	private String status;
	@Column(name = "total_likes", length = 100000)
	private int likes;
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Answers> answer = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Questions() {
		super();
	}

	public Questions(String question,String subject, String date, String time, String status) {
		super();
		this.subject=subject;
		this.question = question;
		this.date = date;
		this.time = time;
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Answers> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answers> answer) {
		this.answer = answer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Questions [question=" + question + ", date=" + date + ", time=" + time + ", status=" + status
				+ ", likes=" + likes + ", answer=" + answer + "]";
	}

}
