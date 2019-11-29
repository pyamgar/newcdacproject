package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Subject;
import com.app.pojos.Topic;
import com.app.services.LoginService;
import com.app.services.leftMenuService;

@Controller("menuController")
public class menuController {
	@Autowired
	private leftMenuService service;
	
	List<Subject> sub;
	@RequestMapping("/")
	public  String getLeftLoginPage(Model model) 
   {
	System.out.println("inside homepage");	
	try {
		sub=service.fetchTitles();
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
	return "index";
   }
@RequestMapping("topics")
public String fetchTopics(Model model, @RequestParam(required = false, value ="subid") Integer subid)
{
         System.out.println("inside topics controller id :"+subid); 
         
     	List<Topic> top=service.fetchTopics(subid);
     	
		System.out.println("after topics");
		for (Topic topic : top) {
			System.out.println(topic.getName());
		}
		model.addAttribute("sub",sub);
        model.addAttribute("topics", top);
       return "menuController/topics";
	}


@RequestMapping("questions")
public String fetchQuestions(Model model, @RequestParam(required = false, value ="Tid") Integer tid){

	System.out.println("questions controller id :"+tid); 
	model.addAttribute("sub",sub);

	model.addAttribute("questions", service.fetchQuestions(tid));
	return "menuController/questions"; 
	}

}
