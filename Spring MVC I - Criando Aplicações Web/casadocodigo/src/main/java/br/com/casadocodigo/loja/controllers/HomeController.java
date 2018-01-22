package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//DEFINE A CLASSE COMO CONTROLLER
@Controller
public class HomeController {
	
	//MAPA DE REQUISIÇÃO, ONDE O USUÁRIO IRÁ
	@RequestMapping("/")
	public String index() {
		System.out.println("Entrando na Home da CDC");
		//NÃO PRECISA O .jsp POIS A CLASSE AppWebConfiguration JÁ CUIDA DISSO
		return "home";
	}
	
}
