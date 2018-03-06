package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author James Drain, Nikki Shah, David Musko, Kassie Jones
 *
 */

@Controller
public class SearchController {
	
	
	@RequestMapping("/searchlocation")
	public ModelAndView locationPage() {
		String message = "";

		return new ModelAndView("searchlocation", "message", message);
	}
	
	@RequestMapping("/results")
	public ModelAndView keywordResultsPage() {
		String message = "";

		return new ModelAndView("results", "message", message);
	}

	@RequestMapping("/taskview")
	public ModelAndView taskPage() {
		String message = "";

		return new ModelAndView("taskview", "message", message);
	}
}






