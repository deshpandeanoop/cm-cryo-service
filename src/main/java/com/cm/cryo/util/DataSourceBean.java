package com.cm.cryo.util;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DataSourceBean {

	@Bean("dataSource")
	@Primary
	public DataSource getDataSource() {

		return DataSourceBuilder.create().url("jdbc:sqlserver://localhost;dataBase=cm_cryo;integratedSecurity=true")
				.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver").build();
	}
	
}
