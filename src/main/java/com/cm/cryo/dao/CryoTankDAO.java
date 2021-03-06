
package com.cm.cryo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoPatientDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.helpers.CryoTankResultSetMapper;
import com.cm.cryo.idao.ICryoTankDAO;
import com.cm.cryo.util.CryoConstants;

@Repository
public class CryoTankDAO extends CryoBaseDAO implements ICryoTankDAO {
	public CryoTankDAO(DataSource dataSource,String emptyBean) {
		super(dataSource,emptyBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CryoTankDTO> getTanks() {
		setSql(CryoConstants.CRYO_GET_ALL_TANKS);
		clearDeclaredParameters();
		declareResultSetParametersForTankDetails();
		return (List<CryoTankDTO>) this.executeWithOutParameters().get(CryoConstants.CRYO_TANKS_RESULTSET);
	}

	@Override
	public CryoTankDropDownAttributeDTO getDropDownValues() {
		setSql(CryoConstants.CRYO_GET_DROP_DOWN_VALUES);
		clearDeclaredParameters();
		declareResultSetParametersForDropDownAttributes();
		return CryoTankResultSetMapper.convertMapResponseToDropDownAttributeDTO(this.executeWithOutParameters());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CryoPatientDTO> getPatients() {
		setSql(CryoConstants.CRYO_GET_ALL_PATIENTS);
		clearDeclaredParameters();
		declareResultSetParametersForPatientDetails();
		return (List<CryoPatientDTO>) this.executeWithOutParameters().get(CryoConstants.CRYO_PATIENT_RESULTSET);
	}

	private void declareResultSetParametersForTankDetails() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TANKS_RESULTSET,
				new CryoTankResultSetMapper.CryoTankDetailsMapper()));
	}

	private void declareResultSetParametersForPatientDetails() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_PATIENT_RESULTSET,
				new CryoTankResultSetMapper.CryoPatientDetailMapper()));
	}

	private void declareResultSetParametersForDropDownAttributes() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_ROOMS_RESULTSET,
				new CryoTankResultSetMapper.CryoRoomTypeMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TYPES_RESULTSET,
				new CryoTankResultSetMapper.CryoTankTypeMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_LABELS_RESULTSET,
				new CryoTankResultSetMapper.CryoLabelTypeMapper()));
	}
	
	private void clearDeclaredParameters() {
		// clearing off declared parameters
		// so that when run with multiple stored procedures,
		// stored procedure parameters will not get overlapped.
		getDeclaredParameters().clear();
	}

}
