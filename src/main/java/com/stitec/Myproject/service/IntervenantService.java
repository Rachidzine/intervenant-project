package com.stitec.Myproject.service;

import java.util.List;

import com.stitec.Myproject.entity.Intervenant;

public interface IntervenantService {
	
	public List<Intervenant> findAll();
	public Intervenant findById();
	public void save(Intervenant intervenant);

}
