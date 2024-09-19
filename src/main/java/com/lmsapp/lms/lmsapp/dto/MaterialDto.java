package com.lmsapp.lms.lmsapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class MaterialDto {
	private String program;
	private String branch;
	private String year;
	private String materialtype;
	private String subject;
	private String topic;
	private String filename;
	private MultipartFile filedata;
	private String posteddata;
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMaterialtype() {
		return materialtype;
	}
	public void setMaterialtype(String materialtype) {
		this.materialtype = materialtype;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public MultipartFile getFiledata() {
		return filedata;
	}
	public void setFiledata(MultipartFile filedata) {
		this.filedata = filedata;
	}
	public String getPosteddata() {
		return posteddata;
	}
	public void setPosteddata(String posteddata) {
		this.posteddata = posteddata;
	}
	
public String getfilename() {
	return filename;}
	public void setfilename(String filename){
		this.filename = filename;
	}


	

}
