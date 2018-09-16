package com.cm.cryo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cm.cryo.util.CryoConstants;

@Configuration
public class CryoBeansConfigurer {
	@Bean
	public String emptyBean()
	{
		return "";
	}
	@Bean("tankDetailSql")
	public String tankDetailSql()
	{
		return CryoConstants.CRYO_GET_TANK_DETAIL;
	}
}
