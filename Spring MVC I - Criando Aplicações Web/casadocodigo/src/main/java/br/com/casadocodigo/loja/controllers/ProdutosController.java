package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
// TODOS OS MÉTODOS DA CLASSE IRÃO PEGAR OS A PÁGINA /PRODUTOS
@RequestMapping("produtos")
public class ProdutosController {

	// INJETA O PRODUTO DAO
	@Autowired
	private ProdutoDao produtoDao;

	@RequestMapping("/form")
	public ModelAndView form() {
		// MANDAR ATRIBUTOS DO MODEL PARA A VIEW
		// RECEBE COMO PARÂMETRO A PÁGINA QUE RECEBERÁ OS DADOS
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		// ADICIONA OS OBJETOS DO MODEL PARA O VIEW
		// PASSA OS PARÂMETROS NECESSÁRIOS DO MODEL PARA A VIEW
		modelAndView.addObject("tipos", TipoPreco.values());

		// RETORNA OS DADOS
		return modelAndView;
	}

	// FAZ O PROCESSO DE BINDING
	// PEGA OS PARÂMETROS COM O MESMO NOME QUE O FORM.JSP ATRAVÉS DOS PARÂMETROS DO
	// MÉTODO
	// SE VOCÊ PEGAR UMA CLASSE O SPRING IRÁ OLHAR OS ATRIBUTOS DA CLASSE PARA VER
	// SE TEM OS PARÂMETROS
	// GRAVAR USA O POST, ISSO É NECESSÁRIO PARA DIFERENCIAR O MÉTODO LISTAR, PARA O
	// SPRING SABER QUAL PEGAR
	// @RequestMapping(value="/produtos", method=RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {
		System.out.println(produto);
		produtoDao.gravar(produto);

		// VARIÁVEL FICA DISPONÍVEL DENTRO DA LISTA PARA PEGAR NA JSP
		// MANTÉM DE UM REQUEST ATÉ O PRÓXIMO PARA UTILIZAR A VARIÁVEL
		// FLASH É UMA VARIÁVEL RÁPIDA
		// O Flash Scoped é um escopo rápido. Os objetos que adicionamos nele através do
		// método addFlashAttribute ficam vivos de um request para outro, enquanto o
		// navegador executa um redirect (usando o código de status 302).
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");

		// REDIRECT: FAZ REDIRECIONAR O USUÁRIO
		return new ModelAndView("redirect:produtos");
	}

	// PRODUTOS UTILIZANDO O MÉTODO GET
	// @RequestMapping(value="/produtos", method=RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		// PRIMEIRO PARÂMETRO É O alias QUE É O NOME PARA PEGAR NO JSP
		modelAndView.addObject("produtos", produtos);
		return modelAndView;

	}

}
