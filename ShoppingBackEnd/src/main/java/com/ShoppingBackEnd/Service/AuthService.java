package com.ShoppingBackEnd.Service;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ShoppingBackEnd.Model.ConfirmationToken;
import com.ShoppingBackEnd.Model.Role;
import com.ShoppingBackEnd.Model.RoleName;
import com.ShoppingBackEnd.Model.User;
import com.ShoppingBackEnd.Repository.ConfirmationTokenRepository;
import com.ShoppingBackEnd.Repository.RoleRepository;
import com.ShoppingBackEnd.Repository.UserRepository;
import com.ShoppingBackEnd.Security.JwtTokenProvider;
import com.ShoppingBackEnd.exception.AppException;
import com.ShoppingBackEnd.payload.ApiResponse;
import com.ShoppingBackEnd.payload.JwtAuthenticationResponse;
import com.ShoppingBackEnd.payload.LoginRequest;
import com.ShoppingBackEnd.payload.ResetPassword;
import com.ShoppingBackEnd.payload.SignUpRequest;

@Service
public class AuthService {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ConfirmationTokenRepository tokenRepo;

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, loginRequest.getUsernameOrEmail()));
	}

	public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {
		if (userRepo.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<Object>(new ApiResponse(false, "Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepo.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<Object>(new ApiResponse(false, "Email Address already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepo.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));

		user.setRoles(Collections.singleton(userRole));

		User result = userRepo.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}

	public Boolean resetPassword(ResetPassword resetPwdData) {
		try {
			ConfirmationToken tokenEntity = tokenRepo.findByConfirmationToken(resetPwdData.getConfirmationToken());
			User user = tokenEntity.getUser();
			user.setPassword(passwordEncoder.encode(resetPwdData.getNewPassword()));
			userRepo.save(user);
			tokenRepo.delete(tokenEntity);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
