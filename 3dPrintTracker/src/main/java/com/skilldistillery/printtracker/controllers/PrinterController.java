package com.skilldistillery.printtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.printtracker.services.PrinterService;

@RestController
@RequestMapping("api")
public class PrinterController {
	
	@Autowired
	PrinterService printerSvc;

}
