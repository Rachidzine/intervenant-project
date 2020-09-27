package com.stitec.Myproject.controller;

import java.util.List;

import org.springframework.scheduling.SchedulingAwareRunnable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("invervenantId") int theId , Model theModel){
		
		Intervenant theIntervenant = intervenantService.findById();
		theModel.addAttribute("intervenant", theIntervenant);
		
		return "intervenants/intervenant-form";
	}
	
	
	
	//---------------------------------------
	
	@PostMapping("/save")
	public String saveIntervenant(@ModelAttribute("intervenant") Intervenant theIntervenant) {
		intervenantService.save(theIntervenant);
		
		return "redirect:/intervenants/list";
	}
}
