package com.example.springproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {
 
	@Autowired
    private JavaMailSender javaMailSender;
	
	public  void sendEmail(String email, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject(subject);
        msg.setText(message);

        javaMailSender.send(msg);

    }
	
}
