package com.stitec.Myproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stitec.Myproject.entity.Intervenant;


public interface IntervenantRepository extends JpaRepository<Intervenant, Integer> {

	
	public List<Intervenant> findAllByOrderByLastNameAsc();
}
