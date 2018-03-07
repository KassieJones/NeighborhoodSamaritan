package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
//
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

	@RequestMapping("registrationsuccess")
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

		return new ModelAndView("mainmenu", "product", newUser);

	}

	@RequestMapping("/mainmenu")
	public ModelAndView menuPage() {
		String message = "";

		return new ModelAndView("mainmenu", "message", message);
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

	@RequestMapping("/taskaccepted")
	public ModelAndView acceptedPage() {
		String message = "";

		return new ModelAndView("taskaccepted", "message", message);
	}
}
