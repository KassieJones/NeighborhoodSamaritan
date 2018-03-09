package com.gc.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.model.User;
import com.gc.util.HibernateUtil;

@Controller
public class UserController {
	
	
	
	@RequestMapping("/userinfo")
	public ModelAndView userInfo(HttpSession sessions) {
		User user1 = (User) sessions.getAttribute("user1");
		System.out.println(user1.getUsername());
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session hibSession = sessionFactory.openSession();
		Transaction tx = hibSession.beginTransaction();
		Object myUser = hibSession.get(User.class,1);

		tx.commit();
		hibSession.close();
		

		return new ModelAndView("userinfo","user", user1);
	}
}
