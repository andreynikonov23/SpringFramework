package nick.pack.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String sayHello(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action, Model model) {
		int result = 0;
		if (action.equals("multiplication")) {
			result = a * b;
		}
		if (action.equals("addition")) {
			result = a + b;
		}
		if (action.equals("subtraction")) {
			result = a - b;
		}
		if (action.equals("division")) {
			result = a / b;
		}
		model.addAttribute("result", result);
		return "hello/hello";
	}
	@GetMapping("/goodbye")
	public String test(@RequestParam(value="login", required=false) String login, @RequestParam(value="password", required=false) String password) {
		System.out.println(login + " " + password);
		return "goodbye/goodbye";
	}
	@GetMapping("/exit")
	public String exit() {
		return "exit";
	}
}
