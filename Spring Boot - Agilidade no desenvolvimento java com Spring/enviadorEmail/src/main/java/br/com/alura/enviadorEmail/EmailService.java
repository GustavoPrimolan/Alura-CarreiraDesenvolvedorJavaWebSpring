package br.com.alura.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

//MOSTRA QUE É UM SERVIÇO DO SPRING
@Service
public class EmailService {
	
	public void enviar(String nome, String emailDestinatario){
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			//EMAIL QUE IRÁ AUTENTICAS
			email.setAuthenticator(new DefaultAuthenticator("springbootalura@gmail.com", "springboot"));
			email.setSSLOnConnect(true);
			
			//EMAIL RESPONSÁVEL POR ENVIAR OS EMAILS
			email.setFrom("springbootalura@gmail.com");
			email.setSubject("Você foi convidado pelo ListaVIP");
			email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP");
			email.addTo(emailDestinatario);
			email.send();
			
		}catch(EmailException e) {
			e.printStackTrace();
		}
		
	}
	
}
