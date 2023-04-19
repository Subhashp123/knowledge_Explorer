package com.app.service;

import java.util.List;

import com.app.pojo.Addresses;
import com.app.pojo.Answers;
import com.app.pojo.Questions;
import com.app.pojo.Student;

public interface StudentServiceInterface {

	String registerStudent(Student s);

	String addAddress(Integer sid, Addresses address);

	String updateImage(Integer id, byte[] imageFile);

	String postQuestion(Integer id, String question,String subject);

	List<Questions> fetchAllQuestions(Integer id);

	List<Answers> fetchAllAnswersByQuestionID(int qid);

	List<Questions> searchQuestionByKeyword(String searchkey);

	String toggleQuestionStatus(int qid);

	String removeQuestion(int qid);

	String updateProfile(Student student, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country);

	void increseAlike(int aid);

	int countOfQuestions(Student s);

	int countOFQuestionLikes(Student s);
	boolean checkLike(Student s, int qid);

	String addLikeinhistory(Student s, int qid);

	String removeLikeinhistory(Student s, int qid);

}
