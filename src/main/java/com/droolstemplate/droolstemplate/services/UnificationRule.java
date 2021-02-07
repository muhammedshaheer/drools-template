package com.droolstemplate.droolstemplate.services;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Component;

import com.droolstemplate.droolstemplate.models.Customer;
import com.droolstemplate.droolstemplate.models.Data;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UnificationRule {
	
	
	public Customer fireUnificationRule(Customer customer, Data data) {
		
		
		KieServices kieServices = KieServices.Factory.get();

		KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
		
        org.kie.api.runtime.KieSession kieSession = kieContainer.newKieSession();

		kieSession.insert(customer);
		kieSession.insert(data);


		kieSession.fireAllRules();
		
	    log.info(customer.toString());
		return customer;
	}

}
