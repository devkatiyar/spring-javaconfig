package com.dao;

import java.util.List;

import com.entity.Trade;

public interface TradeDao {
	

	
	void saveTradeUsingJdbc(Trade trade);
	List<Trade> getTradeList();
}
