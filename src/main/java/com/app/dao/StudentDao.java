package com.app.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojo.Addresses;
import com.app.pojo.Answers;
import com.app.pojo.Questions;
import com.app.pojo.SQuestionLikesHistory;
import com.app.pojo.Student;

@Repository
public class StudentDao implements StudentDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String registerStudent(Student s) {
		mgr.persist(s);
		return "Student Registred Peasse provide Address";
	}

	@Override
	public String addAddress(Integer sid, Addresses address) {
		Student s = mgr.find(Student.class, sid);
		s.setAddress(address);
		return "Student Registred Successfully you can login Now";
	}

	@Override
	public String updateImage(Integer id, byte[] imageFile) {
		try {
			Student s = mgr.find(Student.class, id);
			s.setImage(imageFile);
			return "Profile Image Updated Successfully";
		} catch (Exception e) {
			return "internal Error Occoured";
		}
	}

	@Override
	public String postQuestion(Integer id, String question,String subject) {
		Student student = mgr.find(Student.class, id);
		Questions q = new Questions();
		q.setQuestion(question);
		q.setStatus("Active");
		q.setSubject(subject);
		q.setDate(java.time.LocalDate.now().toString());
		q.setTime(java.time.LocalTime.now().toString());
		q.setLikes(0);
		q.setStudent(student);
		mgr.persist(q);
		return "Your question Posted Successfully";
	}

	@Override
	public List<Questions> fetchAllQuestions(Integer id) {
		Student std = mgr.find(Student.class, id);
		String Jpql = "select q from Questions q where q.student=:s";
		return mgr.createQuery(Jpql, Questions.class).setParameter("s", std).getResultList();
	}

	@Override
	public List<Answers> fetchAllAnswersByQuestionID(int qid) {
		Questions que = mgr.find(Questions.class, qid);
		String jpql = "select a from Answers a where a.question=:q";
		try {
			List<Answers> ansList = mgr.createQuery(jpql, Answers.class).setParameter("q", que).getResultList();
			if (ansList != null)
				return ansList;
			else
				return null;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<Questions> searchQuestionByKeyword(String searchkey) {
		String jpql = "select q from Questions q";
		List<Questions> searchQuestion = new ArrayList<>();
		List<Questions> allQuestions = mgr.createQuery(jpql, Questions.class).getResultList();
		for (Questions q : allQuestions) {
			if (q.getQuestion().toLowerCase().contains(searchkey.toLowerCase())) {
				searchQuestion.add(q);
			}
		}
		return searchQuestion;
	}

	@Override
	public String toggleQuestionStatus(int qid) {
		Questions que = mgr.find(Questions.class, qid);
		String status = que.getStatus();
		if (status.equals("Active")) {
			que.setStatus("Inactive");
			return "Question Status Changed to Inactive";
		} else {
			que.setStatus("Active");
			return "Question Status Changed to Active";
		}

	}

	@Override
	public String removeQuestion(int qid) {
		Questions que = mgr.find(Questions.class, qid);
		mgr.remove(que);
		return "Question is removed from the database ";
	}

	@Override
	public String updateProfile(Student student, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country) {
		Student s = mgr.find(Student.class, student.getId());
		Addresses add = new Addresses(city, district, state, country, streetLine, Integer.parseInt(pincode));
		s.setName(name);
		s.setEmail(email);
		s.setMobile(mobile);
		s.setDob(dob);
		s.setAddress(add);
		return "Your Profile is updated";
	}

	@Override
	public void increseAlike(int aid) {
		Answers ans = mgr.find(Answers.class, aid);
		ans.setLikes(ans.getLikes() + 1);
	}

	@Override
	public int countOfQuestions(Student s) {
		Student student = mgr.find(Student.class, s.getId());
		String jpql = "select q from Questions q where q.student=:std";
		List<Questions> qList = mgr.createQuery(jpql, Questions.class).setParameter("std", student).getResultList();
		int count = 0;
		for (@SuppressWarnings("unused")
		Questions q : qList) {
			count++;
		}
		return count;
	}

	@Override
	public int countOFQuestionLikes(Student s) {
		Student student = mgr.find(Student.class, s.getId());
		String jpql = "select q from Questions q where q.student=:std";
		List<Questions> qList = mgr.createQuery(jpql, Questions.class).setParameter("std", student).getResultList();
		int count = 0;
		for (Questions q : qList) {
			count = count + q.getLikes();
		}
		return count;
	}
	@Override
	public boolean checkLike(Student s, int qid) {
		Questions que=mgr.find(Questions.class, qid);
		Student student=mgr.find(Student.class, s.getId());
		String jpql="select q from SQuestionLikesHistory q";
		List<SQuestionLikesHistory> SQLH=mgr.createQuery(jpql, SQuestionLikesHistory.class).getResultList();
		
		SQuestionLikesHistory sqlObj=new SQuestionLikesHistory(student, que);
		
		for(SQuestionLikesHistory sqlh:SQLH) {
			if(sqlh.getStudent().equals(sqlObj.getStudent()) && sqlh.getQuestion().equals(sqlObj.getQuestion())) {
				return false;	
			}else {
				continue;
			}
		}
		return true;
	}

	@Override
	public String addLikeinhistory(Student s, int qid) {
		Questions que=mgr.find(Questions.class, qid);
		Student student=mgr.find(Student.class, s.getId());
		SQuestionLikesHistory sqlObj=new SQuestionLikesHistory(student, que);
		mgr.persist(sqlObj);
		return "black";
	}

	@Override
	public String removeLikeinhistory(Student s, int qid) {
		Questions que=mgr.find(Questions.class, qid);
		Student student=mgr.find(Student.class, s.getId());
		String jpql="select l from SQuestionLikesHistory l where l.student=:std and l.question=:qu";
		SQuestionLikesHistory sqlObj=mgr.createQuery(jpql, SQuestionLikesHistory.class).setParameter("std",student).setParameter("qu", que).getSingleResult();
		mgr.remove(sqlObj);
		return "red";
	}


}
