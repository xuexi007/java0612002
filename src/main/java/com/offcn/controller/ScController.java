package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.po.Sc;
import com.offcn.service.ScService;

@Controller
public class ScController {

	@Autowired
	ScService service;
	@RequestMapping("/getsc")
	@ResponseBody
	public List<Sc> getScByBeginEndTime(String begindate,String enddate){
		return service.getScByBeginEndTime(begindate, enddate);
	}
}
