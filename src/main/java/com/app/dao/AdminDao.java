package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Addresses;
import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Questions;
import com.app.pojo.Student;

@Repository
public class AdminDao implements AdminDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String updateImage(Integer id, byte[] imageFile) {
		try {
			Admin a = mgr.find(Admin.class, id);
			a.setImage(imageFile);
			return "Profile Image Updated Successfully";
		} catch (Exception e) {
			return "internal Error Occoured";
		}

	}

	@Override
	public int fetchQuestionCount() {
		String jpql = "select q from Questions q";
		List<Questions> queList = mgr.createQuery(jpql, Questions.class).getResultList();
		int count = 0;
		for (@SuppressWarnings("unused")
		Questions q : queList) {
			count++;
		}
		return count;
	}

	@Override
	public List<Student> fetchStudents() {
		String jpql = "select s from Student s";
		return mgr.createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public List<Faculty> fetchFaculty() {
		String jpql = "select f from Faculty f";
		return mgr.createQuery(jpql, Faculty.class).getResultList();
	}

	@Override
	public List<Questions> fetchQuestionList() {
		String jpql = "select q from Questions q";
		return mgr.createQuery(jpql, Questions.class).getResultList();
	}

	@Override
	public void increseQlike(int qid) {
		Questions que = mgr.find(Questions.class, qid);
		que.setLikes(que.getLikes() + 1);

	}

	@Override
	public String updateProfile(Admin admin, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country) {
		Admin a = mgr.find(Admin.class, admin.getId());
		Addresses add = new Addresses(city, district, state, country, streetLine, Integer.parseInt(pincode));
		a.setName(name);
		a.setEmail(email);
		a.setMobile(mobile);
		a.setDob(dob);
		a.setAddress(add);
		return "Your Profile is updated";
	}

	@Override
	public String toggleStudentLogin(int sid) {
		Student stu = mgr.find(Student.class, sid);
		String status = stu.getStatus();
		if (status.equals("Active")) {
			stu.setStatus("Inactive");
			return "Inactivated User";
		} else {
			stu.setStatus("Active");
			return "Activated User";
		}
	}

	@Override
	public int fetchStudentCount() {
		String jpql = "select s from Student s";
		List<Student> stdList = mgr.createQuery(jpql, Student.class).getResultList();
		int count = 0;
		for (@SuppressWarnings("unused")
		Student s : stdList) {
			count++;
		}
		return count;
	}

	@Override
	public int fetchFacultyCount() {
		String jpql = "select f from Faculty f";
		
		List<Faculty> facList = mgr.createQuery(jpql, Faculty.class).getResultList();
		int count = 0;
		for (@SuppressWarnings("unused")
		Faculty f : facList) {
			count++;
		}
		return count;
	}

	@Override
	public String toggleFacultyLogin(int fid) {
		Faculty fac = mgr.find(Faculty.class, fid);
		String status = fac.getStatus();
		if (status.equals("Active")) {
			fac.setStatus("Inactive");
			return "Inactivated User";
		} else {
			fac.setStatus("Active");
			return "Activated User";
		}
	}

	@Override
	public void decQlike(int qid) {
		Questions que = mgr.find(Questions.class, qid);
		que.setLikes(que.getLikes() - 1);
	}
}
