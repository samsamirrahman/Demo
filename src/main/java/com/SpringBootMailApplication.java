package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@SpringBootApplication
public class SpringBootMailApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(SpringBootMailApplication.class, args);
		for(int i=1;i<=15;i++)
		{
		JavaMailSender sender = ctx.getBean(JavaMailSender.class);
		MimeMessage msg=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg);
		helper.setFrom("tahiralam214@gamil.com");
		helper.addTo(new InternetAddress("tahiralam214@gamil.com"));
		
		helper.setSubject("Biryani Party");
		helper.setText("Biryani Party kab hai???");
        sender.send(msg);
        System.out.println("SpringBootMailApplication.main()::"+i);
        
		}
        System.out.println("Biryani......");
		
		
		
	}

}
