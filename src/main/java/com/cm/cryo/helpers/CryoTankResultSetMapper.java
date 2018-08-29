package com.cm.cryo.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.cm.cryo.dto.CryoBaseDTO;
import com.cm.cryo.dto.CryoLabelTypeDTO;
import com.cm.cryo.dto.CryoRoomTypeDTO;
import com.cm.cryo.dto.CryoTankDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.dto.CryoTankTypeDTO;
import com.cm.cryo.util.CryoConstants;

public class CryoTankResultSetMapper {
	private CryoTankResultSetMapper() {
		return;
	}

	public static class CryoRoomTypeMapper implements RowMapper<CryoRoomTypeDTO> {
		@Override
		public CryoRoomTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return createCryoRoomTypeDTO(rs);
		}
	}

	public static class CryoTankTypeMapper implements RowMapper<CryoTankTypeDTO> {
		@Override
		public CryoTankTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return createCryoTankTypeTO(rs);
		}
	}

	public static class CryoLabelTypeMapper implements RowMapper<CryoLabelTypeDTO> {
		@Override
		public CryoLabelTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return createCryoLabelTypeDTO(rs);
		}
	}

	public static class CryoTankDetailsMapper implements RowMapper<CryoTankDTO> {
		@Override
		public CryoTankDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CryoTankDTO tank = new CryoTankDTO();
			tank.setId(rs.getInt("tank_id"));
			tank.setName(rs.getString("name"));
			tank.setDescription(rs.getString("description"));
			tank.setRoom(rs.getString("roomType"));
			tank.setType(rs.getString("tankType"));
			tank.setLabel(rs.getString("labelType"));
			tank.setCanisterCount(rs.getInt("canister_count"));
			tank.setLevelCount(rs.getInt("lvl_count"));
			tank.setManufacturedDate(rs.getDate("mfd_date"));
			tank.setOrderBy(rs.getInt("order_by"));
			tank.setDeleted(rs.getInt("deleted"));
			tank.setDeletedBy(rs.getString("deleted_by"));
			tank.setDeletedAt(rs.getDate("deleted_at"));
			tank.setCreatedAt(rs.getDate("created_at"));
			tank.setCreatedBy(rs.getString("created_by"));
			tank.setUpdatedBy(rs.getString("updated_by"));
			tank.setUpdatedAt(rs.getDate("updated_at"));
			return tank;
		}

	}

	@SuppressWarnings("unchecked")
	public static CryoTankDropDownAttributeDTO convertMapResponseToDropDownAttributeDTO(
			Map<String, Object> responseMap) {
		CryoTankDropDownAttributeDTO dropDownAttributes = new CryoTankDropDownAttributeDTO();
		dropDownAttributes.setRoomTypes((List<CryoRoomTypeDTO>) responseMap.get(CryoConstants.CRYO_ROOMS_RESULTSET));
		dropDownAttributes.setTankTypes((List<CryoTankTypeDTO>) responseMap.get(CryoConstants.CRYO_TYPES_RESULTSET));
		dropDownAttributes.setLabelTypes((List<CryoLabelTypeDTO>) responseMap.get(CryoConstants.CRYO_LABELS_RESULTSET));

		return dropDownAttributes;
	}

	private static CryoRoomTypeDTO createCryoRoomTypeDTO(ResultSet rs) throws SQLException {
		CryoBaseDTO baseDTO = createCryoBaseDTO(rs);
		CryoRoomTypeDTO cryoRoomType = new CryoRoomTypeDTO();
		cryoRoomType.setId(baseDTO.getId());
		cryoRoomType.setName(baseDTO.getName());
		cryoRoomType.setOrderBy(baseDTO.getOrderBy());
		return cryoRoomType;
	}

	private static CryoTankTypeDTO createCryoTankTypeTO(ResultSet rs) throws SQLException {
		CryoBaseDTO baseDTO = createCryoBaseDTO(rs);
		CryoTankTypeDTO cryoTankType = new CryoTankTypeDTO();
		cryoTankType.setId(baseDTO.getId());
		cryoTankType.setName(baseDTO.getName());
		cryoTankType.setOrderBy(baseDTO.getOrderBy());
		return cryoTankType;
	}

	private static CryoLabelTypeDTO createCryoLabelTypeDTO(ResultSet rs) throws SQLException {
		CryoBaseDTO baseDTO = createCryoBaseDTO(rs);
		CryoLabelTypeDTO cryoLabelType = new CryoLabelTypeDTO();
		cryoLabelType.setId(baseDTO.getId());
		cryoLabelType.setName(baseDTO.getName());
		cryoLabelType.setOrderBy(baseDTO.getOrderBy());
		return cryoLabelType;
	}

	private static CryoBaseDTO createCryoBaseDTO(ResultSet rs) throws SQLException {
		CryoBaseDTO cryoBaseDTO = new CryoBaseDTO();
		cryoBaseDTO.setId(rs.getInt(1));
		cryoBaseDTO.setName(rs.getString(2));
		cryoBaseDTO.setOrderBy(rs.getInt(3));
		return cryoBaseDTO;
	}
}
