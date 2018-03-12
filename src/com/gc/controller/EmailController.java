package com.gc.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gc.util.APICredentials;
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
	
	public ModelAndView sendEmail() throws MailjetException, MailjetSocketTimeoutException{
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
	                            .put("Email", "muskbro@gmail.com")
	                            .put("Name", "David")))
	                    .put(Emailv31.Message.SUBJECT, "Your email flight plan!")
	                    .put(Emailv31.Message.TEXTPART, "Dear passenger 1, welcome to Mailjet! May the delivery force be with you!")
	                    .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to Mailjet!</h3><br />May the delivery force be with you!")));
	      response = client.post(request);
	      System.out.println(response.getStatus());
	      System.out.println(response.getData());
	      String success = "success";
	
	      return new ModelAndView("mainmenu","success",success);
	    
	
		
	}	
	
}
