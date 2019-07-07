package org.shiwei.dao.Impl;

import org.shiwei.dao.MessageDao;
import org.shiwei.mapper.OneMapper;
import org.shiwei.mapper.TwoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDao_Impl implements MessageDao {

	@Autowired
	OneMapper oneMapper;
	
	@Autowired
	TwoMapper twoMapper;

	public OneMapper getOneMapper() {
		return oneMapper;
	}

	public void setOneMapper(OneMapper oneMapper) {
		this.oneMapper = oneMapper;
	}

	public TwoMapper getTwoMapper() {
		return twoMapper;
	}

	public void setTwoMapper(TwoMapper twoMapper) {
		this.twoMapper = twoMapper;
	}
	
	
	
	
}
