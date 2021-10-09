package com.skilldistillery.printtracker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.printtracker.entities.PrinterType;
import com.skilldistillery.printtracker.repositories.PrinterTypeRepository;

@Service
@Transactional
public class PrinterTypeServiceImpl implements PrinterTypeService {
	
	@Autowired
	private PrinterTypeRepository printerTypeRepo;

	@Override
	public List<PrinterType> getAllPrinterTypes() {
		return printerTypeRepo.findAll();
	}

}
