package edu.spring.naverserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DivController {
	
	
@RequestMapping("/divtest1")
public String divtest1() {
	return "divtest1";
}

@RequestMapping("/divtest2")
public String divtest2(String param) {
	System.out.println("컨트롤러=" + param);
	return "divtest2";
}
	
	
}