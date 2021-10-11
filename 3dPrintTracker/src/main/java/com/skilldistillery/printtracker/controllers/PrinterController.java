package com.skilldistillery.printtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.printtracker.entities.Printer;
import com.skilldistillery.printtracker.services.PrinterService;

@RestController
@RequestMapping("api")
public class PrinterController {

	@Autowired
	PrinterService printerSvc;

	@GetMapping("printers")
	public List<Printer> printerIndex() {
		return printerSvc.getAllPrinters();
	}

	@GetMapping("printers/{id}")
	public Printer getPrinter(@PathVariable Integer id, HttpServletResponse res) {
		Printer printer = printerSvc.findById(id);
		if (printer != null) {
			return printer;
		} else {
			res.setStatus(404);
			return null;
		}
	}

	@PostMapping("printers")
	public Printer createPrinter(@RequestBody Printer printer) {
		return printerSvc.createrPrinter(printer);
	}

	@DeleteMapping("printers/{id}")
	public void deletePrinter(@PathVariable Integer id) {
		printerSvc.deletePrinter(id);
	}

	@PutMapping("printers/{id}")
	public Printer editPrinter(@PathVariable Integer id, @RequestBody Printer printer, HttpServletResponse res) {
		Printer newPrinter = printerSvc.editPrinter(id, printer);
		if (newPrinter != null) {
			return newPrinter;
		} else {
			res.setStatus(404);
			return null;
		}

	}
}
