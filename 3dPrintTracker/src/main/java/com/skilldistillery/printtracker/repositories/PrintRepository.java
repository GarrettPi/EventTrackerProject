package com.skilldistillery.printtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.printtracker.entities.Print;

@Repository
public interface PrintRepository extends JpaRepository<Print, Integer> {
	
	List<Print> findByPrinterId(int id);

}
