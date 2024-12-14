package edu.cjc.smsapp.app.controller;

import java.util.List;

import javax.sound.sampled.ReverbType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.smsapp.app.model.Student;
import edu.cjc.smsapp.app.servicei.StudentServiceI;

@Controller
public class AdminController {

	@Autowired
	StudentServiceI ssi;
	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String onLogin(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		
		   if(username.equals("admin")  && password.equals("admin")) {
			   List<Student> list=ssi.getAllStudents();
			   m.addAttribute("data", list);
			   return "adminscreen";
		   }
		   else {
			   m.addAttribute("login_fail","invalid creaditail");
			   return "login";
		   }
	
	}
	
	
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s,Model m) {
		ssi.saveStudentDetails(s);
//		  List<Student> list=ssi.getAllStudents();
//		   m.addAttribute("data", list);
//		   return "adminscreen";
		return "login";
	}
	@RequestMapping("/search")
public String searchBatch(@RequestParam("batchNumber") String batchNumber,Model m) {
		List<Student> result=ssi.searchBatch(batchNumber);
		if(result.size()>0)
		{
			m.addAttribute("data", result);
		}else {
			m.addAttribute("message","No Record are found for this  "+batchNumber);
		}
		
	return "adminscreen";
}
	@RequestMapping("/fees")
	public String onFees(@RequestParam("id") int id,Model m) {
		
		    Student st=ssi.getSingleStudent(id);
		m.addAttribute("st", st);
		return "fees";
	}
	@RequestMapping("/payfees")
	public String payFees(@RequestParam("studentid") int studentid,@RequestParam("ammount") float ammount,Model m) {
		
		List<Student> list=ssi.updateStudentfees(studentid,ammount);
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	
	
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam("id") int id,Model m) {
		
		 ssi.removeDelete(id);
		
		List<Student> list=ssi.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	
	
	
	
	
	
	
}
