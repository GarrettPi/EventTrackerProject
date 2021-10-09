package com.skilldistillery.printtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.printtracker.entities.Printer;

@Repository
public interface PrinterRepository extends JpaRepository<Printer, Integer> {

}
