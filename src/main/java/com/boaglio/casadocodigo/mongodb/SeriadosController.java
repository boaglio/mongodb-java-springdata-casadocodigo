package com.boaglio.casadocodigo.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeriadosController {

	@Autowired
	private SeriadosRepository repository;

	@GetMapping({"/", "home"})
	public String index(ModelMap model) {

		List<Seriado> seriados = repository.findAll();
		model.addAttribute("seriados",seriados);
		return "home";

	}

	@GetMapping("/detalhe")
	public String detalhe(@RequestParam("id") String id,ModelMap model) {

		Seriado seriado = repository.findById(id);
		model.addAttribute("seriado",seriado);
		int totalDePersonagens = 0;
		if (seriado!=null && seriado.getPersonagens() != null) {
			totalDePersonagens = seriado.getPersonagens().size();
		}
		model.addAttribute("totalDePersonagens",totalDePersonagens);
		return "detalhe";

	}

	@GetMapping("/alterar")
	public String alterar(@ModelAttribute Seriado seriado,ModelMap model,HttpServletRequest request) {

		List<String> personagens = new ArrayList<String>();
		personagens.add(request.getParameter("personagem1"));
		personagens.add(request.getParameter("personagem2"));
		personagens.add(request.getParameter("personagem3"));
		personagens.add(request.getParameter("personagem4"));
		personagens.add(request.getParameter("personagem5"));
		personagens.add(request.getParameter("personagem6"));
		seriado.setPersonagens(personagens);

		repository.update(seriado);
		model.addAttribute("msg","update");

		return "detalhe";

	}
	
	@GetMapping("/remover")
	public String remover(@RequestParam("id") String id,ModelMap model) {

		repository.remove(id);
		model.addAttribute("msg","delete");

		return "detalhe";

	}

	@GetMapping("/novo")
	public String novo() {
		return "novo";
	}

	@PostMapping("/adicionar")
	public String adicionar(@ModelAttribute Seriado seriado,ModelMap model,HttpServletRequest request) {

		List<String> personagens = new ArrayList<String>();
		personagens.add(request.getParameter("personagem1"));
		personagens.add(request.getParameter("personagem2"));
		personagens.add(request.getParameter("personagem3"));
		personagens.add(request.getParameter("personagem4"));
		personagens.add(request.getParameter("personagem5"));
		personagens.add(request.getParameter("personagem6"));
		seriado.setPersonagens(personagens);
		
		Random ran = new Random();
		int randomID = ran.nextInt(1000) + 5;
		seriado.setId(String.valueOf(randomID));
		
		repository.insert(seriado);
		model.addAttribute("msg","add");

		return "novo";

	}

}
