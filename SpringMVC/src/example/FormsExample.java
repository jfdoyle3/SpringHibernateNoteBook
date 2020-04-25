package example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormsExample {

	// need a controller method to show form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "processForm";
	}	
}
