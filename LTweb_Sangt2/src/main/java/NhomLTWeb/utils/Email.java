package NhomLTWeb.utils;


import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

import NhomLTWeb.model.UserModel;

public class Email {
	
	
	public String getRandom() {
		
		
		//Tạo mã OTP ngẫu nhiên
		Random rand = new Random();
		int number = rand.nextInt(999999);
		return String.format("%06d", number);
	}
	
	// Hàm gửi email đến user
	public boolean sendEmail(UserModel user) {
		
		boolean test = false; // cờ này để xác nhận chạy được hay không
		
		
		String toEmail = user.getEmail();
		String fromEmail = "quocthanhnt2004@gmail.com";
		String password = "0935256662thanh";
		
		Properties pr = configEmail(new Properties());
		
		Session session = Session.getInstance(pr, new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		
		try {
			//Set email message detail
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type", "text/plain; charset=UTF-8");
			
			//Set mail address
			mess.setFrom(new InternetAddress(fromEmail));
			
			//Set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			
			//Set email subject	
			mess.setSubject("Confirm Code");
			
			//Set message text
	//		mess.setText("Your code is : " + user.getCode());
			
			//send message
			Transport.send(mess);
			
			test = true;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return test;
		
	}
	
	public Properties configEmail(Properties pr) {
		//Cấu hình email SMTP
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.host", "587");
		pr.setProperty("mail.smtp.host", "true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.put("mail.smtp.socketFactory.port", "587");
		pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		return pr;
	}
}
