package fhi0.DIDR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//@CrossOrigin(origins = "http://localhost:3001")
@Controller
public class AppController {

	@RequestMapping("/api/v1/")
	@ResponseBody
	public String index() {
		return "Welcome to DIDR Service!";
	}
}