package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LoginDaoInterface;
import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Student;

@Service
@Transactional
public class LoginService implements LoginServiceInterface {

	@Autowired
	private LoginDaoInterface loginDao;

	@Override
	public Admin validateAdmin(String email, String password) {
		return loginDao.validateAdmin(email, password);
	}

	@Override
	public Student validateStudent(String email, String password) {
		return loginDao.validateStudent(email, password);
	}

	@Override
	public Faculty validateFaculty(String email, String password) {
		return loginDao.validateFaculty(email, password);
	}
}
