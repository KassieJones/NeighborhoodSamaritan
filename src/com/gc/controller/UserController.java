package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
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
	public ModelAndView userInfo() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Object myUser = session.get(User.class,1);

		tx.commit();
		session.close();

		return new ModelAndView("userinfo","user", myUser);
	}
}
