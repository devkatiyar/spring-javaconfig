package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TradeDao;
import com.entity.Trade;

@Component
@Scope(value="prototype")
public class TradeServiceExecutor implements Runnable {

	@Autowired 
	TradeDao tradeDao;
	
	Trade trade;	
	public Trade getTrade() {
		return trade;
	}
	
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
	@Override
	public void run() {
		System.out.println("runnig");
		tradeDao.saveTrade(trade);
		
	}

}
