package com.app.CarBookingApp.DTO;

import com.app.CarBookingApp.pojos.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DriverDTO {
	private String name;
	private Gender gender;
	private int age;

	private String model;
	private String vehicleNumber;
	
	private int x ; 
	private int y ; 

}
