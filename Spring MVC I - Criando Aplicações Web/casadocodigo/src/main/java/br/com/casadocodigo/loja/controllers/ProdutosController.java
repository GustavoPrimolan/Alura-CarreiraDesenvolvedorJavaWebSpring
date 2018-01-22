package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
public class ProdutosController {
	
	//INJETA O PRODUTO DAO
	@Autowired
	private ProdutoDao produtoDao;
	
	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		//MANDAR ATRIBUTOS DO MODEL PARA A VIEW
		//RECEBE COMO PARÂMETRO A PÁGINA QUE RECEBERÁ OS DADOS
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		//ADICIONA OS OBJETOS DO MODEL PARA O VIEW
		//PASSA OS PARÂMETROS NECESSÁRIOS DO MODEL PARA A VIEW		
		modelAndView.addObject("tipos", TipoPreco.values());
		
		//RETORNA OS DADOS
		return modelAndView;
	}
	
	//FAZ O PROCESSO DE BINDING
	//PEGA OS PARÂMETROS COM O MESMO NOME QUE O FORM.JSP ATRAVÉS DOS PARÂMETROS DO MÉTODO
	//SE VOCÊ PEGAR UMA CLASSE O SPRING IRÁ OLHAR OS ATRIBUTOS DA CLASSE PARA VER SE TEM OS PARÂMETROS
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produtos/ok";
	}
	
}
