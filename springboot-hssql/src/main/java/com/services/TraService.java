package com.services;

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

	public void saveTradeUsingJdbc(Trade trade) {
		tradeDao.saveTradeUsingJdbc(trade);

	}

}
