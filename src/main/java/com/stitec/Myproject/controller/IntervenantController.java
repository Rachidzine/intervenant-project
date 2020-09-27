package com.stitec.Myproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stitec.Myproject.entity.Intervenant;
import com.stitec.Myproject.service.IntervenantService;

@Controller
@RequestMapping("/intervenants")
public class IntervenantController {
	
	private IntervenantService intervenantService;
	

	public IntervenantController(IntervenantService theIntervenantService) {
		intervenantService = theIntervenantService;
	}

	
	//----------------------------------------------------------------------------------
	@RequestMapping("/list")
	public String listIntervenants(Model theModel) {
		List<Intervenant> Intervenants = intervenantService.findAll();
		theModel.addAttribute("intervenants", Intervenants);
		return "intervenants/list-intervenants";
	}

	
	//-----------------------------------------------------------------------------------
	@GetMapping("/showForForAdd")
	public String  showFormForAdd(Model theModel) {
		
		//creation du l'attribute model pour la liason de donnee
		Intervenant theIntervenant = new Intervenant();
		
		theModel.addAttribute("intervenant", theIntervenant);
		
		return "intervenants/intervenant-form";
	}
}
