package com.app.CarBookingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.CarBookingApp.pojos.Driver;

public interface DriverInterface extends JpaRepository<Driver, Long> {

}
