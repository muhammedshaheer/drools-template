package com.droolstemplate.droolstemplate.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droolstemplate.droolstemplate.models.Customer;
import com.droolstemplate.droolstemplate.models.Data;
import com.droolstemplate.droolstemplate.services.UnificationRule;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DroolsController {
	
	@Autowired
	UnificationRule ruleService;
	
	Date date;
	
	@GetMapping(path = "/template")
	public Customer fireRule() {
		
		Data data = new Data();
		data.setFirstName("Customer");
		Customer customer = new Customer();
		customer.setName("Customer");


		data.setDateOfBirth(new Date(2014, 02, 11));
		
		return ruleService.fireUnificationRule(customer, data);
		
	}

}
