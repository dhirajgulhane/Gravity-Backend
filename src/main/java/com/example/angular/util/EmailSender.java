package com.example.angular.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.angular.model.User;

public class EmailSender {
	
	public static void sendFromGMail(String from, String pass, String[] to, User user) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject("User Enrollment Notification For "+user.getFname());
            message.setContent("Hello&nbsp;<br/><br/>"+user.getFname()+"has enrolled on Gravity for "+user.getCourse()+", "
            		+ "Please contact on "+user.getPhone()+" to confirm enrollment<br/><br/>"
            		+ "<font color=red>Thanks and Regards, </br>Team Gravity</font>", "text/html");
            message.setSentDate(new Date());
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            System.out.println(ae.getMessage());
        }
        catch (MessagingException me) {
        	System.out.println(me.getMessage());
        }
    }
}
