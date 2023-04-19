package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Addresses;
import com.app.pojo.Answers;
import com.app.pojo.FQuestionLikesHistory;
import com.app.pojo.Faculty;
import com.app.pojo.Questions;

@Repository
public class FacultyDao implements FacultyDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String registerFaculty(Faculty f) {
		mgr.persist(f);
		return "Faculty Registred Please provide Address";
	}

	@Override
	public String addAddress(Integer fid, Addresses address) {
		Faculty f = mgr.find(Faculty.class, fid);
		f.setAddress(address);
		return "Faculty Registred Successfully you can login Now";
	}

	@Override
	public String updateImage(Integer id, byte[] imageFile) {
		try {
			Faculty a = mgr.find(Faculty.class, id);
			a.setImage(imageFile);
			return "Profile Image Updated Successfully";
		} catch (Exception e) {
			return "internal Error Occoured";
		}
	}

	@Override
	public Questions fetchQuestionByID(int qid) {
		return mgr.find(Questions.class, qid);
	}

	@Override
	public String addAnswer(int qid, String answer, Faculty f) {
		Questions que = mgr.find(Questions.class, qid);
		Faculty fac = mgr.find(Faculty.class, f.getId());
		Answers ans = new Answers();
		ans.setAnswer(answer);
		ans.setFaculty(fac);
		ans.setDate(java.time.LocalDate.now().toString());
		ans.setTime(java.time.LocalTime.now().toString());
		ans.setStatus("Active");
		ans.setQuestion(que);
		ans.setLikes(0);

		mgr.persist(ans);
		return "Your Solution is submitted thank you";
	}

	@Override
	public List<Questions> fetchQuestionList() {
		String jpql = "select q from Questions q where q.status=:status";
		return mgr.createQuery(jpql, Questions.class).setParameter("status", "Active").getResultList();
	}

	@Override
	public String updateProfile(Faculty faculty, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country) {
		Faculty f = mgr.find(Faculty.class, faculty.getId());
		Addresses add = new Addresses(city, district, state, country, streetLine, Integer.parseInt(pincode));
		f.setName(name);
		f.setEmail(email);
		f.setMobile(mobile);
		f.setDob(dob);
		f.setAddress(add);
		return "Your Profile is updated";
	}

	@Override
	public int countofAnswerByFaculty(Faculty f) {
		Faculty faculty = mgr.find(Faculty.class, f.getId());
		String jpql = "select a from Answers a where a.faculty=:fac";
		List<Answers> facAnsList = mgr.createQuery(jpql, Answers.class).setParameter("fac", faculty).getResultList();
		int count = 0;
		for (@SuppressWarnings("unused")
		Answers a : facAnsList) {
			count++;
		}
		return count;
	}

	@Override
	public int countofAnswerLikesFaculty(Faculty f) {
		Faculty faculty = mgr.find(Faculty.class, f.getId());
		String jpql = "select a from Answers a where a.faculty=:fac";
		List<Answers> facAnsList = mgr.createQuery(jpql, Answers.class).setParameter("fac", faculty).getResultList();
		int likes = 0;
		for (Answers a : facAnsList) {
			likes = likes + a.getLikes();
		}
		return likes;
	}

	@Override
	public int totalQuestionCount() {
		String jpql = " select q from Questions q";
		List<Questions> qlist = mgr.createQuery(jpql, Questions.class).getResultList();
		int count = 0;
		for (@SuppressWarnings("unused")
		Questions q : qlist) {
			count++;
		}
		return count;
	}

	@Override
	public boolean checkLike(Faculty f, int qid) {

		Questions que = mgr.find(Questions.class, qid);
		Faculty faculty = mgr.find(Faculty.class, f.getId());
		String jpql = "select q from FQuestionLikesHistory q";
		List<FQuestionLikesHistory> fQLH = mgr.createQuery(jpql, FQuestionLikesHistory.class).getResultList();

		FQuestionLikesHistory fqlObj = new FQuestionLikesHistory(faculty, que);

		for (FQuestionLikesHistory fqlh : fQLH) {
			if (fqlh.getFaculty().equals(fqlObj.getFaculty()) && fqlh.getQuestion().equals(fqlObj.getQuestion())) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}

	@Override
	public String addLikeinhistory(Faculty f, int qid) {
		Questions que = mgr.find(Questions.class, qid);
		Faculty faculty = mgr.find(Faculty.class, f.getId());
		FQuestionLikesHistory fqlObj = new FQuestionLikesHistory(faculty, que);
		mgr.persist(fqlObj);
		return "black";
	}

	@Override
	public String removeLikeinhistory(Faculty f, int qid) {
		Questions que = mgr.find(Questions.class, qid);
		Faculty faculty = mgr.find(Faculty.class, f.getId());
		String jpql = "select l from FQuestionLikesHistory l where l.faculty=:fac and l.question=:qu";
		FQuestionLikesHistory fqlObj = mgr.createQuery(jpql, FQuestionLikesHistory.class).setParameter("fac", faculty)
				.setParameter("qu", que).getSingleResult();
		mgr.remove(fqlObj);
		return "red";
	}

	@Override
	public List<Questions> fetchQuestionListBySubject(String sub) {
		try {
			String jpql="select q from Questions q where q.subject=:subject";
			List<Questions> questionList=mgr.createQuery(jpql, Questions.class).setParameter("subject", sub.toLowerCase()).getResultList();
			if(questionList!=null)
				return questionList;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
