package com.mahmoud.task1.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mahmoud.task1.dto.Product;

@Service
public class BaseService {

	
	public List<Product> upload(MultipartFile file, Integer productId) throws IOException {
		
		List<Product> productList = new ArrayList<Product>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
        	Product tempProduct = new Product();
        	
        	XSSFRow row = worksheet.getRow(i);
        	tempProduct.setID((int) row.getCell(0).getNumericCellValue());
        	tempProduct.setName(row.getCell(1).getStringCellValue());
        	tempProduct.setDescription(row.getCell(2).getStringCellValue());
        	tempProduct.setLocation(row.getCell(3).getStringCellValue());
        	tempProduct.setPrice((int) row.getCell(4).getNumericCellValue());
        	tempProduct.setColor(row.getCell(5).getStringCellValue());
        	
        	productList.add(tempProduct);
        
            }
        	List<Product> result = new ArrayList<Product>();
        	for(int i=0 ; i<productList.size() ; i++)
        	{
        		if(productList.get(i).getID() == productId) {
        			result.add(productList.get(i));
        		}
        	}
        	return result;
        }
	
	

	

}
