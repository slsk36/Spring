package com.naver;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MyConf {
	
	@Bean
	@Qualifier(value = "ds")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncording=utf8");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/spring5fs?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
