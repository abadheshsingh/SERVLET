package mail.com.p1;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	public static void send(String to, String subject, String message) {
		final String user = "kumarabadhesh90@gmail.com";
		final String password = "Intell@08";
		
//		Step 1: Create Session
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                  "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
		});
		
//		Step 2: Compose message
		
		try {
			MimeMessage mimeMsg = new MimeMessage(session);
			mimeMsg.setFrom(new InternetAddress(user));
			mimeMsg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMsg.setSubject(subject);
			mimeMsg.setText(message);
			
//			Step 3: Send message
			Transport.send(mimeMsg);
			System.out.println("Done............");
		} catch (MessagingException e) {
			throw new RuntimeException();
		}
		
	}
}
