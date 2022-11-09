package com.app.CarBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.CarBookingApp.DTO.DriverDTO;
import com.app.CarBookingApp.DTO.UserDTO;
import com.app.CarBookingApp.DTO.UserFindRideDTO;
import com.app.CarBookingApp.pojos.Driver;
import com.app.CarBookingApp.pojos.Location;
import com.app.CarBookingApp.service.DriverService;
import com.app.CarBookingApp.service.UserService;

@RestController
@RequestMapping("/main")
public class Controller {
	@Autowired
	private UserService userService ; 
	
	@Autowired
	private DriverService driverService ; 
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UserDTO user){
		System.out.println("in add user");
		return new ResponseEntity<String>(userService.addUser(user), HttpStatus.OK);
	}
	
	@PostMapping("/addDriver")
	public ResponseEntity<?> addDriver(@RequestBody DriverDTO driver){
		return new ResponseEntity<String>(driverService.addDriver(driver), HttpStatus.OK);
	}
	
	@GetMapping("/findRide")
	public ResponseEntity<?> findRide(@RequestBody  UserFindRideDTO userFindRideDTO){
		Location source = new Location(userFindRideDTO.getSourceX(), userFindRideDTO.getSourceY());

		List<Driver> driverList = driverService.findRide(source);
		if(driverList == null) {
			return new ResponseEntity<String>("No Ride Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Driver>>(driverList, HttpStatus.OK);
	}
	
	@PostMapping("/selectRide/{id}")
	public ResponseEntity<?> chooseRide(@RequestBody UserFindRideDTO userFindRideDTO, @PathVariable Long id ){
		Location source = new Location(userFindRideDTO.getSourceX(), userFindRideDTO.getSourceY());

		return new ResponseEntity<String>(driverService.chooseRide(id, source ), HttpStatus.OK);
	}
}
