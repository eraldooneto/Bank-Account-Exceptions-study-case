package model.entities;

import model.exceptions.DomainException;

public final class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit){
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public final void deposit(Double amount) {
		balance += amount;
	}
	
	public final void withdraw(Double amount) throws DomainException {
		if(amount > balance) {
			throw new DomainException("The amount to withdraw exceeds the total balance available.");
			
		} else if (amount > withdrawLimit) {
			throw new DomainException("The amount to withdraw exceeds the limit.");
			
		} else {
			balance -= amount;
		}
		
	}
	
}
