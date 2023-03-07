package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.CustomerException;
import com.example.Model.Customer;
import com.example.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private PasswordEncoder pe;
	
	
	@PostMapping("/Customers")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer c)throws CustomerException
	{
		c.setPassword(pe.encode(c.getPassword()));
		Customer cs1= cs.RegisterCustomer(c);
		return new ResponseEntity<Customer>(cs1,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Customers/{email}")
	public ResponseEntity<Customer> getByEmail(@PathVariable("email") String email)throws CustomerException
	{
		Customer cs1= cs.getCustomerDetailByEmail(email);
		return new ResponseEntity<Customer>(cs1,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Customers/all")
	public ResponseEntity<List<Customer>> getAllCustomers()throws CustomerException
	{
		List<Customer> cs1= cs.getAllCustomer();
		return new ResponseEntity<List<Customer>>(cs1,HttpStatus.ACCEPTED);
	}

}
