package com.sonar.cubes.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.Properties;

public class SetData {
	public static void  toExcel(String filename,String sname, int rindex,int cindex,String data) {
		
		try {
			File f = new File ("./data/"+filename+".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sname);
			Row r = st.createRow(rindex);
			Cell c = r.createCell(cindex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	
	public static void toProperties(String filename,String key,String value,String commitmsg)
	{

		try {
			File f  = new File ("./config/"+filename+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, commitmsg);
	
			} 
		catch (Exception e)
			{
			e.printStackTrace();
			}

	}
	

}
