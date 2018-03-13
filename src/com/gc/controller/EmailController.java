package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.Task;
import com.gc.model.User;
import com.gc.util.APICredentials;
import com.gc.util.HibernateUtil;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;

@Controller
public class EmailController {
	@RequestMapping("/send")
	
	public ModelAndView sendEmail(@RequestParam ("doerEmail") String doerEmail, @RequestParam ("doerPhone") String doerPhone, @RequestParam ("id") int id) throws MailjetException, MailjetSocketTimeoutException{
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); 
		
//		Query query = session.createQuery("SELECT usernameHost FROM task WHERE id=1007");
		Criteria crit = session.createCriteria(Task.class);
		crit.add(Restrictions.eq("id", id));
		//query.setParameter("i", id);
		
		
		
		Task task_test = (Task) crit.uniqueResult();
		String hostName = task_test.getUsernameHost();
		String hostEmail = task_test.getEmail();
		tx.commit();
		session.close();
		
		
System.out.println(doerEmail);
System.out.println(doerPhone);
System.out.println(id);
System.out.println(hostEmail);
System.out.println(hostName);
		
	      MailjetClient client;
	      MailjetRequest request;
	      MailjetResponse response;
	      client = new MailjetClient(APICredentials.mailJetPKey,APICredentials.mailJetSKey, new ClientOptions("v3.1"));
	      request = new MailjetRequest(Emailv31.resource)
	            .property(Emailv31.MESSAGES, new JSONArray()
	                .put(new JSONObject()
	                    .put(Emailv31.Message.FROM, new JSONObject()
	                        .put("Email", "contact@hoodsamaritan.org")
	                        .put("Name", "HoodSamaritanTeam"))
	                    .put(Emailv31.Message.TO, new JSONArray()
	                        .put(new JSONObject()
	                            .put("Email", hostEmail)
	                            .put("Name", hostName)))
	                    .put(Emailv31.Message.SUBJECT, "Someone would like to help you!")
	                    .put(Emailv31.Message.TEXTPART, "Dear passenger 1, welcome to Mailjet! May the delivery force be with you!")
	                    .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to Mailjet!</h3><br />May the delivery force be with you!")));
	      response = client.post(request);
	      System.out.println(response.getStatus());
	      System.out.println(response.getData());
	      String success = "success";
	
	      return new ModelAndView("mainmenu","success",success);
		
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
		
		private ArrayList<User> listAllUsers () throws HibernateException {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction(); // the transaction represents the unit of work or the actual
															// implemention of of our code
			Criteria crit = session.createCriteria(User.class);
			ArrayList<User> userList = (ArrayList<User>) crit.list();
			System.out.println(userList.size());

			// model.addAttribute("specificItem", charList.get(2).getName());
			tx.commit();
			session.close();
			return userList;
		}
	
}
