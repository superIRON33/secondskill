package com.zbw.secondskill.dao;


import com.zbw.secondskill.dataobject.SequenceDO;

public interface SequenceDOMapper {

    int deleteByPrimaryKey(String name);


    int insert(SequenceDO record);


    int insertSelective(SequenceDO record);


    SequenceDO selectByPrimaryKey(String name);

    SequenceDO getSequenceByName(String name);

    int updateByPrimaryKeySelective(SequenceDO record);

    int updateByPrimaryKey(SequenceDO record);
}