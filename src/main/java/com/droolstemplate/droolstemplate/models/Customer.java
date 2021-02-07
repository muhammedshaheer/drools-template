package com.droolstemplate.droolstemplate.models;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Customer {
	
	int id;
	String name;
	Date dateOfBirth;
	String dateString;

}
