package com.app.utility;


import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body 
	 */
	public static boolean sendEmail(Session session, String toEmail, String subject, String body){
		System.out.println("in TLS EMAIL1");
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("mgmalumninetwork@gmail.com", "OTP-VERIFACTION"));

	      msg.setReplyTo(InternetAddress.parse("mgmalumninetwork@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);
	      System.out.println("EMail Sent Successfully!!");
    		  return true;
    	  
    	  
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      return false;
	    }
	}
}
