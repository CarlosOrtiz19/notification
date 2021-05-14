package com.notifications.comunication.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    JavaMailSender emailSender;

    public void sendEmail(String email) throws Exception {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject("changements sur la page que vous surveillez");
        helper.setText("Nous avons remarqué des changements sur la page que vous surveillez.", true);
        helper.setSentDate(new Date());
        emailSender.send(message);
        LOGGER.info("Mail sent to ==> " + email);
    }

    public static void main(String[] args) throws NoSuchFieldException {
        EmailService e = new EmailService();
        System.out.println(e.getClass().getDeclaredField("mailSender"));
    }
}
