package com.app.CarBookingApp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CarBookingApp.DTO.DriverDTO;
import com.app.CarBookingApp.pojos.Driver;
import com.app.CarBookingApp.pojos.Location;
import com.app.CarBookingApp.pojos.Person;
import com.app.CarBookingApp.pojos.Vehicle;
import com.app.CarBookingApp.repository.DriverInterface;

@Service
@Transactional
public class DriverService {
	@Autowired
	private DriverInterface driverRepo;

	@Autowired
	private ModelMapper mapper;

	public String addDriver(DriverDTO driverDTO) {
		Person person = mapper.map(driverDTO, Person.class);
		Vehicle vehicle = mapper.map(driverDTO, Vehicle.class);
		Location location = mapper.map(driverDTO, Location.class);

		Driver driver = new Driver(person, vehicle, location, true);
		driverRepo.save(driver);

		return "driver added successfully";
	}
	
	public String setStatus(Long id) {
		Driver driver = driverRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Invalid driver id"));
		driver.setAvailable(!driver.isAvailable());
		return "Status changed";
	}
	
	public Optional<Driver> findRide(Location source){
		
		return driverRepo.findAll().stream()
				.filter(d -> d.isAvailable() && distance(d.getLocation() , source)<= 5)
				.sorted((d1,d2) -> distance(d1.getLocation(),source).compareTo(distance(d2.getLocation(),source))).findFirst();
	}
	
	public Double distance(Location loc1 , Location loc2) {
		return Math.hypot(Math.abs(loc1.getX() - loc2.getX()), Math.abs(loc1.getY() - loc2.getY()));
	}
	

}
