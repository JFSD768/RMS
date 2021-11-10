package com.gmmr.rms.dao;

import com.gmmr.rms.model.RMSResponseModel;
import com.gmmr.rms.model.Roommate;
import com.gmmr.rms.util.RMSException;

public interface RoommateDAO {

	public RMSResponseModel addRoommate(Roommate rmt) throws RMSException;

	public RMSResponseModel editRoommate(Roommate rmt) throws RMSException;

	public RMSResponseModel deleteRoommate(int rmtNo) throws RMSException;

	public RMSResponseModel searchRoommate(int rmtNo) throws RMSException;
	
	public RMSResponseModel getAllRoommates() throws RMSException;

}
