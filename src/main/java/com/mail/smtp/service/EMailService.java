package com.mail.smtp.service;

import javax.mail.MessagingException;

import com.mail.smtp.domain.EmailObject;

public interface EMailService {
	
	void SendSimpleMessage(EmailObject emailObject);
	void SendMailWithAttachement(EmailObject emailObject) throws MessagingException;

}
