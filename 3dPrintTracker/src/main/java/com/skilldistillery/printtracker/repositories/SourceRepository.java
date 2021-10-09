package com.skilldistillery.printtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.printtracker.entities.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, Integer> {

}
