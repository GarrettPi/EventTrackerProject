package com.skilldistillery.printtracker.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Print findById(int id) {
		try {
			Optional<Print> opt = printRepo.findById(id);
			if (opt.get() != null) {
				Print print = opt.get();
				return print;
			}
			return null;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		Optional<Print> opt = printRepo.findById(id);
		if (opt.get() != null) {
			printRepo.deleteById(id);
		}
	}

	@Override
	public Print editPrint(int id, Print newPrint) {
		Print print = printRepo.getById(id);
		if (print == null) {
			return null;
		} else {
			print.setDuration(newPrint.getDuration());
			print.setMaterial(newPrint.getMaterial());
			print.setMaterialConsumed(newPrint.getMaterialConsumed());
			print.setName(newPrint.getName());
			print.setPhotoUrl(newPrint.getPhotoUrl());
			print.setPrinter(newPrint.getPrinter());
			print.setSource(newPrint.getSource());
			print = printRepo.saveAndFlush(print);
			return print;
		}
	}

	@Override
	public Print createPrint(Print print) {
		print = printRepo.saveAndFlush(print);
		return print;
	}

}
