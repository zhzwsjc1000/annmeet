package com.cn.annmeet.mapper;

import com.cn.annmeet.domain.CustInfo;

public interface CustInfoMapper {
    int deleteByPrimaryKey(String custId);

    int insert(CustInfo record);

    int insertSelective(CustInfo record);

    CustInfo selectByPrimaryKey(String custId);

    int updateByPrimaryKeySelective(CustInfo record);

    int updateByPrimaryKey(CustInfo record);
}