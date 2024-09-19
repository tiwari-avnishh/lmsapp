package com.lmsapp.lms.lmsapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lmsapp.lms.api.SmsSender;
import com.lmsapp.lms.lmsapp.dto.AdminLoginDto;
import com.lmsapp.lms.lmsapp.dto.EnquiryDto;
import com.lmsapp.lms.lmsapp.dto.StudentInfoDto;
import com.lmsapp.lms.lmsapp.model.AdminLogin;
import com.lmsapp.lms.lmsapp.model.Enquiry;
import com.lmsapp.lms.lmsapp.model.StudentInfo;
import com.lmsapp.lms.lmsapp.service.AdminLoginRepo;
import com.lmsapp.lms.lmsapp.service.EnquiryRepo;
import com.lmsapp.lms.lmsapp.service.StudentInfoRepo;

import aj.org.objectweb.asm.Attribute;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;



@Controller
public class MainController {
	
	@Autowired
	EnquiryRepo erepo;
	
	@Autowired
	StudentInfoRepo stdrepoRepo;
	
	@Autowired
	AdminLoginRepo adrepo;
	
	
	@GetMapping("/contactus")
	public String showContactus(Model model)
	{
		EnquiryDto dto=new EnquiryDto();
		model.addAttribute("dto", dto);
		return "contactus";
		
	}
	
	@GetMapping("/index")
	public String showIndex()
	{
		return "index";
	}
	
	@GetMapping("/studentlogin")
	public String showLogin(Model model)
	{
		StudentInfoDto dto=new StudentInfoDto();
		model.addAttribute("dto", dto);
		return "studentlogin";
	}
	
	@PostMapping("/studentlogin")
	public String validateStudent(@ModelAttribute StudentInfoDto dto, HttpSession session, RedirectAttributes attrib) {
		
		try {
			StudentInfo s=stdrepoRepo.getById(dto.getEnrollmentno());
			if(s.getPassword().equals(dto.getPassword()))
			{
				session.setAttribute("studentid", s.getEnrollmentno());
				return "redirect:/student/stdhome";
			}
			else
			{
				attrib.addFlashAttribute("message", "Invalid User");
			}
			return "redirect:/studentlogin";
			
			
		} catch (EntityNotFoundException e) {
			// TODO: handle exception
			attrib.addFlashAttribute("message", "Student does not exist"+e.getMessage());
			return "redirect:/studentlogin";
		}
		
	}
	
	@PostMapping("/contactus")
	public String SubmitEnquiry(@ModelAttribute EnquiryDto enquiryDto, BindingResult result, RedirectAttributes redirectAttributes)
	{
		try {
			
			Enquiry eq=new Enquiry();
			eq.setName(enquiryDto.getName());
			eq.setGender(enquiryDto.getGender());
			eq.setContactno(enquiryDto.getContactno());
			eq.setEmailaddress(enquiryDto.getEmailaddress());
			eq.setEnquirytext(enquiryDto.getEnquirytext());
			eq.setPosteddate(new Date()+"");
			erepo.save(eq);
			SmsSender ss=new SmsSender();
			ss.sendSms(enquiryDto.getContactno());
			redirectAttributes.addFlashAttribute("message", "Your Response Submitted Successfully");
			return "redirect:/contactus";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Something went wrong");
			return "redirect:/contactus";
		}
	}
	
	@GetMapping("/registration")
	public String showRegistration(Model model)
	{
		StudentInfoDto dto=new StudentInfoDto();
		model.addAttribute("dto", dto);
		return "/registration";
	}

	@PostMapping("/registration")
	public String Registration(@ModelAttribute StudentInfoDto studentInfoDto, RedirectAttributes redirectAttributes)
	{
		try {
			StudentInfo std= new StudentInfo();
			std.setEnrollmentno(studentInfoDto.getEnrollmentno());
			std.setName(studentInfoDto.getName());
			std.setFname(studentInfoDto.getFname());
			std.setMname(studentInfoDto.getMname());
			std.setGender(studentInfoDto.getGender());
			std.setAddress(studentInfoDto.getAddress());
			std.setProgram(studentInfoDto.getProgram());
			std.setBranch(studentInfoDto.getBranch());
			std.setYear(studentInfoDto.getYear());
			std.setContactno(studentInfoDto.getContactno());
			std.setEmailaddress(studentInfoDto.getEmailaddress());
			std.setPassword(studentInfoDto.getPassword());
			std.setRegdate(new Date()+"");
			stdrepoRepo.save(std);
			redirectAttributes.addFlashAttribute("massage", "registrtion success");
			return "redirect:/registration";
			
			
		}
		catch (Exception e) 
		{
			redirectAttributes.addFlashAttribute("message", "some thing went worng" +e.getMessage());
			return"redirect:/registration";
		}
		
		}

	
	
	@GetMapping("/adminlogin")
	public String ShowAdminLogin(Model model)
	{
		AdminLoginDto dto=new AdminLoginDto();
		model.addAttribute("dto", dto);
		return "adminlogin";
	}

	@PostMapping("/adminlogin")
	public String Adminlogin(@ModelAttribute AdminLoginDto adminLoginDto , HttpSession session, RedirectAttributes redirectAttributes)
	{
		try {
			
			AdminLogin admin = adrepo.getById(adminLoginDto.getUserid());
			if(admin.getPassword().equals(adminLoginDto.getPassword()))
			{
				//redirectAttributes.addFlashAttribute("msg", "Valid user");
				session.setAttribute("adminid", adminLoginDto.getUserid());
				return "redirect:/admin/adhome";
			}
			else
			{
				redirectAttributes.addFlashAttribute("msg", "Invalid user");
				return "redirect:/adminlogin";
			}
		} 
		catch (Exception e) 
		{
			redirectAttributes.addFlashAttribute("msg", "user does not exists");
			return "redirect:/adminlogin";
		}
	}
	@GetMapping("/aboutus")
	public String showAbout(Model model)
	{
		return "aboutus";
	}
}





	
	
	
	
	
	

		

