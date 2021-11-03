package com.gama.CaxaExercise.services.exceptions;

public class InvalidWithdrawalValueException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidWithdrawalValueException(String msg) {
		super(msg);
	}

	
}
