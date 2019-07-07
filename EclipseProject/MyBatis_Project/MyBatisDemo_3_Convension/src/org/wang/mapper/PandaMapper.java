package org.wang.mapper;

import java.util.List;

import org.wang.entity.Grade;
import org.wang.entity.Panda;

public interface PandaMapper {
	
	Panda queryPandaByStuIdWithSQLTag(Panda panda);
	
	List<Panda> queryPandasWithNosInGrade(Grade grade);
	
	
	List<Panda> queryPandasWithArray(int[] stuNos);
	
	
	List<Panda> queryPandasWithList(List<Integer> stuNos);
	
	List<Panda> queryPandasWithObject_array(Panda[] stuNos);
	


}
