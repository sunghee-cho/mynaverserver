package javamail;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/*application.properties
#gmail mail server
spring.mail.host=smtp.gmail.com
#465포트도 있는데 암호화방법의차이
spring.mail.port=587 
spring.mail.username=bluejeansh@gmail.com
#구글 2단계 인증 앱 비밀번호에서 생성한 암호(원래 암호가 드러나면 안되므로 이런 방법을 제공하는 듯)
spring.mail.password=tgeropllvzcxsdju
spring.mail.properties.mail.smtp.auth=true
#587포트사용시설정
spring.mail.properties.mail.smtp.starttls.enable=true 
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com
spring.mail.properties.mail.smtp.starttls.required=true

pom.xml (start에서 io - java mail  선택시 자동 추가)
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
*/
@Controller
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/email")
	public String emailPage() {
		
		return "email";
	}
	//  http://localhost:9003/sendCode?email=bluejeansh@hanmail.net   (인증번호받을메일주소)
	@RequestMapping(value="/sendCode", method=RequestMethod.GET)
    public ModelAndView sendEmailAction (HttpSession session, @RequestParam String email, ModelAndView mv) throws Exception {
 
       int random = new Random().nextInt(100000) + 10000; // 10000 ~ 99999 
             
        String joinCode = String.valueOf(random); 
        session.setAttribute("joinCode", joinCode); 
       MimeMessage message = mailSender.createMimeMessage();
       MimeMessageHelper messageHelper = new MimeMessageHelper(message, "UTF-8");
       try {      
            messageHelper.setSubject("[인증] 오늘뭐해먹지 가입인증 메일입니다.");
            messageHelper.setText("인증번호는 "+joinCode+" 입니다.");
            messageHelper.setTo("bluejeansh@hanmail.net");
            message.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email));
            System.out.println(7); 
            mailSender.send(message);
            System.out.println(8); 
            
            System.out.println("메세지 전송완료");
            
       }catch(MessagingException e) {
           System.out.println("에러남");
           e.printStackTrace();
       }      
  
        mv.setViewName("email");
        return mv;
    }

}
