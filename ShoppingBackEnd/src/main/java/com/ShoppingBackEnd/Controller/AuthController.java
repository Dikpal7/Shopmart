package com.ShoppingBackEnd.Controller;

import com.ShoppingBackEnd.payload.LoginRequest;
import com.ShoppingBackEnd.payload.ResetPassword;
import com.ShoppingBackEnd.payload.SignUpRequest;
import com.ShoppingBackEnd.Service.EmailSenderService;
import com.ShoppingBackEnd.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

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
		return _emailService.sendEmail(email);
	}

	@PostMapping("/verifyToken")
	public Boolean verifyToken(@Valid @RequestBody String token) {
		return _emailService.verifyToken(token) ;
	}

}