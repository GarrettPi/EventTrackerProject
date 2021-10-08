package com.skilldistillery.printtracker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.printtracker.entities.Print;
import com.skilldistillery.printtracker.repositories.PrintRepository;

@Service
@Transactional
public class PrintServiceImpl implements PrintService {
	
	@Autowired
	private PrintRepository printRepo;

	@Override
	public List<Print> getAllPrints() {
		return printRepo.findAll();
	}

}
