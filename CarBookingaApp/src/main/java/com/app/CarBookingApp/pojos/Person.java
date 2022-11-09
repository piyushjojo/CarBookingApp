package com.app.CarBookingApp.pojos;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	
	private String name ; 
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private int age; 

}
