package com.cm.cryo.dao;

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
@Repository
@Qualifier("cryoTankDetailDAOMySql")
public class CryoTankDetailDAOMySqlImpl extends CryoBaseDAO implements ICryoTankDetailDAO {
	public static final String IN_SQL_PARAM_TANK_ID = "param_tank_id";
	public static final String IN_SQL_PARAM_REG_ID = "param_reg_id";
	public static final String IN_SQL_PARAM_PATIENT_LAST_NAME = "param_patientLastName";
	public static final String IN_SQL_PARAM_HRN_NUM = "param_hrn_num";
	public static final String IN_SQL_PARAM_NIRC = "param_nirc";

	public CryoTankDetailDAOMySqlImpl(DataSource dataSource, String tankDetailSql) {
		super(dataSource, tankDetailSql);
		declareParametersForTankDetail();
	}

	private void declareParametersForTankDetail() {
		declareParameter(new SqlParameter(IN_SQL_PARAM_TANK_ID, Types.INTEGER));
		declareParameter(new SqlParameter(IN_SQL_PARAM_REG_ID, Types.INTEGER));
		declareParameter(new SqlParameter(IN_SQL_PARAM_PATIENT_LAST_NAME, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_SQL_PARAM_HRN_NUM, Types.VARCHAR));
		declareParameter(new SqlParameter(IN_SQL_PARAM_NIRC, Types.INTEGER));
		// declaring result set parameters
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TANKS_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoTankDetailMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_CANISTER_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoCanisterMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_LEVEL_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoLevelMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_CLINICIANS_RESULTSET,
				new CryoTankDetailResultSetMapper.CryoClinicianMapper()));
	}

	@Override
	public CryoTankDetailResponseDTO getTankDetail(CryoTankDetailRequestDTO tankDetailRequest) {
		return CryoTankDetailResponseMapper.formCryoTankDetailResponseFromResponseMap(
				this.executeWithParams(constructInputParameterMap(tankDetailRequest)));
	}

	private Map<String,Object> constructInputParameterMap(CryoTankDetailRequestDTO tankDetailRequest) {
		Map<String, Object> inputParameterMap = new HashMap<>();
		inputParameterMap.put(IN_SQL_PARAM_TANK_ID, tankDetailRequest.getTankId());
		inputParameterMap.put(IN_SQL_PARAM_REG_ID, tankDetailRequest.getRegistrationId());
		inputParameterMap.put(IN_SQL_PARAM_PATIENT_LAST_NAME, tankDetailRequest.getPatientLastName());
		inputParameterMap.put(IN_SQL_PARAM_HRN_NUM, tankDetailRequest.getHrnNumber());
		inputParameterMap.put(IN_SQL_PARAM_NIRC, tankDetailRequest.getNirc());

		return inputParameterMap;
	}
}
