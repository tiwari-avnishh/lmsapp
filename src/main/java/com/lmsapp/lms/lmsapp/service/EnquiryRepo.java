package com.lmsapp.lms.lmsapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmsapp.lms.lmsapp.model.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {

}