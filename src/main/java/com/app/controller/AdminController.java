package com.app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.pojo.Admin;
import com.app.service.AdminServiceInterface;
import com.app.service.LoginServiceInterface;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminService;

	@Autowired
	private LoginServiceInterface loginService;

	public AdminController() {
		System.out.println("in const of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String showDashboard(HttpSession hs) {
		hs.setAttribute("questionCount", adminService.fetchQuestionCount());
		hs.setAttribute("studentCount", adminService.fetchStudentCount());
		hs.setAttribute("facultyCount", adminService.fetchFacultyCount());
		return "/admin/Dashboard";
	}

	@GetMapping("/adminProfile")
	public String showAdminProfile(HttpSession hs) {
		Admin a = (Admin) hs.getAttribute("userDetails");
		hs.setAttribute("userDetails", loginService.validateAdmin(a.getEmail(), a.getPassword()));
		return "/admin/adminProfile";
	}

	@PostMapping("/updateImage")
	public String updateImage(@RequestParam MultipartFile image, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		try {
			Admin admin = (Admin) hs.getAttribute("userDetails");
			byte[] imageFile = image.getBytes();
			flashMap.addFlashAttribute("success", adminService.updateImage(admin.getId(), imageFile));
			return "redirect:/admin/adminProfile";
		} catch (Exception e) {
			modelMap.addAttribute("errors", "Internal Server Error Occoured");
			return "/admin/adminProfiles";
		}
	}

	@GetMapping("/registredStudent")
	public String showStudentList(HttpSession hs) {
		hs.setAttribute("studentList", adminService.fetchStudents());
		return "/admin/registredStudent";
	}

	@GetMapping("/registredFaculty")
	public String showFacultyList(HttpSession hs) {
		hs.setAttribute("facultyList", adminService.fetchFaculty());
		return "/admin/registredFaculty";
	}

	@GetMapping("/questionList")
	public String showQuestionList(HttpSession hs) {
		hs.setAttribute("questionList", adminService.fetchQuestionList());
		return "/admin/questionList";
	}

	@GetMapping("/inc_que_like")
	public String increseQuestionLike(HttpSession hs, @RequestParam int qid) {
		adminService.increseQlike(qid);
		return "redirect:/admin/questionList";
	}

	@PostMapping("/updateProfile")
	public String updateStudentProfile(@RequestParam String name, @RequestParam String email,
			@RequestParam String mobile, @RequestParam String dob, @RequestParam String city,
			@RequestParam String district, @RequestParam String state, @RequestParam String streetLine,
			@RequestParam String pincode, @RequestParam String country, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		Admin admin = (Admin) hs.getAttribute("userDetails");
		modelMap.addAttribute("success", adminService.updateProfile(admin, name, email, mobile, dob, city, district,
				state, streetLine, pincode, country));
		return "redirect:/admin/adminProfile";
	}

	@GetMapping("/student_status")
	public String toggleStudentLogin(@RequestParam int sid, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		flashMap.addFlashAttribute("success", adminService.toggleStudentLogin(sid));
		return "redirect:/admin/registredStudent";
	}

	@GetMapping("/faculty_status")
	public String toggleFacultyLogin(@RequestParam int fid, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		flashMap.addFlashAttribute("success", adminService.toggleFacultyLogin(fid));
		return "redirect:/admin/registredFaculty";
	}

}
