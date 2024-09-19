package com.lmsapp.lms.lmsapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmsapp.lms.lmsapp.model.AdminLogin;

public interface AdminLoginRepo extends JpaRepository<AdminLogin, String> {

}
