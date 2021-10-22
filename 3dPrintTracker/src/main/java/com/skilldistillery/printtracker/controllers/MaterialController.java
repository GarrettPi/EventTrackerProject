package com.skilldistillery.printtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.printtracker.services.MaterialService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200"})
public class MaterialController {

	@Autowired
	MaterialService materialSvc;
}
