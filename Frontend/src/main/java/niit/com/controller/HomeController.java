package niit.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String homePage()
	{
		return "UserHome";
	}
	@RequestMapping("/login")
	   public String showLogin()
	   {
		   return "login";
	   }
	   
	   @RequestMapping("/register")
	   public String showRegister()
	   {
		   return "Register";
	   }
}
