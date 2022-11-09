package com.app.CarBookingApp.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CarBookingApp.DTO.UserDTO;
import com.app.CarBookingApp.pojos.Person;
import com.app.CarBookingApp.pojos.User;
import com.app.CarBookingApp.repository.UserInterface;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserInterface userRepo ; 
	
	@Autowired
	private ModelMapper mapper ; 
	
	public String addUser(UserDTO userDTO) {
		Person person = mapper.map(userDTO, Person.class);
		userRepo.save(new User(person));
		return "User added successfully";
	}

}
