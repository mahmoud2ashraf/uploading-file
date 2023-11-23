package com.mahmoud.task1.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mahmoud.task1.dto.Product;
import com.mahmoud.task1.service.BaseService;

@RestController
public class baseController {
	
	private BaseService baseService;
	
	@Autowired
	public baseController(BaseService baseService) {
		// TODO Auto-generated constructor stub
		this.baseService = baseService;
	}
	
	@PostMapping("/upload")
	public List<Product> Uplod(@RequestParam MultipartFile file , @RequestParam Integer productId) throws Exception  {
		
		return baseService.upload(file, productId);
	}

}
