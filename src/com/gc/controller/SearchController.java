package com.gc.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.User;
import com.gc.util.HibernateUtil;

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
	
	@RequestMapping("searchsuccess")
	public ModelAndView addNewUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("city") String city) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
														// implemention of of our code

		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setPhone(phone);
		newUser.setCity(city);

		session.save(newUser);
		tx.commit();
		session.close();

		return new ModelAndView("results", "product", newTask);

	}

}






