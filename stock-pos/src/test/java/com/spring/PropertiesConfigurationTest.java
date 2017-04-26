package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dao.TradeDao;
import com.entity.Trade;

@RunWith(SpringRunner.class)
@SpringBootTest

//SpringApplicationConfiguration   @ContextConfiguration
@ContextConfiguration(classes={PropertiesConfiguration.class,DataSourceConfiguration.class})
public class PropertiesConfigurationTest {
	
	@Autowired
	PropertiesConfiguration propertiesConfiguration;
	
	
	@Autowired 
	TradeDao tradeDao;
	
	
	public PropertiesConfiguration getPropertiesConfiguration() {
		return propertiesConfiguration;
	}




	public void setPropertiesConfiguration(PropertiesConfiguration propertiesConfiguration) {
		this.propertiesConfiguration = propertiesConfiguration;
	}




//	@Test
//	public void applicationPropertiesTest(){
//		
//		propertiesConfiguration.getHibernateDialect();
//		System.out.println(propertiesConfiguration.getMySqlUsername());
//		
//	}
	
	@Test
	public void tradeDaoTest(){
		
		try{
		
		Trade trade=new Trade("100", "IBM1");
		
		System.out.println(propertiesConfiguration.getMySqlUsername());
		tradeDao.saveTrade(trade);
		System.out.println(propertiesConfiguration.getMySqlUsername());
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		
	}
	
	
	

}
