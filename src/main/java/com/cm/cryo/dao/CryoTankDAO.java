package com.cm.cryo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.helpers.CryoTankResultSetMapper;
import com.cm.cryo.idao.ICryoTankDAO;
import com.cm.cryo.util.CryoConstants;

@Repository
public class CryoTankDAO extends CryoBaseDAO implements ICryoTankDAO {
	public CryoTankDAO(DataSource dataSource) {
		super(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CryoTankDTO> getTanks() {
		setSql(CryoConstants.CRYO_GET_TANKS);
		getDeclaredParameters().clear();
		declareParametersForTankDetails();
		return (List<CryoTankDTO>) this.executeWithOutParameters().get(CryoConstants.CRYO_TANKS_RESULTSET);
	}

	private void declareParametersForTankDetails() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TANKS_RESULTSET,
				new CryoTankResultSetMapper.CryoTankDetailsMapper()));
	}

	@Override
	public CryoTankDropDownAttributeDTO getDropDownValues() {
		setSql(CryoConstants.CRYO_GET_DROP_DOWN_VALUES);
		getDeclaredParameters().clear();
		declareParametersForDropDownAttributes();
		return CryoTankResultSetMapper.convertMapResponseToDropDownAttributeDTO(this.executeWithOutParameters());
	}

	@SuppressWarnings("rawtypes")
	private void declareParametersForDropDownAttributes() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_ROOMS_RESULTSET,
				new CryoTankResultSetMapper.DropDownAttributeMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TYPES_RESULTSET,
				new CryoTankResultSetMapper.DropDownAttributeMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_LABELS_RESULTSET,
				new CryoTankResultSetMapper.DropDownAttributeMapper()));
	}
}
