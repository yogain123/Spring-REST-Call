package com.yogendra.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	
	@org.springframework.transaction.annotation.Transactional
	public List<Customer> getCustomers() {
		
		System.out.println("insdie session");
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Customer> customers = new ArrayList<Customer>();
		
		//Customer c1 = new Customer(1, "yogi", "saxena", "ys@gmail.com");
		
		//Session session = factory.getCurrentSession();
		
	   //Query<Customer> query = session.createQuery("from customer",Customer.class);
		
		Criteria c = session.createCriteria(Customer.class);
		
		customers = c.list();
		
		
		//Query query = session.createQuery("from Customer",Customer.class);
		//query.getResultList();
		Gson gson = new Gson();

		String json = gson.toJson(customers);
		System.out.println(json+" JSONNNNN");

		
		
		
		
		return customers;
	}



	@org.springframework.transaction.annotation.Transactional
	public String postCustomers(String data) {
		
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("DAta in session post inside"+ data);
		
		
		try{
		
//		Gson gson = new Gson();
//		customers = gson.fromJson(data, new TypeToken<List<Customer>>(){}.getType());
//		
//		System.out.println("final "+customers);
//		
//		for(Customer c : customers)
//		{
//			session.save(c);
//		}
			
			Gson gson = new Gson();
			Customer c = gson.fromJson(data, Customer.class);
			session.save(c);
		
		return "success";
		}
		catch(Exception e){
			e.printStackTrace();
			
			return "failed";
			
		}
	}


	@org.springframework.transaction.annotation.Transactional
	public String deleteCustomers(String data) {
		
		System.out.println("inside delete dao");
		
		List<Customer> customers = new ArrayList<Customer>(); 
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria c = session.createCriteria(Customer.class);
		customers = c.add(Restrictions.eq("firstName", data)).list();
		
		for(Customer cust : customers)
			session.delete(cust);
		
		return "delete Success";
		
	}
	
	@org.springframework.transaction.annotation.Transactional
	public String updateCustomers(String data) {
		
		System.out.println("inside delete dao");
		
		List<Customer> customers = new ArrayList<Customer>(); 
		
		Session session = sessionFactory.getCurrentSession();
		
		Gson gson = new Gson();
		Customer customer = gson.fromJson(data, Customer.class);
		
		
		
		Criteria c = session.createCriteria(Customer.class);
		customers = c.add(Restrictions.eq("firstName", customer.getFirstName())).list();
		
		for(Customer cust : customers)
		{
			cust.setEmail(customer.getEmail());
			cust.setLastName(customer.getLastName());
			
			session.update(cust);
		}
		
		return "Update Success";
		
	}

}
