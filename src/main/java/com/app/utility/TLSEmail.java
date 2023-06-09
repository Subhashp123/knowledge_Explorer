package com.app.utility;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
	public boolean sendEmail(String to) {
		
		System.out.println("in TLS EMAIL");
		final String fromEmail = "mgmalumninetwork@gmail.com"; //requires valid gmail id
		final String password = "Sai#9860"; // correct password for gmail id
		final String toEmail = to; // can be any email id 
		String msgbody="Thanks For registrating Knowledge Explorer with Email "+to;
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		if(EmailUtil.sendEmail(session, toEmail,"Alumni Network OTP", msgbody))
			return true;
		return false;
		
	}

	
}

