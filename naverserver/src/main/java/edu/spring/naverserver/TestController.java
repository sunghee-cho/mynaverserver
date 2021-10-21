package edu.spring.naverserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	

	@Autowired //static변수에 사용불가함!!!
	MyConfig myconfig;
	
	
@RequestMapping("/properties")
@ResponseBody
public String getProperties() {
	String result = myconfig.getPort() + " , ";
	result += myconfig.getDriverclassname() + " , ";
	result += myconfig.getUrl() + " , ";
	result += myconfig.getUsername() + " , ";
	result += myconfig.getPassword() + "  ";
	return result;
}
}

@Component
class MyConfig{
	/** 주의할 점 :  @Component를 선언- 스프링의 bean으로 등록되고 @Autowired로 의존주입할때 Null객체가 되는 일이 없습니다.*/
	@Value("${server.port}")
	String serverport;
	@Value("${spring.datasource.driver-class-name}")
	String driverclassname;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String username;
	@Value("${spring.datasource.password}")
	String password;
	
	
	public String getPort() {
		System.out.println(serverport);
		return serverport;
	}


	public String getDriverclassname() {
		return driverclassname;
	}


	public String getUrl() {
		return url;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}
	
	
}