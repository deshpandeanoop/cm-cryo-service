package com.cm.cryo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.helpers.CryoTankResultSetMapper;
import com.cm.cryo.idao.ICryoTankDAO;
import com.cm.cryo.util.CryoConstants;

@Repository
public class CryoTankDAO extends CryoBaseDAO implements ICryoTankDAO {
	public CryoTankDAO(DataSource dataSource) {
		super(dataSource,CryoConstants.CRYO_GET_TANKS);
		declareParametersForTankDetails();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CryoTankDTO> getTanks() {
		return (List<CryoTankDTO>) this.executeWithOutParameters().get(CryoConstants.CRYO_TANKS_RESULTSET);
	}

	private void declareParametersForTankDetails() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TANKS_RESULTSET,
				new CryoTankResultSetMapper.CryoTankDetailsMapper()));
	}
}
