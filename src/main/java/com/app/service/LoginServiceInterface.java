package com.app.service;

import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Student;

public interface LoginServiceInterface {

	Admin validateAdmin(String email, String password);

	Student validateStudent(String email, String password);

	Faculty validateFaculty(String email, String password);

}
