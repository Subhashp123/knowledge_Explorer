package com.app.controller;

import java.util.List;

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

import com.app.pojo.Questions;
import com.app.pojo.Student;
import com.app.service.AdminServiceInterface;
import com.app.service.FacultyServiceInterface;
import com.app.service.LoginServiceInterface;
import com.app.service.StudentServiceInterface;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private FacultyServiceInterface facultyService;
	@Autowired
	private StudentServiceInterface studentService;
	@Autowired
	private LoginServiceInterface loginService;
	@Autowired
	private AdminServiceInterface adminService;

	public StudentController() {
		System.out.println("in cont of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String proideDashboard(HttpSession hs) {
		Student s = (Student) hs.getAttribute("userDetails");
		hs.setAttribute("myQuestionCount", studentService.countOfQuestions(s));
		hs.setAttribute("myTotalLikes", studentService.countOFQuestionLikes(s));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		return "/student/Dashboard";
	}

	@GetMapping("/studentProfile")
	public String showMyProfile(HttpSession hs) {
		Student a = (Student) hs.getAttribute("userDetails");
		hs.setAttribute("userDetails", loginService.validateStudent(a.getEmail(), a.getPassword()));
		return "/student/studentProfile";
	}

	@PostMapping("/updateImage")
	public String updateImage(@RequestParam MultipartFile image, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		try {
			Student s = (Student) hs.getAttribute("userDetails");
			byte[] imageFile = image.getBytes();
			flashMap.addFlashAttribute("success", studentService.updateImage(s.getId(), imageFile));
			return "redirect:/student/studentProfile";
		} catch (Exception e) {
			modelMap.addAttribute("errors", "Internal Server Error Occoured");
			return "/student/studentProfile";
		}
	}

	@GetMapping("/addQuestion")
	public String showAddQuestion(HttpSession hs) {
		Student s = (Student) hs.getAttribute("userDetails");
		hs.setAttribute("myQuestionCount", studentService.countOfQuestions(s));
		hs.setAttribute("myTotalLikes", studentService.countOFQuestionLikes(s));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		hs.setAttribute("questionList", studentService.fetchAllQuestions(s.getId()));
		return "/student/addQuestion";
	}

	@PostMapping("/postQuestion")
	public String postQuestion(@RequestParam String question,@RequestParam String subject, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		Student student = (Student) hs.getAttribute("userDetails");
		Student s = (Student) hs.getAttribute("userDetails");
		hs.setAttribute("myQuestionCount", studentService.countOfQuestions(s));
		hs.setAttribute("myTotalLikes", studentService.countOFQuestionLikes(s));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		modelMap.addAttribute("success", studentService.postQuestion(student.getId(), question,subject));

		return "redirect:/student/addQuestion";
	}

	@GetMapping("/myQuestion")
	public String showMyQuestions(HttpSession hs) {
		Student s = (Student) hs.getAttribute("userDetails");
		hs.setAttribute("myQuestionCount", studentService.countOfQuestions(s));
		hs.setAttribute("myTotalLikes", studentService.countOFQuestionLikes(s));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		hs.setAttribute("questionList", studentService.fetchAllQuestions(s.getId()));
		return "/student/myQuestion";
	}

	@GetMapping("/questionAnswer")
	public String provideAnsPage(HttpSession hs, Model modelMap, RedirectAttributes flashMap, @RequestParam int qid) {
		hs.setAttribute("Question", facultyService.fetchQuestionByID(qid));
		hs.setAttribute("answersList", studentService.fetchAllAnswersByQuestionID(qid));
		return "/student/questionAnswer";
	}

	@PostMapping("/searchQuestion")
	public String provideSearchQuestion(HttpSession hs, Model modelMap, @RequestParam String searchkey) {
		Student s = (Student) hs.getAttribute("userDetails");
		hs.setAttribute("myQuestionCount", studentService.countOfQuestions(s));
		hs.setAttribute("myTotalLikes", studentService.countOFQuestionLikes(s));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		List<Questions> searchQuestion = studentService.searchQuestionByKeyword(searchkey);
		if (searchQuestion != null) {
			hs.setAttribute("searchQuestionList", searchQuestion);
			return "/student/searchQuestion";
		} else {
			modelMap.addAttribute("error", "No Data Found");
			return "/student/searchQuestion";
		}
	}

	@GetMapping("/question_status")
	public String toggleQuestionStatus(@RequestParam int qid, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("success", studentService.toggleQuestionStatus(qid));
		return "redirect:/student/addQuestion";
	}

	@GetMapping("/question_statu_toggle")
	public String toggleQuestionStatusSecond(@RequestParam int qid, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("success", studentService.toggleQuestionStatus(qid));
		return "redirect:/student/myQuestion";
	}

	@GetMapping("/question_delete")
	public String removeQuestion(@RequestParam int qid, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("success", studentService.removeQuestion(qid));
		return "redirect:/student/myQuestion";
	}

	@PostMapping("/updateProfile")
	public String updateStudentProfile(@RequestParam String name, @RequestParam String email,
			@RequestParam String mobile, @RequestParam String dob, @RequestParam String city,
			@RequestParam String district, @RequestParam String state, @RequestParam String streetLine,
			@RequestParam String pincode, @RequestParam String country, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		Student student = (Student) hs.getAttribute("userDetails");
		modelMap.addAttribute("success", studentService.updateProfile(student, name, email, mobile, dob, city, district,
				state, streetLine, pincode, country));
		return "redirect:/student/studentProfile";
	}

	@GetMapping("/inc_ans_like")
	public String increseAnswerLike(HttpSession hs, @RequestParam int aid, @RequestParam int qid) {
		studentService.increseAlike(aid);
		return "redirect:/student/questionAnswer?qid=" + qid;
	}

	@GetMapping("/inc_que_like")
	public String increseQuestionLike(HttpSession hs, @RequestParam int qid,Model modelMap) {
		try {
			Student s=(Student)hs.getAttribute("userDetails");
			if(studentService.checkLike(s,qid)) {
				adminService.increseQlike(qid);
				modelMap.addAttribute("iconHeart", studentService.addLikeinhistory(s,qid));
				return "redirect:/student/allQuestionList";
			}else{
				adminService.decQlike(qid);
				modelMap.addAttribute("iconHeart", studentService.removeLikeinhistory(s,qid));
				return "redirect:/student/allQuestionList";
			}
		} catch (Exception e) {
			modelMap.addAttribute("message", "You Already liked this Question");
			return "/student/allQuestionList";
		}
		
	}

	@GetMapping("/allQuestionList")
	public String showAllQuestionList(HttpSession hs) {
		Student s = (Student) hs.getAttribute("userDetails");
		hs.setAttribute("myQuestionCount", studentService.countOfQuestions(s));
		hs.setAttribute("myTotalLikes", studentService.countOFQuestionLikes(s));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		hs.setAttribute("questionList", facultyService.fetchQuestionList());
		return "/student/allQuestionList";
	}
}
