package com.stitec.Myproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stitec.Myproject.dao.IntervenantRepository;
import com.stitec.Myproject.entity.Intervenant;

@Service
public class intervenantserviceImpl implements IntervenantService {
	
	private IntervenantRepository intervenantRepository;
	
	//Injection
	@Autowired
	public intervenantserviceImpl(IntervenantRepository theIntervenantRepository) {
		intervenantRepository = theIntervenantRepository;
	}

	
	//-----------------FINDALL-------------------------------------
	@Override
	public List<Intervenant> findAll() {
		
		return intervenantRepository.findAllByOrderByLastNameAsc();
	}

	//---------------SAVE---------------------------------
	@Override
	public void save(Intervenant intervenant) {
		intervenantRepository.save(intervenant);
		
	}


	@Override
	public Optional<Intervenant> findById(int theId) {
		
		return intervenantRepository.findById(theId);
	}


	@Override
	public void deleteById(int theId) {
		intervenantRepository.deleteById(theId);;
		
	}


	

	
	
	
	

}
