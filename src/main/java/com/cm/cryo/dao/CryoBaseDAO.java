package com.cm.cryo.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.object.StoredProcedure;

public class CryoBaseDAO extends StoredProcedure {
	public CryoBaseDAO(DataSource dataSource) {
		super(dataSource, "");
		// clearing off declared parameters
		// so that when run with multiple stored procedures,
		// stored procedure parameters will not get overlapped.
		getDeclaredParameters().clear();
	}

	protected Map<String, Object> executeWithOutParameters() {
		compile();
		return this.execute();
	}
	/**
	 * providing custom implementation to take advantage of one data access
	 * implementation to handle multiple stored procedures
	 */
	public boolean isCompiled()
	{
		return false;
	}
}
