package com.app.CarBookingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.CarBookingApp.pojos.User;

public interface UserInterface extends JpaRepository<User, Long> {
	
}
