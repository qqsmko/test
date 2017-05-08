package com.jmr.IDao;

import com.jmr.model.t_student;
import java.util.List;

public interface t_studentMapper {
    int deleteByPrimaryKey(Integer studentid);

    int insert(t_student record);

    int insertSelective(t_student record);

    t_student selectByPrimaryKey(Integer studentid);
    
    List<t_student> selectAll();

    int updateByPrimaryKeySelective(t_student record);

    int updateByPrimaryKey(t_student record);
}