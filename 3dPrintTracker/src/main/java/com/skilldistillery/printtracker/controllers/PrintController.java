package com.skilldistillery.printtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.printtracker.entities.Print;
import com.skilldistillery.printtracker.services.PrintService;

@RestController
@RequestMapping("api")
public class PrintController {

	@Autowired
	PrintService printSvc;
	
	@GetMapping("prints")
	public List<Print> printIndex(){
		return printSvc.getAllPrints();
	}
}
