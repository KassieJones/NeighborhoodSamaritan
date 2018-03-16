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
public class TaskController {
	
	@RequestMapping("/taskaccepted") 
		public ModelAndView taskAccepted(@RequestParam("title") String title) {
		
		
		
			
			return new ModelAndView ("taskaccepted", "title", title);
		}
		
		
	
	@RequestMapping("/showallopps")

	public ModelAndView helloWorld(Model model) {
System.out.println("showallopps");

		ArrayList<Task> taskList = listAllTasks();
		
//		
//		for (int i = 0; i < taskList.size(); i++) {
//			
//			if (taskList.get(i).getStatus().equalsIgnoreCase("u")) {	
//				taskList.remove(taskList.get(i));		
//			}
//		}
		

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

		tx.commit();
		session.close();
		return taskList;
	}
	
	@RequestMapping("showallopps2") 
	public ModelAndView updateForm(@RequestParam("status") String status) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
														// implemention of of our code

		Task updateTask = new Task();
		//updateTask.setStatus(status);

		
		session.update(updateTask);
		tx.commit();
		session.close();
		
		
		//ArrayList<Product> prodList = listAllProducts();
		
		return new ModelAndView("showallopps", "pList", "");
	}
	
	
	
	
	
	@RequestMapping("deletetask")
	public ModelAndView deleteProduct(@RequestParam("title") String title) {
		
		// temp object will store info for the object that we want to delete
		Task temp = new Task();
		temp.setTitle(title);
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
														// implemention of of our code
		
		session.delete(temp);
		tx.commit();
		session.close();
		
		ArrayList<Task> userList = listAllTasks();
		return new ModelAndView("welcome", "uList", userList);
		
	}
	
	
	
}