package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TradeDao;
import com.entity.Trade;

@Component
@Transactional
public class TraService implements ITradeService {

	@Autowired
	TradeDao tradeDao;

	@Override
	public void savetrade(Trade trade) {
		tradeDao.saveTrade(trade);

	}

	@Override
	public List<Trade> getAllTrade() {
		// TODO Auto-generated method stub
		return tradeDao.getAllTrade();
	}

	@Override
	public void saveTradeUsingJdbc(Trade trade) {
		tradeDao.saveTradeUsingJdbc(trade);
		
	}

}
