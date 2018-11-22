package com.offcn.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.offcn.po.Mobile;

public interface MobileService {
	//批量保存
		public void saves(List<Mobile> list);
		
		//查询方法
		@GET
		@Path("/search/{number}")
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public Mobile search(@PathParam("number")String number);
}
