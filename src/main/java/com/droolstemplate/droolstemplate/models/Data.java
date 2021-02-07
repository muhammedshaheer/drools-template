package com.droolstemplate.droolstemplate.models;

import java.sql.Date;

@lombok.Data
public class Data {
	
	int userId;
	String email;
	String firstName;
	String lastName;
	Date dateOfBirth;

}
