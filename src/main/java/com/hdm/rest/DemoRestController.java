package com.hdm.rest;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hdm.model.Product;


@RestController
@RequestMapping("/test")
public class DemoRestController {

  @Autowired
  private SessionFactory sessionFactory;

  private Session session;
  
	@GetMapping("/hello")
	@Transactional
	public String sayHello() {
      session = sessionFactory.getCurrentSession();
      Product p=new Product(1,"sagar");
      session.save(p);
      
      return "Hello World!";
      
	}	
}
