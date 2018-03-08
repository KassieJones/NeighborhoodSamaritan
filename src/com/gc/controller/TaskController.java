package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.Task;
import com.gc.util.HibernateUtil;



/**
 * 
 * @author James Drain, Nikki Shah, David Musko, Kassie Jones
 *
 */

@Controller
public class TaskController {
	
	@RequestMapping("/showallopps")
	// this is listing all the data from the product class
	public ModelAndView helloWorld(Model model) {
System.out.println("showallopps");
		// Configuration config = new Configuration().configure("hibernate.cfg.xml");
		// ServiceRegistry serviceRegistry = new
		// ServiceRegistryBuilder().applySettings(config.getProperties())
		// .buildServiceRegistry();
		ArrayList<Task> taskList = listAllTasks();
		model.addAttribute("specificItem", taskList.get(2).getTitle());

		return new ModelAndView("showallopps", "taskList", taskList);
	}

	
	
	private ArrayList<Task> listAllTasks() throws HibernateException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
														// implemention of of our code
		Criteria crit = session.createCriteria(Task.class);
		ArrayList<Task> taskList = (ArrayList<Task>) crit.list();
		System.out.println(taskList.size());

		//model.addAttribute("specificItem", charList.get(2).getName());
		tx.commit();
		session.close();
		return taskList;
	}
}