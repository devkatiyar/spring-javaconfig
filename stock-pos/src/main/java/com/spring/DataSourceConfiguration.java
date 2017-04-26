package com.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dao.TradeDao;
import com.dao.TradeDaoImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.spring" })

@EnableAutoConfiguration(exclude = {
        JpaRepositoriesAutoConfiguration.class
})
public class DataSourceConfiguration {

	@Autowired
	PropertiesConfiguration propertiesConfig;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(propertiesConfig.getMySqlDriverClassName());
		dataSource.setUrl(propertiesConfig.getMySqlUrl());
		dataSource.setUsername(propertiesConfig.getMySqlUsername());
		dataSource.setPassword(propertiesConfig.getMySqlPassword());
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

	/*
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.entity");
		return sessionBuilder.buildSessionFactory();
	}
	
	

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	*/
	
	
	@Bean(name = "sessionFactory")
	  public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(dataSource());
	    sessionFactoryBean.setPackagesToScan("com.entity");
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", propertiesConfig.getHibernateDialect());
	    hibernateProperties.put("hibernate.show_sql", propertiesConfig.getHibernateShowSql());
	    hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    
	    return sessionFactoryBean;
	  }

	
	  @Bean
	  public HibernateTransactionManager transactionManager() {
	    HibernateTransactionManager transactionManager = 
	        new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	}
	  
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", propertiesConfig.getHibernateShowSql());
		properties.put("hibernate.dialect", propertiesConfig.getHibernateDialect());
		return properties;
	}
	
	
	
	@Bean(name = "tradeDao")
	public TradeDao getTradeDao() {
		TradeDao tradeDao=new TradeDaoImpl();
		return tradeDao;
	}
	
	
	
	
}
