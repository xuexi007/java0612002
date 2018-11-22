package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.po.Mobile;
import com.offcn.service.MobileService;

@Controller
public class MobileController {

	@Autowired
	MobileService service;
	
	@RequestMapping("/search")
	public String search(String number,Model model){
		Mobile m=null;
		m=service.search(number);
		
		if(m!=null){
			String info=number+":属于-->"+m.getArea()+" "+m.getMobiletype();
			
			model.addAttribute("info", info);
		}else{
			model.addAttribute("info", number+":号码在号段库暂时不存在");
			
		}
		
		return "result";
		
	}
}
