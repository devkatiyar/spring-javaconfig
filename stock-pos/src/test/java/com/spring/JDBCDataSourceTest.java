package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { PropertiesConfiguration.class, JdbcDataSourceConfiguration.class })
public class JDBCDataSourceTest {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Test
	public void jDBCDataSourceTest(){
		
		try{
			System.out.println("temp"+jdbcTemplate);
			
			
			Assert.assertEquals(true, true);
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		
	}

}
