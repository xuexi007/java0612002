package com.offcn.excel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.service.MobileService;

public class ImportExcelMain {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	
	MobileService service = context.getBean(MobileService.class);
	
	//读取excel
	Workbook workbook = WorkbookFactory.create(new File("d:\\Mobile.xls"));
	
	for(int i=1;i<6;i++){
		Sheet sheet = workbook.getSheet("Sheet"+i);
		ThreadImport t1 = new ThreadImport(service, sheet);
		
		
		t1.start();
		
		
	}
}
}
