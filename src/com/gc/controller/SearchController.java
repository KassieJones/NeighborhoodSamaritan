package com.gc.controller;

import java.util.ArrayList;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	// this is listing all the data from the product class
	public ModelAndView helloWorld(@RequestParam ("city") String city) {

		ArrayList<Task> taskList = listAllTasks();
		ArrayList<Task> localList = new ArrayList<Task>();

		//localList.addAll(taskList);
		
		for (int i = 0; i < taskList.size(); i++) {
			
			if (taskList.get(i).getCity().equalsIgnoreCase(city)) {	
				localList.add(taskList.get(i));		
			}
//			if (localList.get(i).getCity().equalsIgnoreCase(city)) {
//				
//				localList.add(k);
//				
//			}
		}
		// Iterator itr = localList.iterator();
		// while (itr.hasNext()) {
		// System.out.println(itr.next());
		// }
		return new ModelAndView("results", "localList", localList);
	}
	private ArrayList<Task> listAllTasks() throws HibernateException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
														// implemention of of our code
		Criteria crit = session.createCriteria(Task.class);
		ArrayList<Task> taskList = (ArrayList<Task>) crit.list();
		System.out.println(taskList.size());

		// model.addAttribute("specificItem", charList.get(2).getName());
		tx.commit();
		session.close();
		return taskList;
	}

	@RequestMapping("/taskview")
	public ModelAndView taskPage() {
		String message = "";
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); 
		Query query = session.createQuery("from Task");
		List taskList = query.list();
		tx.commit();
		session.close();

		return new ModelAndView("taskview", "taskList", taskList);
	}

	@RequestMapping("submitsuccess")
	public ModelAndView addNewTask(@RequestParam("usernameHost") String usernameHost, @RequestParam("date") String date,
			@RequestParam("time") String time, @RequestParam("estimatedTime") int estimatedTime,
			@RequestParam("skillsNeeded") String skillsNeeded, @RequestParam("city") String city,
			@RequestParam("title") String title, @RequestParam("address") String address, @RequestParam("phone") String phone) {
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
		newTask.setAddress(address);
		newTask.setPhone(phone);

		session.save(newTask);
		tx.commit();
		session.close();

		return new ModelAndView("mainmenu", "product", newTask);

	}

}
