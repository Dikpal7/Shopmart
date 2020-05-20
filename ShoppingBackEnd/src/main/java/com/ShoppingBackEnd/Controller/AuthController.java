package com.ShoppingBackEnd.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingBackEnd.Service.AuthService;
import com.ShoppingBackEnd.Service.EmailSenderService;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.LoginRequest;
import com.ShoppingBackEnd.payload.ResetPassword;
import com.ShoppingBackEnd.payload.SignUpRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService _service;

	@Autowired
	EmailSenderService _emailService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return _service.authenticateUser(loginRequest);
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		return _service.registerUser(signUpRequest);
	}

	@PostMapping("/resetPassword")
	public Boolean resetPassword(@Valid @RequestBody ResetPassword resetPwdData) {
		return _service.resetPassword(resetPwdData);
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@Valid @RequestBody String email) {
		if(_emailService.verifyEmail(email))
			return _emailService.sendEmail(email);
		else
			return new ResponseEntity<Object>(new ApiResponse(false, "Email does not exist!"), HttpStatus.BAD_REQUEST);
			
	}

	@PostMapping("/verifyToken")
	public Boolean verifyToken(@Valid @RequestBody String token) {
		return _emailService.verifyToken(token);
	}

}