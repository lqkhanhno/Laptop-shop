/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.mail.*;
import javax.mail.internet.*;
import static jdk.internal.util.StaticProperty.userName;


/**
 *
 * @author Thao Ngoc
 */
public class SendEmail {
    public static void send(String toAddress, String subject, String content) {
        try {
            String email = "toaintse04189@fpt.edu.vn";
            String password ="Thanhtoai1010";
            String host = "smtp.gmail.com";//or IP address
            
            Properties properties = new Properties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", 587);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
            // creates a new session with an authenticator
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password);
                }
            };
            
            Session session = Session.getInstance(properties, auth);
            
            // creates a new e-mail message
            Message msg = new MimeMessage(session);
            
            msg.setFrom(new InternetAddress(email));
            InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(content);
            
            // sends the e-mail
            Transport.send(msg);
        } catch (MessagingException ex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
