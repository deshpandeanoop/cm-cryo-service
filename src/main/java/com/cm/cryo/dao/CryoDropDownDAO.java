package com.cm.cryo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.helpers.CryoTankResultSetMapper;
import com.cm.cryo.idao.ICryoDropDownDAO;
import com.cm.cryo.util.CryoConstants;

@Repository
public class CryoDropDownDAO extends CryoBaseDAO implements ICryoDropDownDAO {

	public CryoDropDownDAO(DataSource dataSource) {
		super(dataSource, CryoConstants.CRYO_GET_DROP_DOWN_VALUES);
		declareParametersForDropDownAttributes();
	}

	@Override
	public CryoTankDropDownAttributeDTO getDropDownValues() {
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
