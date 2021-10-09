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
			if(opt.get() != null) {
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
		if(opt.get() != null) {
			printRepo.deleteById(id);
		}
	}

}
