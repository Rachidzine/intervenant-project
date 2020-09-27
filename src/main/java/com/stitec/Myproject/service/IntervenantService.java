package com.stitec.Myproject.service;

import java.util.List;
import java.util.Optional;

import com.stitec.Myproject.entity.Intervenant;


public interface IntervenantService {
	
	public List<Intervenant> findAll();
	public Optional<Intervenant> findById(int theId);
	public void save(Intervenant intervenant);

}
