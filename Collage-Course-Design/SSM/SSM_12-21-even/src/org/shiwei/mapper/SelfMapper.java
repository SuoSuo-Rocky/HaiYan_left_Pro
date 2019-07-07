package org.shiwei.mapper;

import java.util.List;

import org.shiwei.entity.Self;

public interface SelfMapper {


	List<Self> queryAllSelf(int stuId);
	
	void deleteSelfByHost(Self self);
	
	Self querySelfByHost(Self self);
	
	void addSelfBook(Self self);
}
