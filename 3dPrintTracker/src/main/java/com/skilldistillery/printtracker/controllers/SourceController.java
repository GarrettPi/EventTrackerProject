package com.skilldistillery.printtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.printtracker.entities.Material;
import com.skilldistillery.printtracker.entities.Source;
import com.skilldistillery.printtracker.services.SourceService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200"})
public class SourceController {

	@Autowired
	SourceService sourceSvc;
	
	@GetMapping("sources")
	public List<Source> sourceIndex(){
		return sourceSvc.getAllSources();
	}
}
