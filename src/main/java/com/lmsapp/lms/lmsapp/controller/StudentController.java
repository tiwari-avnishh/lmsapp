package com.lmsapp.lms.lmsapp.controller;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lmsapp.lms.lmsapp.dto.ResponseDto;
import com.lmsapp.lms.lmsapp.dto.StudentInfoDto;
import com.lmsapp.lms.lmsapp.model.Material;
import com.lmsapp.lms.lmsapp.model.Response;
import com.lmsapp.lms.lmsapp.model.StudentInfo;
import com.lmsapp.lms.lmsapp.service.MaterialRepo;
import com.lmsapp.lms.lmsapp.service.ResponseRepo;
import com.lmsapp.lms.lmsapp.service.StudentInfoRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentController
{
	
	@Autowired
	StudentInfoRepo srepo;
	
	@Autowired
	ResponseRepo resrepo;
	@Autowired
	MaterialRepo mrepo;
	
	@GetMapping("/stdhome")
	public String showStudentHome(HttpSession session ,HttpServletResponse response ,Model model)
	{
		try
		{
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			if(session.getAttribute("studentid")!=null) 
			{
				StudentInfo sinfo=srepo.findById(session.getAttribute("studentid").toString()).get();
				model.addAttribute("sinfo",sinfo);
				
				StudentInfoDto dto= new StudentInfoDto();
				model.addAttribute("dto",dto);
				
				return"student/studenthome";
			}
			else 
			{
				return"redirect:/studentlogin";
			}
		}
		catch(Exception e)
		{
			return "redirect:/studentlogin";
		}
	}
	@PostMapping("/stdhome")
	public String UploadPic( HttpSession session, RedirectAttributes redirectAttributes,@ModelAttribute StudentInfoDto studentInfoDto) {
		
		if(session.getAttribute("studentid")!=null) {
			
			try {
				
				
				
				MultipartFile filedata=studentInfoDto.getProfilepic();
				String storageFilename=new Date().getTime()+"_"+filedata.getOriginalFilename();
				String uploadDir="public/userprfl/";
				Path uploadPath=Paths.get(uploadDir);
				if(!Files.exists(uploadPath)) {
					
					Files.createDirectories(uploadPath);
				}
				
				try(InputStream inputStream=filedata.getInputStream()){
					Files.copy(inputStream,Paths.get(uploadDir+storageFilename),StandardCopyOption.REPLACE_EXISTING);
				}
				
				StudentInfo std = srepo.findById(session.getAttribute("studentid").toString()).get();
				std.setProfilepic(storageFilename);
				srepo.save(std);
				redirectAttributes.addFlashAttribute("msg", "profile Uploaded Successfully");
				
				return "redirect:/student/stdhome"; 
				
			} catch (Exception e) {
				
				redirectAttributes.addFlashAttribute("msg", "something went wrong"+e.getMessage());
				return "redirect:/student/stdhome"; 
			}
		}
		
		else {
			
			return "redirect:/Studentlogin";
		}
		
	}
	
		
	@GetMapping("/studymaterial")
	public String ShowStudyMaterial(HttpSession session ,Model model) {
		
	try
	{
		if(session.getAttribute("studentid")!=null) 
		{
			StudentInfo s=srepo.getById(session.getAttribute("studentid").toString());
			String program=s.getProgram();
			String branch=s.getBranch();
			String year=s.getYear();
			String materialtype="smat";
			List<Material> mlist=mrepo.getMaterial(program,branch,year,materialtype);
			model.addAttribute("mlist", mlist);
			return "student/viewstudymaterial";
		}
		else
		{
			return "redirect:/studentlogin";
		}
		
	} 
	catch (Exception e) 
	{
		return "redirect:/studentlogin"+e;
		
	}
	
	} 

		
	@GetMapping("/assignment")
	public String ShowAssignment(HttpSession session,Model model) 
	{
		try {
			
			if(session.getAttribute("studentid")!=null) 
			{
				StudentInfo s=srepo.getById(session.getAttribute("studentid").toString());
				String program=s.getProgram();
				String branch=s.getBranch();
			 	String year=s.getYear();
				String materialtype="smat";
				List<Material> mlist=mrepo.getMaterial(program,branch,year,materialtype);
				model.addAttribute("mlist", mlist);
				return "student/viewassignment";
				
			}
			else {
				return "redirect:/studentlogin";
			}
			
		} catch (Exception e)
		{
			return "redirect:/studentlogin";
		}
		
		
		
		
		
	}


		
		@GetMapping("/changepassword")
		public String showChangePassword(HttpSession session, HttpServletResponse response)	
		{
		try 
		{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
		if(session.getAttribute("studentid")!=null)
		{
		return"student/changepassword";	
		}
		else {
		return"redirect:/studentlogin";	
		}
		} 
		catch (Exception ex) 
		{
		return "redirect:/studentlogin";	
		}
		}
			
			@PostMapping("/changepassword")
			public String changePassword(HttpSession session, HttpServletResponse response, HttpServletRequest request, RedirectAttributes attrib)	
			{
			try 
			{
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	
			if(session.getAttribute("studentid")!=null)
			{
				StudentInfo s=srepo.getById(session.getAttribute("studentid").toString());
				String oldpassword=request.getParameter("oldpassword");
				String newpassword=request.getParameter("newpassword");
				String confirmpassword=request.getParameter("confirmpassword");
				if(!newpassword.equals(confirmpassword))
				{
					attrib.addFlashAttribute("msg", "New Passowrd and Confirm password are not matched");
					return "redirect:/student/changepassword";
				}
				if(!oldpassword.equals(s.getPassword()))
				{
					attrib.addFlashAttribute("msg", "Old password is incorrect");
					return "redirect:/student/changepassword";
				}
				s.setPassword(newpassword);
				srepo.save(s);
				return "redirect:/student/logout";
			}
			else {
			return"redirect:/studentlogin";	
			}
			} 
			catch (Exception ex) 
			{
			return "redirect:/studentlogin";	
			}
			}
			
	@GetMapping("/response")
	public String showGiveResponse(HttpSession session, HttpServletResponse response, Model model  )
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		try
		{
			if(session.getAttribute("studentid")!=null)
			{
				ResponseDto dto = new ResponseDto();
				model.addAttribute("dto", dto);
				return "student/giveresponse";
			}
			else
			{
				return "redirect:/studentlogin";
			}
		} catch( Exception e)
		{
			
			return "redirect:/studentlogin";
		}	
	}	
	
	@PostMapping("/response")
	public String SubmitResponse(HttpSession session, @ModelAttribute ResponseDto responseDto, BindingResult result, RedirectAttributes redirectAttributes, Model model)
	{
		try {
			if(session.getAttribute("studentid")!=null)
			{
				StudentInfo std=srepo.getById(session.getAttribute("studentid").toString());
				model.addAttribute("studentid", session.getAttribute("userid"));
				Response res = new Response();
				res.setName(std.getName());
				res.setEnrollmentno(std.getEnrollmentno());
				res.setEmailaddress(std.getEmailaddress());
				res.setContactno(std.getContactno());
				res.setResponsetype(responseDto.getResponsetype());
				res.setSubject(responseDto.getSubject());
				res.setMessage(responseDto.getMessage());
				res.setResdate(new Date()+"");
				resrepo.save(res);
				return "redirect:/student/response";
			}	
			else {
				return "redirect:/student/response";
			}	
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Something went wrong");
			return "redirect:/student/response";
		}
}
	@GetMapping("/logout")
	public String Logout(HttpSession session)
	{
		session.invalidate();
		
		return"redirect:/studentlogin";
	}
	
	
	}
		
		
		

