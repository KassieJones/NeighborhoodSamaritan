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
	
	public ModelAndView sendEmail(@RequestParam ("uName") String uName, @RequestParam ("title") String title) throws MailjetException, MailjetSocketTimeoutException{
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); 
		
//		Query query = session.createQuery("SELECT usernameHost FROM task WHERE id=1007");
		Criteria crit = session.createCriteria(Task.class);
		crit.add(Restrictions.eq("Title", title));
		
		Criteria crit2 = session.createCriteria(User.class);
		crit2.add(Restrictions.eq("Username", uName));
		
		Task task_test = (Task) crit.uniqueResult();
		String hostName = task_test.getUsernameHost();
		String hostEmail = task_test.getEmail();
		
		User user_test = (User) crit2.uniqueResult();
		String doerPhone = user_test.getPhone();
		String doerEmail = user_test.getEmail();
		String charityPref = user_test.getCharityPref();
		tx.commit();
		session.close();
		
System.out.println(doerEmail);
System.out.println(doerPhone);
System.out.println(hostEmail);
System.out.println(hostName);
System.out.println(charityPref);
		
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
	                    .put(Emailv31.Message.TEXTPART, "Dear " + hostName + ", \n  We found you a match! \n Please contact your volunteer at " + doerEmail + " or " + doerPhone + " to set-up the terms of the volunteer opportunity! \n  Thanks for being a valued member of Hood Samaritan!")
	                    .put(Emailv31.Message.HTMLPART, "<p>Dear " + hostName + ", </p> <p>We have found you a match!<br>Please contact your volunteer at the email or phone number below, identify yourself and the opportunity to arrange the details of the task you need.  <br><br>CONTACT INFORMATION: <br></p>" + doerEmail + "<br>" + doerPhone + "<br>This is the helper's preferred charity: " + charityPref + "<br>Thank you for being part of the Hood Samaritan community!")));
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
