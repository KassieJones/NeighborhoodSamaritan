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

import com.gc.model.Charity;
import com.gc.util.HibernateUtil;

/**
 * 
 * @author James Drain, Nikki Shah, David Musko, Kassie Jones
 *
 */

@Controller
public class CharityController {
	
	@RequestMapping("/success2")
	// this is listing all the data from the product class
	public ModelAndView helloWorld(Model model) {

		// Configuration config = new Configuration().configure("hibernate.cfg.xml");
		// ServiceRegistry serviceRegistry = new
		// ServiceRegistryBuilder().applySettings(config.getProperties())
		// .buildServiceRegistry();
		ArrayList<Charity> charList = listAllCharities();
		model.addAttribute("specificItem", charList.get(2).getName());

		return new ModelAndView("viewaccount", "charList", charList);
	}

	
	
	private ArrayList<Charity> listAllCharities() throws HibernateException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
														// implemention of of our code
		Criteria crit = session.createCriteria(Charity.class);
		ArrayList<Charity> charList = (ArrayList<Charity>) crit.list();
		System.out.println(charList.size());

		//model.addAttribute("specificItem", charList.get(2).getName());
		tx.commit();
		session.close();
		return charList;
	}


//	@RequestMapping("submitsuccess")
//	public ModelAndView addNewTask(@RequestParam("usernameHost") String usernameHost, @RequestParam("date") String date,
//			@RequestParam("time") String time, @RequestParam("estimatedTime") int estimatedTime,
//			@RequestParam("skillsNeeded") String skillsNeeded, @RequestParam("city") String city, @RequestParam("title") String title, @RequestParam("address") String address) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
//														// implemention of of our code
//
//		Task newTask = new Task();
//		newTask.setUsernameHost(usernameHost);
//		newTask.setDate(date);
//		newTask.setTime(time);
//		newTask.setEstimatedTime(estimatedTime);
//		newTask.setSkillsNeeded(skillsNeeded);
//		newTask.setCity(city);
//		newTask.setTitle(title);
//		newTask.setAddress(address);
//
//
//		session.save(newTask);
//		tx.commit();
//		session.close();
//
//		return new ModelAndView("mainmenu", "product", newTask);
//
//	}

}
