package com.ClubFutbol.app.controladorweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ClubFutbol.app.repository.CompeticionRepositorio;
import com.ClubFutbol.app.variable.Competicion;

@Controller

public class ControladorWebCompeticion {
	

	@Autowired
	private CompeticionRepositorio competicionRepositorio;
	
	@GetMapping("/verCompeticion")  
	public String listarCompeticion(Model model) {
		List <Competicion> listaCompeticion =  competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "verCompeticion";
	}
	
	@GetMapping("/formCompeticion.html")
	public String mostrarFormulario (Model model) {
		model.addAttribute("competicion", new Competicion());
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formCompeticion";
	}
	
	@PostMapping("/guardarCompeticion")
	public String guardarCompeticion (Competicion competicion) {
		competicionRepositorio.save(competicion);
		return "redirect:/verCompeticion";
	}
	
	@GetMapping("/competicion/editar/{id}")
	public String modificarCompeticion (@PathVariable("id") Integer id, Model model) {
		Competicion competicion = competicionRepositorio.findById(id).get();
		model.addAttribute("competicion", competicion);
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		

		return "formCompeticion";
	}
	
	@GetMapping("/competicion/eliminar/{id}")
	public String eliminarCompeticion(@PathVariable("id") Integer id, Model model) {
		competicionRepositorio.deleteById(id);
		return "redirect:/verCompeticion";
	}

}
