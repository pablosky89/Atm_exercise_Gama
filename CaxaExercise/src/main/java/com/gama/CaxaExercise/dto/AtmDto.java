package com.gama.CaxaExercise.dto;

import java.time.Instant;

import com.gama.CaxaExercise.entities.Atm;

public class AtmDto{
	
	private Long id;
	private Instant registerWithDraw;
	private Integer moneyWithdrawal;
	private String result;
	
	public AtmDto() {
		this.registerWithDraw = Instant.now(); 
	}
	
	public AtmDto(Atm atm) {
		id = atm.getId();
		registerWithDraw = atm.getRegisterWithDraw();
		setMoneyWithdrawal(atm.getMoneyWithdrawal());
		setResult(atm.getResult());
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getRegisterWithDraw() {
		return registerWithDraw;
	}
	public void setRegisterWithDraw(Instant registerWithDraw) {
		this.registerWithDraw = registerWithDraw;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getMoneyWithdrawal() {
		return moneyWithdrawal;
	}

	public void setMoneyWithdrawal(Integer moneyWithdrawal) {
		this.moneyWithdrawal = moneyWithdrawal;
	}

}
