package com.gama.CaxaExercise.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gama.CaxaExercise.services.exceptions.InvalidWithdrawalValueException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(InvalidWithdrawalValueException.class)
	public ResponseEntity<StandardError> database(InvalidWithdrawalValueException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Invalid withdrawal value");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
