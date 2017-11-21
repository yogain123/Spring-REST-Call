package com.yogendra.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */


@Controller
public class hola
{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
    public @ResponseBody String listCustomer(Model model)
    {
		List<Customer> customer = new ArrayList<Customer>();
		customer = customerDAO.getCustomers();
		Gson gson = new Gson();
		String res = gson.toJson(customer);
		return res;
    }
	
	@RequestMapping(value="/list",method=RequestMethod.POST,produces={MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody String postCustomer(@RequestBody String data)
    {
    	System.out.println("insdie post "+data);
		List<Customer> customer = new ArrayList<Customer>();
		String res = customerDAO.postCustomers(data);
		//Gson gson = new Gson();
		//String res = gson.toJson(customer);
		return res;
    }
	
	@RequestMapping(value="/list/{data}",method=RequestMethod.GET)
    public @ResponseBody String deleteCustomer(@PathVariable String data)
    {
    	System.out.println("insdie post "+data);
		List<Customer> customer = new ArrayList<Customer>();
		String res = customerDAO.deleteCustomers(data);
		//Gson gson = new Gson();
		//String res = gson.toJson(customer);
		return res;
    }
	
	@RequestMapping(value="/list/update",method=RequestMethod.POST, produces={MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody String updateCustomer(@RequestBody String data)
    {
		System.out.println("inside update");
    	System.out.println("insdie post "+data);
		List<Customer> customer = new ArrayList<Customer>();
		String res = customerDAO.updateCustomers(data);
		//Gson gson = new Gson();
		//String res = gson.toJson(customer);
		return res;
    }
	
	@RequestMapping("/")
    public String index(Model model)
    {
		//System.out.println(System.getProperty("catalina.base"));

    	System.out.println("inside");
        return "resources/static/html/index.html";
    }
	
	
	@RequestMapping(value = "/next" , method = RequestMethod.GET,produces={MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody String home(Model model)
    {
    	System.out.println("json");
        return "json Data";
    }
	
	
}
