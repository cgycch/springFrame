package com.cch.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSouceConfig {

	@Bean
	public DataSource myDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test_demo?useUnicode=true&characterEncoding=utf-8");
		dataSource.setPassword("root");
		dataSource.setUsername("root");
		return dataSource;
	}
	@Bean
	public JdbcTemplate myJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource());
		return jdbcTemplate;
	}

}
