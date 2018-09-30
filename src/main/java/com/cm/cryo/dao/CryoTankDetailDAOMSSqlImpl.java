package com.cm.cryo.dao;

import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;
import com.cm.cryo.helpers.CryoTankDetailResponseMapper;
import com.cm.cryo.helpers.CryoTankDetailResultSetMapper;
import com.cm.cryo.idao.ICryoTankDetailDAO;
import com.cm.cryo.util.CryoConstants;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;

@Repository
@Qualifier("cryoTankDetailDAOMSSql")
public class CryoTankDetailDAOMSSqlImpl extends CryoBaseDAO implements ICryoTankDetailDAO {

	public CryoTankDetailDAOMSSqlImpl(DataSource dataSource, String tankDetailSql) {
		super(dataSource, tankDetailSql);
		declareParametersForTankDetail();
	}

	@Override
	public CryoTankDetailResponseDTO getTankDetail(CryoTankDetailRequestDTO tankDetailRequest) {

		return CryoTankDetailResponseMapper.formCryoTankDetailResponseFromResponseMap(
				this.executeWithParams(constructInputSearchCriteria(tankDetailRequest)));
	}

	private void declareParametersForTankDetail() {
		declareParameter(new SqlParameter(CryoConstants.CM_TANK_DETAIL_FILTER, microsoft.sql.Types.STRUCTURED));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TANKS_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoTankDetailMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_CANISTER_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoCanisterMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_LEVEL_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoLevelMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_CLINICIANS_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoClinicianMapper()));
	}

	private Map<String, Object> constructInputSearchCriteria(CryoTankDetailRequestDTO tankDetailRequest) {
		Map<String, Object> inputParamMap = new HashMap<>();
		try {
			SQLServerDataTable filterCriteriaTvp = new SQLServerDataTable();
			filterCriteriaTvp.addColumnMetadata("tank_id", Types.INTEGER);
			filterCriteriaTvp.addColumnMetadata("reg_id", Types.INTEGER);
			filterCriteriaTvp.addColumnMetadata("pat_last_name", Types.VARCHAR);
			filterCriteriaTvp.addColumnMetadata("hrn_num", Types.VARCHAR);
			filterCriteriaTvp.addColumnMetadata("nirc", Types.INTEGER);
			filterCriteriaTvp.addRow(tankDetailRequest.getTankId(), tankDetailRequest.getRegistrationId(),
					tankDetailRequest.getPatientLastName(), tankDetailRequest.getHrnNumber(),
					tankDetailRequest.getNirc());
			inputParamMap.put(CryoConstants.CM_TANK_DETAIL_FILTER, filterCriteriaTvp);
		} catch (SQLException sqlException) {
			// Control never goes into the catch block, so eating away the exception
		}
		return inputParamMap;
	}

}
