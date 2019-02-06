package com.cignex.services;

import java.sql.Time;
import java.util.Arrays;
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
import org.springframework.stereotype.Service;

import com.cignex.entities.Movie;
import com.cignex.entities.Screen;
import com.cignex.entities.UserBooked;
@Service("email_service")
public class EmailService {
	
	public void sendmail(String name, String email, String random) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("infantsnursingcaresystem@gmail.com", "pinal1234");
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

			String body = "click here for activate your account " + name
					+ "  <a href='http://localhost:8082/register/activate?email=" + email + "&&token=" + random
					+ "'>http://localhost:8082/register/activate?email='" + email + "'&&token='" + random + "'"
					+ "</a>";
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
	
	public void ticketSendMail(String string, String string2, Date date,Time time,String[] bookedSeats,int price,String email) throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("infantsnursingcaresystem@gmail.com", "pinal1234");
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
			String subject = "Booking details ";

			msg.setSubject(subject, "UTF-8");

			String body = "Thank you for booking the tickets"
					+ " your booking details are as under"
					+ "<table><tr>"
					+ "movie name: "+string+" and "
							+ "screen is "+string2+" and"
									+ " date is "+date+" and"
											+ " time is "+ time +" and booked seats are "+ Arrays.toString(bookedSeats) +""
							+ "and total is "+ price+""
					+ "</tr></table>";
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
