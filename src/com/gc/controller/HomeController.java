package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author James Drain Nikki Shah David Musko Kassie Jones
 *
 */

@Controller
public class HomeController {

	@RequestMapping("/welcome")
	public ModelAndView welcomePage() {

		String message = "";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping("/registration")
	public ModelAndView registrationPage() {
		String message = "";

		return new ModelAndView("registration", "message", message);
	}

	@RequestMapping("/success")
	public ModelAndView successPage() {
		String message = "";

		return new ModelAndView("success", "message", message);
	}
	
	@RequestMapping("/mainmenu")
	public ModelAndView menuPage() {
		String message = "";

		return new ModelAndView("mainmenu", "message", message);
	}
	
	@RequestMapping("/searchkeyword")
	public ModelAndView keywordPage() {
		String message = "";

		return new ModelAndView("searchkeyword", "message", message);
	}
	
	@RequestMapping("/results")
	public ModelAndView keywordResultsPage() {
		String message = "";

		return new ModelAndView("results", "message", message);
	}
	
	@RequestMapping("/searchlocation")
	public ModelAndView locationPage() {
		String message = "";

		return new ModelAndView("searchlocation", "message", message);
	}
	
	
	@RequestMapping("/viewaccount")
	public ModelAndView accountPage() {
		String message = "";

		return new ModelAndView("viewaccount", "message", message);
	}
	
	@RequestMapping("/submitrequest")
	public ModelAndView requestPage() {
		String message = "";

		return new ModelAndView("submitrequest", "message", message);
	}
	
	@RequestMapping("/taskview")
	public ModelAndView taskPage() {
		String message = "";

		return new ModelAndView("taskview", "message", message);
	}
	
	@RequestMapping("/taskaccepted")
	public ModelAndView acceptedPage() {
		String message = "";

		return new ModelAndView("taskaccepted", "message", message);
	}
}
