package com.app.CarBookingApp.pojos;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Driver extends BaseEntity{
	
	private Person driver; 
	private Vehicle vehicle;
	private Location location;
	private boolean isAvailable ;
	
}
