package com.cignex.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class MailExampleApplication {
	@Value("${gmail.username}")
	private String username;
	@Value("${gmail.password}")
	private String password;

	public void sendmail(String name,String email,String random) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("infantsnursingcaresystem@gmail.com", "NoReply-Pinal"));

			msg.setReplyTo(InternetAddress.parse("infantsnursingcaresystem@gmail.com", false));
			 String subject = "activate your account ";

			msg.setSubject(subject, "UTF-8");
			
			 String body = "click here for activate your account " + name +
			  "  <a href='http://localhost:8082/register/activate?email=" +
			  email + "&&token=" + random +
			  "'>http://localhost:8082/register/activate?email='"+email+
			  "'&&token='"+random+"'" + "</a>";
			msg.setContent(body, "text/html; charset=utf-8");
			// msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("EMail Sent Successfully!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
