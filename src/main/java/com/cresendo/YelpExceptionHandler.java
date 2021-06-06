package com.cresendo;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cresendo.exception.BusinessNotFoundException;

@ControllerAdvice
public class YelpExceptionHandler {

	@ExceptionHandler(BusinessNotFoundException.class)
	public ResponseEntity<Object> handleBusinessNotFoundException() {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Business not found");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
