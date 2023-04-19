package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Student;

@Repository
public class LoginDao implements LoginDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public Admin validateAdmin(String email, String password) {
		try {
			String selectQuery = "select a from Admin a where a.email=:email and a.password=:password";
			Admin admin = mgr.createQuery(selectQuery, Admin.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
			if (admin != null)
				return admin;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}

	@Override
	public Student validateStudent(String email, String password) {
		try {
			String selectQuery = "select a from Student a where a.email=:email and a.password=:password and a.status=:sta";
			Student student = mgr.createQuery(selectQuery, Student.class).setParameter("email", email)
					.setParameter("password", password).setParameter("sta", "Active").getSingleResult();
			if (student != null)
				return student;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}

	@Override
	public Faculty validateFaculty(String email, String password) {
		try {
			String selectQuery = "select a from Faculty a where a.email=:email and a.password=:password and a.status=:sta";
			Faculty faculty = mgr.createQuery(selectQuery, Faculty.class).setParameter("email", email)
					.setParameter("password", password).setParameter("sta", "Active").getSingleResult();
			if (faculty != null)
				return faculty;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}

}
