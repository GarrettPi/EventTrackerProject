package com.skilldistillery.printtracker.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.printtracker.entities.Print;
import com.skilldistillery.printtracker.entities.Printer;
import com.skilldistillery.printtracker.repositories.PrintRepository;
import com.skilldistillery.printtracker.repositories.PrinterRepository;

@Service
@Transactional
public class PrinterServiceImpl implements PrinterService {

	@Autowired
	private PrinterRepository printerRepo;
	@Autowired
	private PrintRepository printRepo;

	@Override
	public List<Printer> getAllPrinters() {
		return printerRepo.findAll();
	}

	@Override
	public Printer findById(int id) {
		Optional<Printer> opt = printerRepo.findById(id);
		if (opt.get() != null) {
			Printer printer = opt.get();
			return printer;
		} else {
			return null;
		}
	}

	@Override
	public Printer createrPrinter(Printer printer) {
		printer = printerRepo.saveAndFlush(printer);
		return printer;
	}

	@Override
	public void deletePrinter(int id) {
		Optional<Printer> opt = printerRepo.findById(id);
		Printer printer = null;
		if (opt.get() != null) {
			printer = opt.get();
		}
		List<Print> prints = printRepo.findByPrinterId(id);
		for (Print print : prints) {
			printRepo.delete(print);
		}
		printerRepo.delete(printer);

	}

}
