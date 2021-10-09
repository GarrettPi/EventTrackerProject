package com.skilldistillery.printtracker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.printtracker.entities.Material;
import com.skilldistillery.printtracker.repositories.MaterialRepository;

@Service
@Transactional
public class MateriaServiceImpl implements MaterialService {
	
	@Autowired
	private MaterialRepository materialRepo;

	@Override
	public List<Material> getAllMaterials() {
		return materialRepo.findAll();
	}

}
