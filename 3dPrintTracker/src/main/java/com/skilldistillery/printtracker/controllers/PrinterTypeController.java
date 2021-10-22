package com.skilldistillery.printtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.printtracker.entities.PrinterType;
import com.skilldistillery.printtracker.services.PrinterTypeService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200"})
public class PrinterTypeController {

	@Autowired
	PrinterTypeService printerTypeSvc;

	@GetMapping("types")
	public List<PrinterType> index(){ 
		return printerTypeSvc.getAllPrinterTypes();
	}
}
