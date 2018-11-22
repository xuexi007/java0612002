package com.offcn.dao;

import java.util.List;

import com.offcn.po.Mobile;

public interface MobileDao {

	//批量保存
	public void saves(List<Mobile> list);
	
	//查询方法
	public Mobile search(String number);
}
