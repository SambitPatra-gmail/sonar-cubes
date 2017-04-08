package com.sonar.cubes.utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData {
	
		public static String fromExcel(String filename,String sname,int rindex,int cindex)
	 {
		String data = null;
		try
		{
		File f = new File("./data/"+filename+".xlsx"); 
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st =wb.getSheet(sname);
		Row r= st.getRow(rindex);
		Cell c = r.getCell(cindex);
		data = c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	 } 
		
		public static String fromProperties(String filename,String key)
		{
			String value = null;
			try
			{
				File f = new File ("./config/"+filename+".properties");
				FileInputStream fis = new FileInputStream(f);
				Properties prop = new Properties();
				prop.load(fis);
				value=prop.getProperty(key);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return value;
		}
		
		
		
		
}

