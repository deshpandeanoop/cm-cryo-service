package com.cm.cryo.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.object.StoredProcedure;

public class CryoBaseDAO extends StoredProcedure {
	public CryoBaseDAO(DataSource dataSource) {
		super(dataSource, "");
	}

	protected Map<String, Object> executeWithOutParameters() {
		compile();
		return this.execute();
	}

	protected Map<String, Object> executeWithParams(Map<String, Object> inputParameters) {
		compile();
		return this.execute(inputParameters);
	}

	/**
	 * providing custom implementation to take advantage of one data access
	 * implementation to handle multiple stored procedures
	 */
	public boolean isCompiled() {
		return false;
	}
}
