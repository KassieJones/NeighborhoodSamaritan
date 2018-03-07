package com.gc.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.Task;
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

	@RequestMapping("submitsuccess")
	public ModelAndView addNewTask(@RequestParam("usernameHost") String usernameHost, @RequestParam("date") String date,
			@RequestParam("time") String time, @RequestParam("estimatedTime") int estimatedTime,
			@RequestParam("skillsNeeded") String skillsNeeded, @RequestParam("city") String city, @RequestParam("title") String title) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
														// implemention of of our code

		Task newTask = new Task();
		newTask.setUsernameHost(usernameHost);
		newTask.setDate(date);
		newTask.setTime(time);
		newTask.setEstimatedTime(estimatedTime);
		newTask.setSkillsNeeded(skillsNeeded);
		newTask.setCity(city);
		newTask.setTitle(title);


		session.save(newTask);
		tx.commit();
		session.close();

		return new ModelAndView("mainmenu", "product", newTask);

	}

}
