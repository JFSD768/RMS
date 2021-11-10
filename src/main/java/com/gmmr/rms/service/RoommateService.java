package com.gmmr.rms.service;

import java.time.LocalDate;

import com.gmmr.rms.dao.RoommateDAO;
import com.gmmr.rms.daoimpl.InMemoryRoommateDAOImpl;
import com.gmmr.rms.model.RMSResponseModel;
import com.gmmr.rms.model.Roommate;
import com.gmmr.rms.util.RMSException;

public class RoommateService {
	
	private RoommateDAO rmtDao = new InMemoryRoommateDAOImpl();
	
	public RMSResponseModel addRoommate(Roommate rmt) throws RMSException {
		if(rmt.getDateOfJoining() == null || "".equals(rmt.getDateOfJoining())) {
			rmt.setDateOfJoining(LocalDate.now());
		}
		return rmtDao.addRoommate(rmt);
	}

	public RMSResponseModel searchRoommate(int no) throws RMSException {
		return rmtDao.searchRoommate(no);
	}
	
	public RMSResponseModel getAllRoommates() throws RMSException {
		return rmtDao.getAllRoommates();
	}
	
	public RMSResponseModel editRoommate(Roommate rmt) throws RMSException {
		return rmtDao.editRoommate(rmt);
	}
	
	public RMSResponseModel deleteRoommate(int rmtNo) throws RMSException {
		return rmtDao.deleteRoommate(rmtNo);
	}
}
