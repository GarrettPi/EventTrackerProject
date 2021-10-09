package com.skilldistillery.printtracker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.printtracker.entities.Source;
import com.skilldistillery.printtracker.repositories.SourceRepository;

@Service
@Transactional
public class SourceServiceImpl implements SourceService {
	
	@Autowired
	private SourceRepository sourceRepo;

	@Override
	public List<Source> getAllSources() {
		return sourceRepo.findAll();
	}

}
