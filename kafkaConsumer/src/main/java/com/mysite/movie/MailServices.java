package com.mysite.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServices {
    @Autowired
    private JavaMailSender emailSender;
    public void sendEmail(String to){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mojMail@gmail.com");
        message.setTo(to);
        message.setSubject("Filmy");
        message.setText("Jesli szukasz strony do ogladania filmow sprawdz www.zxc.com");
        emailSender.send(message);
        System.out.println("wysalalem");

    }
}
