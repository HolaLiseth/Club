package com.ClubFutbol.app.controladorweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ClubFutbol.app.variable.Entrenador;
import com.ClubFutbol.app.repository.EntrenadorRepositorio;
@Controller
public class ControladorWebEntrenador {
	

	@Autowired
	private EntrenadorRepositorio entrenadorRepositorio;
	
	@GetMapping("/verEntrenador.html")  
	public String listarEntrenador(Model model) {
		List <Entrenador> listaEntrenador =  entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "verEntrenador";
	}
	
	@GetMapping("/verEntrenador/formEntrenador")
	public String mostrarFormulario (Model model) {
		model.addAttribute("entrenador", new Entrenador());
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador";
	}
	
	@PostMapping("/guardarEntrenador")
	public String guardarEntrenador (Entrenador entrenador) {
		entrenadorRepositorio.save(entrenador);
		return "redirect:/verEntrenador.html";
	}
	
	@GetMapping("/entrenador/editar/{id}")
	public String modificarEntrenador (@PathVariable("id") Integer id, Model model) {
		Entrenador entrenador = entrenadorRepositorio.findById(id).get();
		model.addAttribute("entrenador", entrenador);
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		

		return "formEntrenador";
	}
	
	@GetMapping("/entrenador/eliminar/{id}")
	public String eliminarEntrenador(@PathVariable("id") Integer id, Model model) {
		entrenadorRepositorio.deleteById(id);
		return "redirect:/verEntrenador.html";
	}

}


