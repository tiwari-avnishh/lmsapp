package com.lmsapp.lms.lmsapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmsapp.lms.lmsapp.model.StudentInfo;

public interface StudentInfoRepo extends JpaRepository<StudentInfo, String> {

}
