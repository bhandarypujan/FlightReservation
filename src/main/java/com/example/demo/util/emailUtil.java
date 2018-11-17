package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class emailUtil {
    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(String toaAdress,String filePath){
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper =
                    new MimeMessageHelper(message, true);
            messageHelper.setTo(toaAdress);
            messageHelper.setSubject("Itinerary for your Flight");
            messageHelper.setText("Please Find attachment");
            messageHelper.addAttachment("itinerary",new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
