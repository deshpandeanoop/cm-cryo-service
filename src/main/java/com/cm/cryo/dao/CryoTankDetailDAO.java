package com.cm.cryo.dao;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoCanisterDTO;
import com.cm.cryo.dto.CryoCanisterLevelDTO;
import com.cm.cryo.dto.CryoClinicianDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDetailRequestDTO;
import com.cm.cryo.dto.CryoTankDetailResponseDTO;
import com.cm.cryo.helpers.CryoTankDetailResultSetMapper;
import com.cm.cryo.idao.ICryoTankDetailDAO;
import com.cm.cryo.util.CryoConstants;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;

@Repository
public class CryoTankDetailDAO extends CryoBaseDAO implements ICryoTankDetailDAO {

	public CryoTankDetailDAO(DataSource dataSource,String tankDetailSql) {
		super(dataSource, tankDetailSql);
		declareParametersForTankDetail();
	}

	@Override
	public CryoTankDetailResponseDTO getTankDetail(CryoTankDetailRequestDTO tankDetailRequest) {

		return formCryoTankDetailResponseFromResponseMap(
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
			filterCriteriaTvp.addColumnMetadata("pat_last_name", Types.VARCHAR);
			filterCriteriaTvp.addColumnMetadata("hrn_num", Types.VARCHAR);
			filterCriteriaTvp.addColumnMetadata("nirc", Types.INTEGER);

			filterCriteriaTvp.addRow(tankDetailRequest.getTankId(),
					(tankDetailRequest.getPatientLastName() == null ? "" : tankDetailRequest.getPatientLastName()),
					(tankDetailRequest.getHrnNumber() == null ? "" : tankDetailRequest.getHrnNumber()),
					tankDetailRequest.getNirc());
			inputParamMap.put(CryoConstants.CM_TANK_DETAIL_FILTER, filterCriteriaTvp);
		} catch (SQLException sqlException) {
			// Control never goes into the catch block, so eating away the exception
		}
		return inputParamMap;
	}

	@SuppressWarnings("unchecked")
	private CryoTankDetailResponseDTO formCryoTankDetailResponseFromResponseMap(Map<String, Object> responseMap) {
		CryoTankDetailResponseDTO tankDetailResponse = new CryoTankDetailResponseDTO();
		List<CryoTankDTO> tanks = (List<CryoTankDTO>) responseMap.get(CryoConstants.CRYO_TANKS_RESULTSET);
		// Since tank_id is unique for the tank, there exits only one element in the list.
		// There is also no possibility of getting empty list, since always valid non-deleted tank_id is passed in the request
		CryoTankDTO tank = tanks.get(0);
		List<CryoCanisterDTO> canisters = (List<CryoCanisterDTO>) responseMap
				.get(CryoConstants.CRYO_CANISTER_RESULTSET);
		if (null != canisters && !canisters.isEmpty()) {
			formCanistersFromResponse(canisters,
					(List<CryoCanisterLevelDTO>) responseMap.get(CryoConstants.CRYO_LEVEL_RESULTSET));
		}
		tank.setCanisters(canisters);
		tankDetailResponse.setTank(tank);
		tankDetailResponse
				.setDoctors((List<CryoClinicianDTO>) responseMap.get(CryoConstants.CRYO_CLINICIANS_RESULTSET));
		return tankDetailResponse;
	}

	private List<CryoCanisterDTO> formCanistersFromResponse(List<CryoCanisterDTO> canisters,
			List<CryoCanisterLevelDTO> levels) {
		if (null != levels && !levels.isEmpty()) {
			List<CryoCanisterLevelDTO> canisterLevels = null;
			for (CryoCanisterDTO canister : canisters) {
				canisterLevels = new ArrayList<>();
				for (CryoCanisterLevelDTO level : levels) {
					if (canister.getCanisterNumber() == level.getCanisterNumber()) {
						canisterLevels.add(level);
					}
				}
				canister.setLevels(canisterLevels);
			}
		}
		return canisters;
	}
}
