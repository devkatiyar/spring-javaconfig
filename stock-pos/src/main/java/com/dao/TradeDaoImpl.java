package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Trade;

@Repository
@Transactional
public class TradeDaoImpl implements TradeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public TradeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TradeDaoImpl() {

	}

	@CachePut("alluserscache")
	public void saveTrade(Trade trade) {
		getSession().save(trade);

	}

	@Override
	@Cacheable("alluserscache")
	public List<Trade> getAllTrade() {
		System.out.println("hiiting database");
		List<Trade> allTrade = (List<Trade>) getSession().createCriteria(Trade.class)
				.setResultTransformer(Criteria.ROOT_ENTITY).list();
		return allTrade;

	}

	@Override
	public void saveTradeUsingJdbc(Trade trade) {
		String insertSql = "insert into trade values(?,?)";
		jdbcTemplate.update(insertSql, trade.getUnit(), trade.getStock());

	}

}
