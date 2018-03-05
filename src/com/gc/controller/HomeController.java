package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author James Drain  Nikki Shah  David Musko  Kassie Jones
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
		
		return new ModelAndView("registration","message",message);
		}
	@RequestMapping("/success")
	public ModelAndView successPage() {
		String message = "";
		
		return new ModelAndView("success","message",message);
		}
}
