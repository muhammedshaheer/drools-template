package com.droolstemplate.droolstemplate.utils.drools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.springframework.stereotype.Component;

import com.droolstemplate.droolstemplate.models.Customer;
import com.droolstemplate.droolstemplate.models.Data;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KieSession {
	
	
	public void buildKieSession() {
		
		try {
			String drl = applyRuleTemplate();
			buildKieSession(drl);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
		}
		
		
	}
	
	
	private String applyRuleTemplate() throws Exception {
		
		Map<String, String> data = new HashMap<String, String>();
		ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();

		data.put("ruleName", "Rule1");

		return objectDataCompiler.compile(Arrays.asList(data),
				Thread.currentThread().getContextClassLoader().getResourceAsStream("drools/rule.drl"));
	}

	
	
	private void buildKieSession(String drl) throws Exception {
		
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write("src/main/resources/drools/rule-template.drl", drl);
		kieServices.newKieBuilder(kieFileSystem).buildAll();
		
	}
}
