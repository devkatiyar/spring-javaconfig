package com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties
@ComponentScan(basePackages = { "com.spring" })
public class PropertiesConfiguration {

	@Value("${mySql.driverClassName}")
	private String mySqlDriverClassName;
	
	@Value("${mySql.url}")
	private String mySqlUrl;

	@Value("${mySql.username}")
	private String mySqlUsername;

	@Value("${mySql.password}")
	private String mySqlPassword;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	@Value("${hibernate.generate_statistics}")
	private String hibernateGenerateStatistics;

	public String getMySqlDriverClassName() {
		return mySqlDriverClassName;
	}

	public void setMySqlDriverClassName(String mySqlDriverClassName) {
		this.mySqlDriverClassName = mySqlDriverClassName;
	}

	public String getMySqlUrl() {
		return mySqlUrl;
	}

	public void setMySqlUrl(String mySqlUrl) {
		this.mySqlUrl = mySqlUrl;
	}

	public String getMySqlUsername() {
		return mySqlUsername;
	}

	public void setMySqlUsername(String mySqlUsername) {
		this.mySqlUsername = mySqlUsername;
	}

	public String getMySqlPassword() {
		return mySqlPassword;
	}

	public void setMySqlPassword(String mySqlPassword) {
		this.mySqlPassword = mySqlPassword;
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getHibernateShowSql() {
		return hibernateShowSql;
	}

	public void setHibernateShowSql(String hibernateShowSql) {
		this.hibernateShowSql = hibernateShowSql;
	}

	public String getHibernateGenerateStatistics() {
		return hibernateGenerateStatistics;
	}

	public void setHibernateGenerateStatistics(String hibernateGenerateStatistics) {
		this.hibernateGenerateStatistics = hibernateGenerateStatistics;
	}
	
	
	
}
