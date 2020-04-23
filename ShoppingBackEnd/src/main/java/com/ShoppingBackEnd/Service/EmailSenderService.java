package com.ShoppingBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ShoppingBackEnd.Model.ConfirmationToken;
import com.ShoppingBackEnd.Model.User;
import com.ShoppingBackEnd.Repository.ConfirmationTokenRepository;
import com.ShoppingBackEnd.Repository.UserRepository;
import com.ShoppingBackEnd.payload.ApiResponse;

@Service
public class EmailSenderService {
	private JavaMailSender javaMailSender;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	public EmailSenderService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Async
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}

	/* Sending email to confirm password. */
	public ResponseEntity<?> sendEmail(String email) {
        Boolean isExistingUser = userRepository.existsByEmail(email);
        if(!isExistingUser)
        	return new ResponseEntity<Object>(new ApiResponse(false, "Email does not exist!"),
					HttpStatus.BAD_REQUEST);
        else
        {
        	User user = userRepository.findByEmail(email);
        	
            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email);
            mailMessage.setSubject("Forget password!");
            mailMessage.setText("To reset your account password, please click here : "
            +"http://localhost:4200/#/pages/ResetPassword?token="+confirmationToken.getConfirmationToken());

            sendEmail(mailMessage);

            return new ResponseEntity<Object>(new ApiResponse(true, "Email sent successfully!"),
					HttpStatus.OK);
        }
    }
	
	/* Verifying for confirmationToken with email */
	public Boolean verifyToken(String confirmationToken) {
		ConfirmationToken value = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
		 return value != null;
	}
}
