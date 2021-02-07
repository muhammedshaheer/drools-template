package com.droolstemplate.droolstemplate.applicationrunners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.droolstemplate.droolstemplate.models.Customer;
import com.droolstemplate.droolstemplate.utils.drools.KieSession;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoadDrools implements ApplicationRunner {
	
	@Autowired
	KieSession kieSession;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		kieSession.buildKieSession();

	}

}
