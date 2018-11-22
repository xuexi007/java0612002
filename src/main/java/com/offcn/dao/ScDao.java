package com.offcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.po.Sc;

public interface ScDao {
public void save(Sc sc);
//按照日期范围来获取制定数据 开始时间、结束时间
public List<Sc> getScByBeginEndTime(@Param("begindate")String begindate,@Param("enddate")String enddate);
}
