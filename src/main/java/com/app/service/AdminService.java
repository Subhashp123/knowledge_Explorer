package com.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.AdminDaoInterface;
import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Questions;
import com.app.pojo.Student;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {

	@Autowired
	private AdminDaoInterface adminDao;

	@Override
	public String updateImage(Integer id, byte[] imageFile) {
		return adminDao.updateImage(id, imageFile);
	}

	@Override
	public int fetchQuestionCount() {
		return adminDao.fetchQuestionCount();
	}

	@Override
	public List<Student> fetchStudents() {
		return adminDao.fetchStudents();
	}

	@Override
	public List<Faculty> fetchFaculty() {
		return adminDao.fetchFaculty();
	}

	@Override
	public List<Questions> fetchQuestionList() {
		return adminDao.fetchQuestionList();
	}

	@Override
	public void increseQlike(int qid) {
		adminDao.increseQlike(qid);
	}

	@Override
	public String updateProfile(Admin admin, String name, String email, String mobile, String dob, String city,
			String district, String state, String streetLine, String pincode, String country) {
		return adminDao.updateProfile(admin, name, email, mobile, dob, city, district, state, streetLine, pincode,
				country);
	}

	@Override
	public String toggleStudentLogin(int sid) {
		return adminDao.toggleStudentLogin(sid);
	}

	@Override
	public int fetchStudentCount() {
		return adminDao.fetchStudentCount();
	}

	@Override
	public int fetchFacultyCount() {
		return adminDao.fetchFacultyCount();
	}

	@Override
	public String toggleFacultyLogin(int fid) {
		return adminDao.toggleFacultyLogin(fid);
	}

	@Override
	public void decQlike(int qid) {
		adminDao.decQlike(qid);
	}
}
