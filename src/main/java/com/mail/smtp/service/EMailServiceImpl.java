package com.mail.smtp.service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.mail.smtp.domain.EmailObject;

@Service
public class EMailServiceImpl implements EMailService {
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	public void SendSimpleMessage(EmailObject emailObject) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(emailObject.getMailFrom());
		simpleMailMessage.setTo(emailObject.getMailTo());
		simpleMailMessage.setSubject(emailObject.getMailsubject());
		

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Memorynotfound.com");
        model.put("location", "Belgium");
        model.put("signature", "https://memorynotfound.com");
		
		Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);
        simpleMailMessage.setText(html);
		
		javaMailSender.send(simpleMailMessage);
	}
	
	public void SendMailWithAttachement(EmailObject emailObject) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        helper.addAttachment("sample.png", new ClassPathResource("sample-logo.png"));

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Google.com");
        model.put("location", "Netherlands");
        model.put("signature", "https://google.com");
        
        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("email-template", context);

        helper.setTo(emailObject.getMailTo());
        helper.setText(html, true);
        helper.setSubject(emailObject.getMailsubject());
        helper.setFrom(emailObject.getMailFrom());

        javaMailSender.send(message);
	}

}
