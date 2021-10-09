package com.skilldistillery.printtracker.services;

import java.util.List;

import com.skilldistillery.printtracker.entities.Print;

public interface PrintService {

	List<Print> getAllPrints();
	Print findById(int id);
	void deleteById(int id);
	Print editPrint(int id, Print newPrint);
}
