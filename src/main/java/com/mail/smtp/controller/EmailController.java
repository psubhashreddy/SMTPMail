package com.mail.smtp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.smtp.domain.EmailObject;
import com.mail.smtp.service.EMailService;

@RestController
@RequestMapping("/")
public class EmailController {
	
	@Autowired
	private EMailService eMailService;

	@PostMapping("/send")
	public String sendingMail(@Valid @RequestBody EmailObject emailObject) {
		eMailService.SendSimpleMessage(emailObject);
		return "Successfully sent";
	}
}
