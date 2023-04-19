package com.app.dao;

import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Student;

public interface LoginDaoInterface {

	Admin validateAdmin(String email, String password);

	Student validateStudent(String email, String password);

	Faculty validateFaculty(String email, String password);

}
