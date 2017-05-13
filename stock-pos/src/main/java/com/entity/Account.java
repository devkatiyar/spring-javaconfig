package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long account_Id;

	private final String accountNo;

	private final String accountType;

	public Account(Long account_Id, String accountNo, String accountType) {
		this.account_Id = account_Id;
		this.accountNo = accountNo;
		this.accountType = accountType;
	}

	public Long getAccount_Id() {
		return account_Id;
	}

	public void setAccount_Id(Long account_Id) {
		this.account_Id = account_Id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

}
