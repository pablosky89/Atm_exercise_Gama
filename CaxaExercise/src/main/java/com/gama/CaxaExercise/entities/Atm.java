package com.gama.CaxaExercise.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tb_atm")
public class Atm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant registerWithDraw;
	private Integer moneyWithdrawal;
	private String result;
	
	
	public Atm() {
		this.registerWithDraw = Instant.now(); 
	}

	public Atm(Long id, Instant registerWithDraw, Integer moneyWithdrawal, String result) {
		super();
		this.id = id;
		this.registerWithDraw = registerWithDraw;
		this.setMoneyWithdrawal(moneyWithdrawal);
		this.result = result;
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
