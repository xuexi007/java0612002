package com.offcn.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.MobileDao;
import com.offcn.po.Mobile;
import com.offcn.service.MobileService;
@Service(value="mobileServiceImpl")
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileDao mdao;
	@Override
	public void saves(List<Mobile> list) {
		mdao.saves(list);

	}

	@Override
	public Mobile search(String number) {
		if(number.length()>7){
			number=number.substring(0, 7);
		}
		return mdao.search(number);
	}

}
