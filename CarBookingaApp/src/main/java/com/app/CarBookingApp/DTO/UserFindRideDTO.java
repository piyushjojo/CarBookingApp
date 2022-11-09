package com.app.CarBookingApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserFindRideDTO {
	private String name ; 
	private int sourceX ; 
	private int sourceY;
	
	private int destinationX;
	private int destinationY;

}
