package com.hotelapp.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	public ApiErrors() {
		super();
	}

	String message;
	List<String> details;
	HttpStatus status;
	LocalDateTime timestamp;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public ApiErrors(String message, List<String> details, HttpStatus status, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.status = status;
		this.timestamp = timestamp;
	}

}
