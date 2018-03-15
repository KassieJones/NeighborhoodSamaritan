package com.gc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	public ModelAndView menuPage() {

		// SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// Session session = sessionFactory.openSession();
		// Transaction tx = session.beginTransaction();
		//
		// Criteria crit = session.createCriteria(User.class);
		// crit.add(Restrictions.eq("googleID",userId));
		//
		// User user = (User) crit.uniqueResult();
		// session.getTransaction().commit();
		//
		// if(user==null) {
		// System.out.print(userId);
		// return new ModelAndView("registration", "userId", userId);
		//
		// } else {
		//
		//
		//
		//
		// System.out.println(idToken);
		// System.out.print(userId);

		return new ModelAndView("mainmenu", "", "");
	}

	@RequestMapping("/welcome")
	public ModelAndView welcomePage() {
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
	public ModelAndView addNewUser(/* @RequestParam("id") String userId, */@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("city") String city,
			@RequestParam("address") String address, @RequestParam("charityPref") String charityPref) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User newUser = new User();
		// newUser.setGoogleID(userId);
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


	@RequestMapping("userinfosend")
	public ModelAndView accountPage(@RequestParam("uName") String user, @RequestParam("password") String password) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria crit = session.createCriteria(User.class);
		
        User user2 = (User) crit.add(Restrictions.eq("username",user)).uniqueResult();
       
        

		return new ModelAndView("userinfo", "user2", user2);
	}

	@RequestMapping("/userinfo")
	public ModelAndView userInfo() {
		String message = "";

		return new ModelAndView("userinfo", "message", "");
	}

	@RequestMapping("/submitrequest")
	public ModelAndView requestPage() {
		String message = "";

		return new ModelAndView("submitrequest", "message", message);
	}

	
	
	
	@RequestMapping("/addhours")
	public ModelAndView acceptedPage(@RequestParam("taskHours") int taskHours, @RequestParam("userHours") int userHours)
			throws ClassNotFoundException, SQLException {

		Connection con = getDBConnection();
		String sql = "update user set Hours=? where Hours=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, userHours + taskHours);
		ps.executeUpdate();
		con.close();
		

		return new ModelAndView("userProfile", "success", userHours);
	}

	private Connection getDBConnection() throws ClassNotFoundException, SQLException {
		// prep for step # 3
		String url = "jdbc:mysql://localhost:3306/neighborhoodsamaritan";
		String userName = "root";
		String password = "Michelle2010";

		// Step #2: Load and Register Driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step #3: Create Connection
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}

}
