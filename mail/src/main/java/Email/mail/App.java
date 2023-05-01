package Email.mail;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App {

	public static void main(String[] args) {
		System.out.println("Sending Message");
		String from="milindvedi@gmail.com";
		String to="nkhlkmr17@gmail.com";
		String subject="Mail Send Check";
		String message="Hello, How are you?";
		String src="I:/tree-736885_960_720.jpg";
		String host="smtp.gmail.com";
		Properties properties=System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("milindvedi@gmail.com", "ljqbqiklzgqqbnwu");
			}
			
		});
		//session.setDebug(true);
		MimeMessage m=new MimeMessage(session);
		MimeMultipart mmp=new MimeMultipart();
		MimeBodyPart text=new MimeBodyPart();
		MimeBodyPart img=new MimeBodyPart();
		
		
		try
		{
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
		//for sending only message:	m.setText(message);
			text.setText(message);
			File file=new File(src);
			img.attachFile(file);
			mmp.addBodyPart(text);
			mmp.addBodyPart(img);
			m.setContent(mmp);
			
			Transport.send(m);
			System.out.println("Message Sent Successfully");
		}
		catch(Exception e)
		{
			System.out.println("fail");
			e.printStackTrace();
		}
	}
	
}
