package com.services;

import java.util.List;

import com.entity.Trade;

public interface ITradeService {
	
	void savetrade(Trade trade);
	
	List<Trade> getAllTrade();
	
	void saveTradeUsingJdbc(Trade trade);
	
	void insertProc(String employeeNo, String employeeType, String insId, int salary);
	

}
