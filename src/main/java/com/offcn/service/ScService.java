package com.offcn.service;

import java.util.List;


import com.offcn.po.Sc;

public interface ScService {

	public void save(Sc sc);
	//按照日期范围来获取制定数据 开始时间、结束时间
	public List<Sc> getScByBeginEndTime(String begindate,String enddate);
}
