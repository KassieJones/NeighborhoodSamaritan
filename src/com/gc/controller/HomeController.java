package com.gc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.User;
import com.gc.util.HibernateUtil;

/**
 * 
 * @author James Drain, Nikki Shah, David Musko, Kassie Jones
 *
 */

@Controller

public class HomeController {


		@RequestMapping("/mainmenu")

		public ModelAndView menuPage(@RequestParam ("idToken") String idToken,@RequestParam("userId") String userId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria crit = session.createCriteria(User.class);
        crit.add(Restrictions.eq("googleID",userId));

        User user = (User) crit.uniqueResult();
        session.getTransaction().commit();
        
        if(user==null) {
        	System.out.print(userId);
        	return new ModelAndView("registration", "userId", userId);
        	
        } else {
        

			

			System.out.println(idToken);
			System.out.print(userId);

			
	
			return new ModelAndView("mainmenu", "userId", userId);
        }
		}

	@RequestMapping("/welcome")
	public ModelAndView welcomePage(HttpSession session) {
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
	public ModelAndView addNewUser(@RequestParam("id") String userId, @RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("city") String city, @RequestParam("address") String address, @RequestParam("charityPref") String charityPref) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); 

		User newUser = new User();
		newUser.setGoogleID(userId);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setPhone(phone);
		newUser.setCity(city);
		newUser.setAddress(address);
		newUser.setCharityPref(charityPref);

		session.save(newUser);
		tx.commit();
		session.close();

		return new ModelAndView("mainmenu", "product", newUser);

	}


//	@RequestMapping("/viewaccount")
//	public ModelAndView accountPage() {
//		String message = "";
//
//		return new ModelAndView("viewaccount", "message", message);
//	}

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
	@RequestMapping("/payment")
	public ModelAndView paymentPage() {
		String message = "";

		return new ModelAndView("payment", "message", message);
	}
}
