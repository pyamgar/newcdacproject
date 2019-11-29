package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.app.pojos.Student;
import com.app.services.LoginService;

@Controller
@RequestMapping("/loginrelated")
public class LoginController 
{
	@Autowired
	private LoginService service;

	@GetMapping("/logins")
	public String getLoginPage( Student s) 
	{
			System.out.println("In getLoginPage " + getClass().getName());
			return "loginrelated/logins";
	}
	
	@PostMapping("/logins")
	public String processLoginForm( Student s,BindingResult res, Model map, HttpSession hs) 
	{
		System.out.println("in process login form ");
		 Student s1=null;
		try 
		{
			if(s.getEmail().equals("admin@admin.com") && s.getPassword().equals("admin"))
			{
				System.out.println("inside admin login");
					hs.setAttribute("student",s);
					map.addAttribute("mesg", "success");
					map.addAttribute("name", s.getName());
					System.out.println("admin detauils"+s.getName());

					System.out.println("after login");
					return "redirect:/showSub";

			}
			else
			{
					System.out.println("in process login form  outside admin form");
	
				 s1 = service.getStudent(s.getEmail());
				 hs.setAttribute("studentSession",s1);
				System.out.println("student name: " +s1.getName());
				
				if(s1==null)
				{
			    map.addAttribute("mesg", "Invalid Email,Pls retry");
					return "loginrelated/logins";
				}
				else
				{
					if( s1.getPassword().equals(s.getPassword()))
					{
							hs.setAttribute("student",s1);
							map.addAttribute("mesg", "success");
							map.addAttribute("name", s1.getName());
							System.out.println("student detauils"+s1.getName());
	
							System.out.println("after login");
							return "redirect:/";
					}
					else
					{
						map.addAttribute("mesg", "Invalid Password , Pls retry");
						return "loginrelated/logins";
					}
				}
			
			
			}
		} 
		catch (Exception e) 
		{
			System.out.println("inside exception");
			map.addAttribute("mesg", "Invalid Email , Pls retry");
			e.printStackTrace();
			return "loginrelated/logins";
		}
				// & redirect clnt to details page.
		// resp.sendRedirect(resp.encodeRedirectURL(....))
//		return "redirect:/cust/details";
	}

	@GetMapping("/register")
	public String getregisterPage( Student s) 
	{
			System.out.println("In getregisterPage " + getClass().getName());
			return "loginrelated/register";
	}
	@PostMapping("/register")
	public String processregisterForm(@ModelAttribute("Student")Student s, Model map) 
	{
		System.out.println("in process register form " + map);
		if( s !=null )
		{
			System.out.println(s.getName());
			System.out.println(s.getEmail());
			System.out.println(s.getMobileNo());
			System.out.println(s.getPassword());
			String msg;
			try 
			{
				msg = service.registerStudent(s);
				if(msg.contains("Failed"))
				{
					map.addAttribute("mesg", "Failed to Register");
					return "loginrelated/register";
				}
				else
				{
					map.addAttribute("mesg", msg);
					return "redirect:/loginrelated/logins";
				}
			} 
			catch (Exception e) 
			{
				map.addAttribute("mesg", "Email Already Exists");
				
				return "redirect:/loginrelated/register";
			}
		}
			map.addAttribute("mesg", "Failed to Register");
			return "loginrelated/register";
	}

	@GetMapping("/logout")
	public String gelogoutPage( Model model , HttpSession hs)
	{
			System.out.println("In getlogoutPage " + getClass().getName());
			Student s = (Student) hs.getAttribute("student");
			model.addAttribute("stud_dtls",s);
			hs.invalidate();
			return "redirect:/";
	}
	@GetMapping("/HomePage")
	public String getHomePage( Model model)
	{
		return "redirect:/";
	}
}

