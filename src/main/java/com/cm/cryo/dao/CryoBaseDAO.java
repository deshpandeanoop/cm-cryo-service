package com.cm.cryo.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.object.StoredProcedure;

public class CryoBaseDAO extends StoredProcedure {
	public CryoBaseDAO(DataSource dataSource, String sql) {
		super(dataSource, sql);
	}

	protected Map<String, Object> executeWithOutParameters() {
		compile();
		return this.execute();
	}
}
