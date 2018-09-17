package com.cm.cryo.helpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cm.cryo.dto.CryoCanisterDTO;
import com.cm.cryo.dto.CryoCanisterLevelDTO;
import com.cm.cryo.dto.CryoClinicianDTO;
import com.cm.cryo.dto.CryoGobletDTO;
import com.cm.cryo.dto.CryoPatientDTO;
import com.cm.cryo.dto.CryoTankDTO;

public class CryoTankDetailResultSetMapper {
	private CryoTankDetailResultSetMapper() {
		return;
	}

	public static class CryoTankDetailMapper implements RowMapper<CryoTankDTO> {

		@Override
		public CryoTankDTO mapRow(ResultSet rs, int rowCount) throws SQLException {
			CryoTankDTO tank = new CryoTankDTO();
			tank.setId(rs.getInt("tank_id"));
			tank.setName(rs.getString("name"));
			tank.setRoom(rs.getString("roomType"));
			tank.setType(rs.getString("tankType"));
			tank.setLabel(rs.getString("labelType"));
			tank.setManufacturedDate(rs.getDate("mfd_date"));
			return tank;
		}

	}

	public static class CryoClinicianMapper implements RowMapper<CryoClinicianDTO> {

		@Override
		public CryoClinicianDTO mapRow(ResultSet rs, int rowCount) throws SQLException {
			CryoClinicianDTO clinician = new CryoClinicianDTO();
			clinician.setId(rs.getInt("clin_id"));
			clinician.setName(rs.getString("clin_name"));
			return clinician;
		}

	}

	public static class CryoCanisterMapper implements RowMapper<CryoCanisterDTO> {

		@Override
		public CryoCanisterDTO mapRow(ResultSet rs, int rowCount) throws SQLException {
			CryoCanisterDTO canister = new CryoCanisterDTO();
			canister.setTankId(rs.getInt("tank_id"));
			canister.setCanisterNumber(rs.getInt("canister_no"));
			canister.setName("Can " + canister.getCanisterNumber());
			return canister;
		}

	}

	public static class CryoLevelMapper implements RowMapper<CryoCanisterLevelDTO> {

		@Override
		public CryoCanisterLevelDTO mapRow(ResultSet rs, int rowCount) throws SQLException {
			CryoCanisterLevelDTO level = new CryoCanisterLevelDTO();
			level.setCanisterNumber(rs.getInt("canister_no"));
			level.setLevelNumber(rs.getInt("cane_no"));
			level.setStrawCount(rs.getInt("straw_count"));
			level.setVialCount(rs.getInt("vial_count"));
			level.setEmbryoCount(rs.getInt("embryo_count"));
			level.setGoblet(createCryoGoblet(rs));
			level.setPatient(createPatientAssociatedWithLevel(rs));
			return level;
		}

	}

	private static CryoGobletDTO createCryoGoblet(ResultSet rs) throws SQLException {
		CryoGobletDTO goblet = new CryoGobletDTO();
		goblet.setColId(rs.getInt("c_goblet_col_id"));
		goblet.setColor(rs.getString("goblet_color"));
		return goblet;
	}

	private static CryoPatientDTO createPatientAssociatedWithLevel(ResultSet rs) throws SQLException {
		CryoPatientDTO patient = new CryoPatientDTO();
		patient.setRegistrationId(rs.getInt("reg_id"));
		patient.setName(rs.getString("pat_name"));
		patient.setHrn(rs.getString("hrn_num"));
		patient.setNric(rs.getInt("episode_num"));
		patient.setRemarks(rs.getString("remarks"));
		patient.setClinician(createClinician(rs));
		return patient;
	}

	private static CryoClinicianDTO createClinician(ResultSet rs) throws SQLException {
		CryoClinicianDTO clinician = new CryoClinicianDTO();
		clinician.setId(rs.getInt("clin_id"));
		clinician.setName(rs.getString("clin_name"));
		return clinician;
	}
}
