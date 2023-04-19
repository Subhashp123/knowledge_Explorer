package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDaoInterface;
import com.app.pojo.Addresses;
import com.app.pojo.Answers;
import com.app.pojo.Questions;
import com.app.pojo.Student;

@Service
@Transactional
public class StudentService implements StudentServiceInterface {

	@Autowired
	private StudentDaoInterface studentDao;

	@Override
	public String registerStudent(Student s) {
		return studentDao.registerStudent(s);
	}

	@Override
	public String addAddress(Integer sid, Addresses address) {
		return studentDao.addAddress(sid, address);
	}

	@Override
	public String updateImage(Integer id, byte[] imageFile) {
		return studentDao.updateImage(id, imageFile);
	}

	@Override
	public String postQuestion(Integer id, String question,String subject) {
		return studentDao.postQuestion(id, question,subject);
	}

	@Override
	public List<Questions> fetchAllQuestions(Integer id) {
		return studentDao.fetchAllQuestions(id);
	}

	@Override
	public List<Answers> fetchAllAnswersByQuestionID(int qid) {
		return studentDao.fetchAllAnswersByQuestionID(qid);
	}

	@Override
	public List<Questions> searchQuestionByKeyword(String searchkey) {
		return studentDao.searchQuestionByKeyword(searchkey);
	}

	@Override
	public String toggleQuestionStatus(int qid) {
		return studentDao.toggleQuestionStatus(qid);
	}

	@Override
	public String removeQuestion(int qid) {
		return studentDao.removeQuestion(qid);
	}

	@Override
	public String updateProfile(Student student, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country) {
		return studentDao.updateProfile(student, name, email, mobile, dob, city, district, state, streetLine, pincode,
				country);
	}

	@Override
	public void increseAlike(int aid) {
		studentDao.increseAlike(aid);
	}

	@Override
	public int countOfQuestions(Student s) {
		return studentDao.countOfQuestions(s);
	}

	@Override
	public int countOFQuestionLikes(Student s) {
		return studentDao.countOFQuestionLikes(s);
	}
	
	@Override
	public boolean checkLike(Student s, int qid) {
		return studentDao.checkLike(s, qid);
	}

	@Override
	public String addLikeinhistory(Student s, int qid) {
		return studentDao.addLikeinhistory(s, qid);
	}

	@Override
	public String removeLikeinhistory(Student s, int qid) {
		return studentDao.removeLikeinhistory(s, qid);
	}
}
