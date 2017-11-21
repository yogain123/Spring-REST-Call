package com.yogendra.test;

import java.util.List;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers();
	
	public String postCustomers(String data);
	
	public String deleteCustomers(String data);
	
	public String updateCustomers(String data);

}
