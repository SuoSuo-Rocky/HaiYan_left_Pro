package org.lanqiao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Studentclass;
import org.lanqiao.entity.StudentclassExample;

public interface StudentclassMapper {
    long countByExample(StudentclassExample example);

    int deleteByExample(StudentclassExample example);

    int deleteByPrimaryKey(Integer classid);

    int insert(Studentclass record);

    int insertSelective(Studentclass record);

    List<Studentclass> selectByExample(StudentclassExample example);

    Studentclass selectByPrimaryKey(Integer classid);

    int updateByExampleSelective(@Param("record") Studentclass record, @Param("example") StudentclassExample example);

    int updateByExample(@Param("record") Studentclass record, @Param("example") StudentclassExample example);

    int updateByPrimaryKeySelective(Studentclass record);

    int updateByPrimaryKey(Studentclass record);
}