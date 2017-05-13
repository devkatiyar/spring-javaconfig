package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
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

	@Override
	public void insertProc(String employeeNo, String employeeType, String insId, int salary) {
		final String procedureCall = "{call INSERTEMP(?, ?, ?,?,?)}";
		Connection connection = null;
		try{
			//Get Connection instance from dataSource
			//connection = jdbcTemplate.getDataSource().getConnection();
			CallableStatement callableSt = jdbcTemplate.getDataSource().getConnection().prepareCall(procedureCall);
			callableSt.setString(1, employeeNo);
			callableSt.setString(2, employeeType);
			callableSt.setString(3, insId);
			callableSt.setInt(4, salary);
			callableSt.registerOutParameter(5, Types.BIGINT);

			//Call Stored Procedure
			callableSt.executeUpdate();
			System.out.println(callableSt.getString(5));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
