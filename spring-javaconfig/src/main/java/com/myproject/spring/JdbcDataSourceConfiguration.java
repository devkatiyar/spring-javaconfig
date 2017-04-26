package com.myproject.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JdbcDataSourceConfiguration {

	@Autowired
	PropertiesConfiguration propertiesConfig;

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(propertiesConfig.getMySqlDriverClassName());
		dataSource.setUrl(propertiesConfig.getMySqlUrl());
		dataSource.setUsername(propertiesConfig.getMySqlUsername());
		dataSource.setPassword(propertiesConfig.getMySqlPassword());
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

//	@Bean(name="jdbcTrx")
//	public DataSourceTransactionManager dataSourceTransactionManager() {
//		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(getDataSource());
//		//dataSourceTransactionManager.setDataSource(getDataSource());
//		
//		
//
//		return dataSourceTransactionManager;
//	}

}
