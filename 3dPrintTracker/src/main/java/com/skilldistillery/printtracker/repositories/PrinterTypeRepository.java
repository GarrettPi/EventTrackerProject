package com.skilldistillery.printtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.printtracker.entities.PrinterType;

@Repository
public interface PrinterTypeRepository extends JpaRepository<PrinterType, Integer> {

}
