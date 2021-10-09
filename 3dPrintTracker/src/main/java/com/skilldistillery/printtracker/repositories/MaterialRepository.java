package com.skilldistillery.printtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.printtracker.entities.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

}
