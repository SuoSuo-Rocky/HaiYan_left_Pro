package org.wang.mapper;

import java.util.List;

import org.wang.entity.Monkey;
import org.wang.entity.MonkeyBusiness;

public interface MonkeyMapper {
	
	MonkeyBusiness queryMonkeyByOO(int stuNo);
	
	Monkey queryMonkeyByNo_resultMap_OO(int stuNo);
	
	//   一对一 查询  使用延迟加载。
	List<Monkey> queryMonkeyByNo_resultMap_OO_lazy(int stuNo);

}
