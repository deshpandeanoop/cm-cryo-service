
package com.cm.cryo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.dto.CryoTankFilterDTO;
import com.cm.cryo.helpers.CryoTankResultSetMapper;
import com.cm.cryo.idao.ICryoTankDAO;
import com.cm.cryo.util.CryoConstants;

@Repository
public class CryoTankDAO extends CryoBaseDAO implements ICryoTankDAO {
	public CryoTankDAO(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<CryoTankDTO> getTanks(CryoTankFilterDTO filter) {
		return null;
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

	private void declareResultSetParametersForTankDetails() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TANKS_RESULTSET,
				new CryoTankResultSetMapper.CryoTankDetailsMapper()));
	}

	private void declareResultSetParametersForDropDownAttributes() {
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_ROOMS_RESULTSET,
				new CryoTankResultSetMapper.CryoRoomTypeMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TYPES_RESULTSET,
				new CryoTankResultSetMapper.CryoTankTypeMapper()));
		declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_LABELS_RESULTSET,
				new CryoTankResultSetMapper.CryoLabelTypeMapper()));
	}
	/* Will un comment this when I implement filtering tank functionality */
	// private Map<String, Object>
	// constructInputParametersForTankFilter(CryoTankFilterDTO filter) {
	// Map<String, Object> inputParameters = new HashMap<>();
	// inputParameters.put(CryoConstants.CRYO_ROOM_ID, filter.getRoomTypeId());
	// inputParameters.put(CryoConstants.CRYO_TYPE_ID, filter.getTankTypeId());
	// inputParameters.put(CryoConstants.CRYO_LABEL_ID, filter.getLabelTypeId());
	// return inputParameters;
	// }

	private void clearDeclaredParameters() {
		// clearing off declared parameters
		// so that when run with multiple stored procedures,
		// stored procedure parameters will not get overlapped.
		getDeclaredParameters().clear();
	}

}
