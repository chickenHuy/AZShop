package com.azshop.utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;

import com.azshop.models.UserModel;
public class Email {
	// Hàm code ngẫu nhiên
	public String getRandom() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return String.format("%06d", number);
	}

	// Send email to the user email
	public Boolean sendEmail(UserModel user, String code) {
		Boolean testBoolean = false;

		String toEmail = user.getEmail();
		String fromEmail = "hieuthanhtran2908003@gmail.com";
		String password = "ifadpcrmlgomgimj";

		try {
			Properties properties = configEmail(new Properties());

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});

			// Set email message details
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			// Set from email address
			message.setFrom(new InternetAddress(fromEmail));
			// Set to email address or destination email address
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// Set email subject
			message.setSubject("Confirm Code");

			// Set message text
			message.setText("Your is code: " + code);

			// send the message
			Transport.send(message);
			testBoolean = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testBoolean;
	}
	
	public Boolean sendEmailForget(UserModel user, String newPassword) {
		Boolean testBoolean = false;

		String toEmail = user.getEmail();
		String fromEmail = "hieuthanhtran2908003@gmail.com";
		String password = "ifadpcrmlgomgimj";

		try {
			Properties properties = configEmail(new Properties());

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});

			// Set email message details
			Message message = new MimeMessage(session);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			// Set from email address
			message.setFrom(new InternetAddress(fromEmail));
			// Set to email address or destination email address
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// Set email subject
			message.setSubject("New your password");

			// Set message text
			message.setText("Your is password: " + newPassword);

			// send the message
			Transport.send(message);
			testBoolean = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testBoolean;
	}

	private Properties configEmail(Properties properties) {
		// your host email smtp server details
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	    properties.setProperty("mail.smtp.port", "587");
	    properties.setProperty("mail.smtp.auth", "true");
	    properties.setProperty("mail.smtp.starttls.enable", "true");
	    return properties;
	}
}
