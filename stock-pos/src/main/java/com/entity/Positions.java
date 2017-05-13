package com.entity;

public class Positions {

	private long account_id;
	private String insId;
	private long price;

	public Positions(long account_id, String insId, long price) {
		this.account_id = account_id;
		this.insId = insId;
		this.price = price;
	}

	public Positions() {

	}

	public long getAccount_id() {
		return account_id;
	}

	public String getInsId() {
		return insId;
	}

	public long getPrice() {
		return price;
	}

}
