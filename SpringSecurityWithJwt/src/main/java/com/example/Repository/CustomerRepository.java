package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	public Optional<Customer> FindByEmail(String email);
}
