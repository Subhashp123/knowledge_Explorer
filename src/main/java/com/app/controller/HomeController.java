package com.app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.pojo.Addresses;
import com.app.pojo.Faculty;
import com.app.pojo.Student;
import com.app.service.FacultyServiceInterface;
import com.app.service.StudentServiceInterface;
import com.app.utility.TLSEmail;
import com.app.utility.Utility;

@Controller
public class HomeController {

	@Autowired
	private StudentServiceInterface studentService;

	@Autowired
	private FacultyServiceInterface facultyService;

	public HomeController() {
		System.out.println("in const of " + getClass().getName());
	}

	@GetMapping("/")
	public String provideHomePage() {
		return "/index";
	}

	@GetMapping("/registrationPage")
	public String provideRegistrationPage() {
		return "/registrationPage";
	}

	@PostMapping("/register")
	public String registerUser(HttpSession hs, Model modelMap, RedirectAttributes flashMap,
			@RequestParam String usertype, @RequestParam String name, @RequestParam String subject, @RequestParam String email,
			@RequestParam String mobile, @RequestParam String dob, @RequestParam MultipartFile image,
			@RequestParam String password, @RequestParam String cpassword) {
		try {
			byte[] imageFile = image.getBytes();
			if (password.equals(cpassword)) {
				if (Utility.validateDateOfBirth(dob)) {
					//TLSEmail emailSender = new TLSEmail();
					if (usertype.equals("student")) {
						Student s = new Student(name, email, password, mobile, dob, imageFile, "Active");
						modelMap.addAttribute("success", studentService.registerStudent(s));
						hs.setAttribute("userDetails", s);
						return "/provideAddress";
					} else {
						Faculty f = new Faculty(name,subject, email, password, mobile, dob, imageFile, "Active");
						modelMap.addAttribute("success", facultyService.registerFaculty(f));
						hs.setAttribute("userDetails", f);
						return "/provideAddress";
					}
				} else {
					modelMap.addAttribute("errors", "Invalid Date Of Birth");
					return "/registrationPage";
				}
			} else{
				modelMap.addAttribute("errors", "Password Not Matched");
				return "/registrationPage";
			}
		} catch (

		Exception e) {
			modelMap.addAttribute("errors", "Internal Server Error Occoured" + e);
			return "/registrationPage";
		}
	}

	@PostMapping("/addAddress")
	public String addAddress(@RequestParam String city, @RequestParam String district, @RequestParam String state,
			@RequestParam String streetline, @RequestParam String pincode, @RequestParam String country, HttpSession hs,
			Model modelMap, RedirectAttributes flashMap) {
		Addresses address = new Addresses(city, district, state, country, streetline, Integer.parseInt(pincode));
		try {
			Student s = (Student) hs.getAttribute("userDetails");
			if (s != null) {
				modelMap.addAttribute("error", studentService.addAddress(s.getId(), address));
				return "/index";
			}
		} catch (Exception e) {
			Faculty f = (Faculty) hs.getAttribute("userDetails");
			if (f != null) {
				modelMap.addAttribute("error", facultyService.addAddress(f.getId(), address));
				return "/index";
			}
		}
		return "/index";
	}

}
