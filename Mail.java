import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class Mail{
		
	Properties properties;
	MimeMessage message;
	String to;
	String subject;
	public void send(String to,String mes){

			this.to = to;
			String from = "1NH18CS068.gourirajesh@gmail.com"; 
			properties = new  Properties();
			properties.put("mail.smtp.auth","true");
			properties.put("mail.smtp.starttls.enable","true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port",587);

			
			try
			{  
				Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("1NH18CS068.gourirajesh@gmail.com","gourirajesh1NH18CS068");
					}
				});
				
				message = new MimeMessage(session); 
				message.setFrom(new InternetAddress(from));  
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("GREETINGS FROM CAREERBOOK");
				message.setText(mes); 
				Transport.send(message); 
				System.out.println("Confirmation mail successfully sent"); 
			
			} catch (MessagingException mex) 
			{
				mex.printStackTrace(); 
			} 
		}
	public void send(String to,String mes,String sub){

		this.to = to;
		this.subject=sub;
		String from = "1NH18CS068.gourirajesh@gmail.com"; 
		properties = new  Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port",587);

		
		try
		{  
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("1NH18CS068.gourirajesh@gmail.com","gourirajesh1NH18CS068");
				}
			});
			
			message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(from));  
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(mes); 
			Transport.send(message); 
			System.out.println("Mail successfully sent"); 
		
		} catch (MessagingException mex) 
		{
			mex.printStackTrace(); 
		} 
	}
	
}

	


