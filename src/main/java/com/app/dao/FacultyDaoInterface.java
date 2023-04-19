package com.app.dao;

import java.util.List;

import com.app.pojo.Addresses;
import com.app.pojo.Faculty;
import com.app.pojo.Questions;

public interface FacultyDaoInterface {

	String registerFaculty(Faculty f);

	String addAddress(Integer fid, Addresses address);

	String updateImage(Integer id, byte[] imageFile);

	Questions fetchQuestionByID(int qid);

	String addAnswer(int qid, String answer, Faculty f);

	List<Questions> fetchQuestionList();

	String updateProfile(Faculty faculty, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country);

	int countofAnswerByFaculty(Faculty f);

	int countofAnswerLikesFaculty(Faculty f);

	int totalQuestionCount();

	boolean checkLike(Faculty f, int qid);

	String addLikeinhistory(Faculty f, int qid);

	String removeLikeinhistory(Faculty f, int qid);

	List<Questions> fetchQuestionListBySubject(String sub);

}
