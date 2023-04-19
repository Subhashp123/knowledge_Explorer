package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojo.Admin;
import com.app.pojo.Faculty;
import com.app.pojo.Student;
import com.app.service.LoginServiceInterface;
import com.app.utility.Utility;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceInterface loginService;

	public LoginController() {
		System.out.println("in const of" + getClass().getName());
	}

	@PostMapping("/login")
	public String validateLogin(@RequestParam String email, @RequestParam String password, Model modelMap,
			RedirectAttributes flashMap, HttpSession hs) {
		try {
			if (Utility.validateEmail(email) && Utility.ValidatePassword(password)) {
				Admin admin = loginService.validateAdmin(email, password);
				Student student = loginService.validateStudent(email, password);
				Faculty faculty = loginService.validateFaculty(email, password);
				if (admin != null) {
					hs.setAttribute("userDetails", admin);
					return "redirect:/admin/Dashboard";
				} else if (student != null) {
					hs.setAttribute("userDetails", student);
					return "redirect:/student/Dashboard";
				} else if (faculty != null) {
					hs.setAttribute("userDetails", faculty);
					return "redirect:/faculty/Dashboard";
				} else {
					modelMap.addAttribute("error", "User is Not Rregistred");
					return "/index";
				}
			} else {
				modelMap.addAttribute("error", "Invalid Credentials");
				return "/index";
			}
		} catch (Exception e) {
			modelMap.addAttribute("error", "Internal Server Error Occoured");
			return "/index";
		}

	}

	@GetMapping("/logout")
	public String endLoginSession(HttpSession hs) {
		hs.getAttribute("userDetails");
		hs.invalidate();
		return "redirect:/";
	}
}
