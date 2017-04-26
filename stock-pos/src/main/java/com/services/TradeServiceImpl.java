package com.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TradeDao;
import com.entity.Trade;
import com.spring.AppContext;
import com.spring.ThreadPoolConfig;

@Component
@Transactional
public class TradeServiceImpl implements TradeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TradeDao tradeDao;

	@Autowired
	ThreadPoolConfig threadPoolConfig;

	@Autowired
	AppContext context;

	@Autowired
	TradeServiceExecutor tradeServiceExecutor;

	@Override
	public void savetrade(Trade trade) {
		
		logger.info("starting ====================Load trade  data into database");

		// ThreadPoolTaskExecutor task = (ThreadPoolTaskExecutor)
		// context.getBean("taskExecutor");

		ThreadPoolTaskExecutor task = threadPoolConfig.threadPoolExeccutor();
		tradeServiceExecutor.setTrade(trade);
		task.execute(tradeServiceExecutor);
		logger.info("end ====================Load trade  data into database");

	}

}
