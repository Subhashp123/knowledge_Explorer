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
import com.app.pojo.Faculty;
import com.app.service.AdminServiceInterface;
import com.app.service.FacultyServiceInterface;
import com.app.service.LoginServiceInterface;
import com.app.service.StudentServiceInterface;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	private FacultyServiceInterface facultyService;
	@Autowired
	private LoginServiceInterface loginService;
	@Autowired
	private AdminServiceInterface adminService;
	@Autowired
	private StudentServiceInterface studentService;

	public FacultyController() {
		System.out.println("in const of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String provideDashboard(HttpSession hs) {
		Faculty f = (Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("ansCount", facultyService.countofAnswerByFaculty(f));
		hs.setAttribute("myAnsLikeCount", facultyService.countofAnswerLikesFaculty(f));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		return "/faculty/Dashboard";
	}

	@GetMapping("/facultyProfile")
	public String showMyProfile(HttpSession hs) {
		Faculty a = (Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("userDetails", loginService.validateFaculty(a.getEmail(), a.getPassword()));
		return "/faculty/facultyProfile";
	}

	@PostMapping("/updateImage")
	public String updateImage(@RequestParam MultipartFile image, Model modelMap, RedirectAttributes flashMap,
			HttpSession hs) {
		try {
			Faculty f = (Faculty) hs.getAttribute("userDetails");
			byte[] imageFile = image.getBytes();
			flashMap.addFlashAttribute("success", facultyService.updateImage(f.getId(), imageFile));
			return "redirect:/faculty/facultyProfile";
		} catch (Exception e) {
			modelMap.addAttribute("errors", "Internal Server Error Occoured");
			return "/faculty/facultyProfile";
		}
	}

	@GetMapping("/questionList")
	public String showQuestionList(HttpSession hs) {
		Faculty f = (Faculty) hs.getAttribute("userDetails");
		String sub=f.getSubject();
		hs.setAttribute("ansCount", facultyService.countofAnswerByFaculty(f));
		hs.setAttribute("myAnsLikeCount", facultyService.countofAnswerLikesFaculty(f));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		hs.setAttribute("questionList", facultyService.fetchQuestionListBySubject(sub));
		return "/faculty/questionList";
	}

	@GetMapping("/inc_que_like")
	public String increseQuestionLike(HttpSession hs, @RequestParam int qid,Model modelMap) {
		try {
			Faculty f=(Faculty)hs.getAttribute("userDetails");
			if(facultyService.checkLike(f,qid)) {
				adminService.increseQlike(qid);
				modelMap.addAttribute("iconHeart", facultyService.addLikeinhistory(f,qid));
				return "redirect:/faculty/questionList";
			}else{
				adminService.decQlike(qid);
				modelMap.addAttribute("iconHeart", facultyService.removeLikeinhistory(f,qid));
				return "redirect:/faculty/questionList";
			}
		} catch (Exception e) {
			modelMap.addAttribute("message", "You Already liked this Question");
			return "/faculty/questionList";
		}
	}

	@GetMapping("/question_ans")
	public String provideAnsPage(HttpSession hs, Model modelMap, RedirectAttributes flashMap, @RequestParam int qid) {
		Faculty f = (Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("ansCount", facultyService.countofAnswerByFaculty(f));
		hs.setAttribute("myAnsLikeCount", facultyService.countofAnswerLikesFaculty(f));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		hs.setAttribute("Question", facultyService.fetchQuestionByID(qid));
		return "/faculty/ansPage";
	}

	@GetMapping("/postAnswer")
	public String proideAns(@RequestParam int qid, @RequestParam String answer, Model modelMap,
			RedirectAttributes flashMap, HttpSession hs) {
		Faculty f = (Faculty) hs.getAttribute("userDetails");
		flashMap.addFlashAttribute("success", facultyService.addAnswer(qid, answer, f));
		return "redirect:/faculty/questionList";
	}

	@PostMapping("/updateProfile")
	public String updateFacultyProfile(@RequestParam String name, @RequestParam String email,
			@RequestParam String mobile, @RequestParam String dob, @RequestParam String city,
			@RequestParam String district, @RequestParam String state, @RequestParam String streetLine,
			@RequestParam String pincode, @RequestParam String country, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		Faculty faculty = (Faculty) hs.getAttribute("userDetails");
		modelMap.addAttribute("success", facultyService.updateProfile(faculty, name, email, mobile, dob, city, district,
				state, streetLine, pincode, country));
		return "redirect:/faculty/facultyProfile";
	}

	@GetMapping("/allQuestionList")
	public String showAllQuestionList(HttpSession hs) {
		Faculty f = (Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("ansCount", facultyService.countofAnswerByFaculty(f));
		hs.setAttribute("myAnsLikeCount", facultyService.countofAnswerLikesFaculty(f));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		hs.setAttribute("questionList", facultyService.fetchQuestionList());
		return "/faculty/allQuestionList";
	}

	@GetMapping("/answerPage")
	public String provideAnsPagetoFaculty(HttpSession hs, Model modelMap, RedirectAttributes flashMap,
			@RequestParam int qid) {
		Faculty f = (Faculty) hs.getAttribute("userDetails");
		hs.setAttribute("ansCount", facultyService.countofAnswerByFaculty(f));
		hs.setAttribute("myAnsLikeCount", facultyService.countofAnswerLikesFaculty(f));
		hs.setAttribute("totalQuestionCount", facultyService.totalQuestionCount());
		hs.setAttribute("Question", facultyService.fetchQuestionByID(qid));
		hs.setAttribute("answersList", studentService.fetchAllAnswersByQuestionID(qid));
		return "/faculty/answerPage";
	}

	@GetMapping("/inc_ans_like")
	public String increseAnswerLikefromFaculty(HttpSession hs, @RequestParam int aid, @RequestParam int qid) {
		studentService.increseAlike(aid);
		return "redirect:/faculty/answerPage?qid=" + qid;

	}

}
