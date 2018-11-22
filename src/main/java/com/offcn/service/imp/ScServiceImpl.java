package com.offcn.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.ScDao;
import com.offcn.po.Sc;
import com.offcn.service.ScService;
@Service
public class ScServiceImpl implements ScService {

	@Autowired
	ScDao dao;
	@Override
	public void save(Sc sc) {
		dao.save(sc);

	}

	@Override
	public List<Sc> getScByBeginEndTime(String begindate, String enddate) {
		
		return dao.getScByBeginEndTime(begindate, enddate);
	}

}
