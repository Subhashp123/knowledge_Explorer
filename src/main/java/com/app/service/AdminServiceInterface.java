package com.app.service;

import java.util.List;

import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Questions;
import com.app.pojo.Student;

public interface AdminServiceInterface {

	String updateImage(Integer id, byte[] imageFile);

	int fetchQuestionCount();

	List<Student> fetchStudents();

	List<Faculty> fetchFaculty();

	List<Questions> fetchQuestionList();

	void increseQlike(int qid);

	String updateProfile(Admin admin, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country);

	String toggleStudentLogin(int sid);

	int fetchStudentCount();

	int fetchFacultyCount();

	String toggleFacultyLogin(int fid);

	void decQlike(int qid);

	

}
