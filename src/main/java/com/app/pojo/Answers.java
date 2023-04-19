package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer_tbl")
public class Answers extends BaseEntity {

	@Column(name = "answer", length = 100000)
	private String answer;
	@Column(name = "raised_date", length = 20)
	private String date;
	@Column(name = "raised_time")
	private String time;
	@Column(name = "visiblity", length = 10)
	private String status;
	@Column(name = "total_likes", length = 100000)
	private int likes;
	@OneToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Questions question;

	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

	public Answers() {
		super();
	}

	public Answers(String answer, String date, String time, String status) {
		super();
		this.answer = answer;
		this.date = date;
		this.time = time;
		this.status = status;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Answers [answer=" + answer + ", date=" + date + ", time=" + time + ", status=" + status + ", likes="
				+ likes + ", question=" + question + "]";
	}

}
