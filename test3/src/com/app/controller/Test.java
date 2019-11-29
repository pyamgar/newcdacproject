package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Topic;
import com.app.services.AdminService;
import com.app.services.leftMenuService;
import com.app.services.leftMenuServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.tracing.dtrace.ProviderAttributes;

@Controller
public class Test {
@Autowired
AdminService service;
@Autowired 
leftMenuService menuser;
	@RequestMapping("/admin")
	public String show()
	{
		return "admin/admin";
	}
	
	List<Subject> sub;
	@RequestMapping("showSub")
	public  String showSub(Model model) 
	{
		System.out.println("inside homepage");	
		try {
			sub=menuser.fetchTitles();
			System.out.println("after leftmenu");
			for (Subject subject : sub) {
				
				System.out.println(subject.getName());
					
			}

			model.addAttribute("sub",sub);
				
		    } 
		catch (Exception e) {
		System.out.println("inside Exception");
		e.printStackTrace();
		}	
	return "admin/admin";
	}

@RequestMapping("showTopics")
public String fetchTopics(Model model, @RequestParam(required = false, value ="subid") Integer subid)
{
         System.out.println("inside topics controller id :"+subid); 
         
     	List<Topic> top=menuser.fetchTopics(subid);
     	
		System.out.println("after topics");
		for (Topic topic : top) {
			System.out.println(topic.getName());
		}
		model.addAttribute("sub",sub);
        model.addAttribute("topics", top);
    	return "admin/topics";
	}
@RequestMapping("showQuestions")
public String fetchQuestions(Model model, @RequestParam(required = false, value ="Tid") Integer tid){

	System.out.println("questions controller id :"+tid); 
	model.addAttribute("sub",sub);

	model.addAttribute("questions", menuser.fetchQuestions(tid));
	return "admin/questions";
	}
@RequestMapping("showStudents")
public  String showStudent(Model model) 
{
	System.out.println("inside homepage");	
	try {
		List<Student> students=service.geyStudent();
		System.out.println("show students");
		for (Student subject : students) {
			
			System.out.println(subject.getName());
				
		}

		model.addAttribute("students",students);
			
	    } 
	catch (Exception e) {
	System.out.println("inside Exception");
	e.printStackTrace();
	}	
return "admin/student";
}
@RequestMapping("insertQuestion")
	public String insertQuestion(Question q,@RequestParam(required = false, value ="Tid") Integer tid){
		
		System.out.println("inside insert Question"+tid);
		return "admin/insertQuestion";
	}
@PostMapping("insertQuestion")
public String processInsertQuestion(Question q,BindingResult res, Model map,@RequestParam(required = false, value ="Tid") Integer tid){
	
	System.out.println("inside process insert Question is"+tid);
	service.insertQuestions(q,tid);
	System.out.println(q.toString());
	return "admin/insertQuestion";
}

@RequestMapping("updateQuestion")
	public String updateQuestion(Question q,@RequestParam(required = false, value ="Tid") Integer tid){
		
		System.out.println("inside update Question"+tid);
		return "admin/updateQuestion"
				+ "";
	}
@PostMapping("updateQuestion")
public String processUpdateQuestion(Question q,BindingResult res, Model map,@RequestParam(required = false, value ="Tid") Integer tid){
	
	System.out.println("inside process updat Question is"+tid);
	service.insertQuestions(q,tid);
	System.out.println(q.toString());
	return "admin/updateQuestion";
}

@RequestMapping("deleteQuestion")
	public String deleteQuestion(@RequestParam(required = false, value ="Tid") Integer tid){
		
		System.out.println("inside delete Question"+tid);
		service.deleteQuestions(tid);
		return "admin/topics"
				+ "";
	}

@RequestMapping("insertTopic")
public String insertTopic(@RequestParam(required = false, value ="Tid") Integer tid){
	
	System.out.println("inside insert Sub"+tid);
	//service.deleteSub(tid);
	return "redirect:/showTopic";
}
@RequestMapping("updateTopic")
public String updateTopic(@RequestParam(required = false, value ="Tid") Integer tid){
	
	System.out.println("inside updateSub Sub"+tid);
	//service.deleteSub(tid);
	return "redirect:/showTopic";
}


@RequestMapping("deleteTopic")
	public String deleteTopic(@RequestParam(required = false, value ="Tid") Integer tid){
		
		System.out.println("inside delete Question"+tid);
		service.deleteTopic(tid);
		return "redirect:/showSub";
	}


@RequestMapping("showindertSub")
public String insertSub(Subject s,BindingResult res){
	
	System.out.println("inside show insert Sub");

	return "admin/insertSub";
}

@PostMapping("showindertSub")
public String processinsertSub(Subject s,BindingResult res){
	
	System.out.println("inside insert Sub"+s.getName());
	
	service.insertSub(s);
	return "redirect:/showSub";
}

@RequestMapping("updateSub")
public String updateSub(@RequestParam(required = false, value ="Tid") Integer tid){
	
	System.out.println("inside updateSub Sub"+tid);
	//service.deleteSub(tid);
	return "redirect:/showSub";
}
@RequestMapping("deleteSub")
public String deleteSub(@RequestParam(required = false, value ="Tid") Integer tid){
	
	System.out.println("inside delete Sub"+tid);
	service.deleteSub(tid);
	return "redirect:/showSub";
}
}
