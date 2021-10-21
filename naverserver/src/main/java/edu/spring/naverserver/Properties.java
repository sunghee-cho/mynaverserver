package edu.spring.naverserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
//application.properties 파일 설정정보 이름 가져와서 변수 저장
	@Value("${spring.datasource.driver-class-name}")
	String driverclassname; 
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;

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
