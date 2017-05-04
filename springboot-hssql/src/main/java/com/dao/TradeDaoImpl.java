package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Trade;

@Repository
@Transactional
public class TradeDaoImpl implements TradeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;



	public TradeDaoImpl() {

	}

	


	@Transactional
	public void saveTradeUsingJdbc(Trade trade) {
		String insertSql = "insert into trade values(?,?)";
		jdbcTemplate.update(insertSql, trade.getUnit(), trade.getStock());
		
		List<Trade>list =getTradeList();
		System.out.println(list);

	}




	@Override
	public List<Trade> getTradeList() {
		final String selectSql="SELECT * FROM TRADE";
		 List<Trade> listTrade = jdbcTemplate.query(selectSql, new RowMapper<Trade>() {
			 
		        @Override
		        public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	Trade trade = new Trade();
		        	trade.setUnit(rs.getString("UNIT"));
		        	trade.setStock(rs.getString("STOCK"));
		        	
		          
		            return trade;
		        }
		 
		    });
		return listTrade;
		

	}

}
