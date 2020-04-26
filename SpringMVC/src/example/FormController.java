package example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class FormController {

	// need a controller method to show form

	@RequestMapping("/showForm")
	public String showForm() {
		return "showform";
	}

	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "processform";
	}

	// new controller read form data and add data to model

	// Method 1:
	@RequestMapping("/shoutOut")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request from the HTML form
		String theName = request.getParameter("studentName");

		// convert the data the all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Yo! " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "processform";
	}

	// Method 2: Spring can get the form input in the methods arguments
	@RequestMapping("/shoutingOut")
	public String shoutOut(@RequestParam("studentName") String theName, Model model) {

		// convert the data the all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey! " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "processform";
	}
}