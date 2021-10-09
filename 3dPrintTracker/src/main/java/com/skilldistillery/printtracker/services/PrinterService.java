package com.skilldistillery.printtracker.services;

import java.util.List;

import com.skilldistillery.printtracker.entities.Printer;

public interface PrinterService {

	List<Printer> getAllPrinters();
	Printer	findById(int id);
	Printer createrPrinter(Printer printer);
	void deletePrinter(int id);
}
