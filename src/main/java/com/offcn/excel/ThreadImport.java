package com.offcn.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.offcn.po.Mobile;
import com.offcn.service.MobileService;

public class ThreadImport extends Thread {
	private MobileService service;
	private Sheet sheet;
	public ThreadImport(MobileService service,Sheet sheet){
		this.service=service;
		this.sheet=sheet;
	}

	@Override
	public void run(){
		List<Mobile> list=new ArrayList<Mobile>();
		//遍历工作表
		//获取工作表里面的行数
		int rownum = sheet.getPhysicalNumberOfRows();
		for(int i=1;i<rownum;i++){
			Mobile m=new Mobile();
			Row row = sheet.getRow(i);
			m.setNumber(row.getCell(1).getStringCellValue());
			m.setArea(row.getCell(2).getStringCellValue());
			m.setMobiletype(row.getCell(3).getStringCellValue());
			m.setAreacode(row.getCell(4).getStringCellValue());
			m.setPostcode(row.getCell(5).getStringCellValue());
			
			list.add(m);
			
			//判断list的集合数量等于1000执行保存
			if(list.size()==1000){
				service.saves(list);
				System.out.println("保存1000条记录");
				//清空list
				list.clear();
			}
		}
		
		//最后剩余list不足1000
		if(list.size()>0){
			service.saves(list);
			//清空list
			list.clear();
		}
	}
}
