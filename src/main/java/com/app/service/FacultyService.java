package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FacultyDaoInterface;
import com.app.pojo.Addresses;
import com.app.pojo.Faculty;
import com.app.pojo.Questions;

@Service
@Transactional
public class FacultyService implements FacultyServiceInterface {

	@Autowired
	private FacultyDaoInterface facultyDao;

	@Override
	public String registerFaculty(Faculty f) {
		return facultyDao.registerFaculty(f);
	}

	@Override
	public String addAddress(Integer fid, Addresses address) {
		return facultyDao.addAddress(fid, address);
	}

	@Override
	public String updateImage(Integer id, byte[] imageFile) {
		return facultyDao.updateImage(id, imageFile);
	}

	@Override
	public Questions fetchQuestionByID(int qid) {
		return facultyDao.fetchQuestionByID(qid);
	}

	@Override
	public String addAnswer(int qid, String answer, Faculty f) {
		return facultyDao.addAnswer(qid, answer, f);
	}

	@Override
	public List<Questions> fetchQuestionList() {
		return facultyDao.fetchQuestionList();
	}

	@Override
	public String updateProfile(Faculty faculty, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country) {
		return facultyDao.updateProfile(faculty, name, email, mobile, dob, city, district, state, streetLine, pincode,
				country);
	}

	@Override
	public int countofAnswerByFaculty(Faculty f) {
		return facultyDao.countofAnswerByFaculty(f);
	}

	@Override
	public int countofAnswerLikesFaculty(Faculty f) {
		return facultyDao.countofAnswerLikesFaculty(f);
	}

	@Override
	public int totalQuestionCount() {
		return facultyDao.totalQuestionCount();
	}

	@Override
	public boolean checkLike(Faculty f, int qid) {
		return facultyDao.checkLike(f, qid);
	}

	@Override
	public String addLikeinhistory(Faculty f, int qid) {
		return facultyDao.addLikeinhistory(f, qid);
	}

	@Override
	public String removeLikeinhistory(Faculty f, int qid) {
		return facultyDao.removeLikeinhistory(f, qid);
	}

	@Override
	public List<Questions> fetchQuestionListBySubject(String sub) {
		return facultyDao.fetchQuestionListBySubject(sub);
	}

}
