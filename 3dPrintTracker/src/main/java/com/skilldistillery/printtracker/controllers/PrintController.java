package com.skilldistillery.printtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.printtracker.entities.Print;
import com.skilldistillery.printtracker.services.PrintService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4200"})
public class PrintController {

	@Autowired
	PrintService printSvc;

	@GetMapping("prints")
	private List<Print> printIndex() {
		return printSvc.getAllPrints();
	}

	@GetMapping("prints/{id}")
	private Print getPrint(@PathVariable Integer id, HttpServletResponse res) {
		Print print = printSvc.findById(id);
		if (print != null) {
			return print;
		}
		res.setStatus(404);
		return null;
	}

	@DeleteMapping("prints/{id}")
	private boolean deletePrint(@PathVariable Integer id, HttpServletResponse res) {
		Print print = printSvc.findById(id);
		if (print != null) {
			printSvc.deleteById(id);
			return true;
		} else {
			res.setStatus(404);
			return false;
		}
	}

	@PutMapping("prints/{id}")
	private Print editPrint(@PathVariable Integer id, @RequestBody Print print, HttpServletResponse res) {
		Print newPrint = printSvc.editPrint(id, print);
		if (newPrint != null)
			return newPrint;
		else {
			res.setStatus(404);
			return null;
		}
	}

	@PostMapping("prints")
	private Print createPrint(@RequestBody Print print) {
		print = printSvc.createPrint(print);
		if (print != null)
			return print;
		else
			return null;

	}
}
