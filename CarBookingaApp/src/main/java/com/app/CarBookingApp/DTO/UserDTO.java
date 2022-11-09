package com.app.CarBookingApp.DTO;

import com.app.CarBookingApp.pojos.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

	private String name;

	private Gender gender;

	private int age;

}
