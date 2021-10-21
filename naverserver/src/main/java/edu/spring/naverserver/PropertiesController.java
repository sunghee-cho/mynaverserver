package edu.spring.naverserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PropertiesController {
	
	@Autowired
	Properties p;
	
	@RequestMapping("/propertiestest")
	@ResponseBody
	public String getProperties(){
		String result = p.getDriverclassname() + " , ";
		result += p.getUrl() + " , ";
		result += p.getUsername() + " , ";
		result += p.getPassword();
		return result;
	}

}
