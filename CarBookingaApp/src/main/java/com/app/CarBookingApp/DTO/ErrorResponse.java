package com.app.CarBookingApp.DTO;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse {
	private LocalDateTime timeStamp;
	private String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}

}
