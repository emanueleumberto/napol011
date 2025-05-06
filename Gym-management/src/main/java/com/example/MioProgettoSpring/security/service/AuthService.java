package com.example.MioProgettoSpring.security.service;

import com.example.SpringSecurityTemplate.security.payload.LoginDto;
import com.example.SpringSecurityTemplate.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
