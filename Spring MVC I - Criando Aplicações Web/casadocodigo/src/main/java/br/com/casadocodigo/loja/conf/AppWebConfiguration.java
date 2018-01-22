package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProdutoDao;

//HABILITA O WEB MVC DO SPRING
@EnableWebMvc
// SPRING IRÁ SCANEAR PELOS COMPONENTES DELE A CLASSE
// O PARÂMETRO BASE PACKAGE CLASSES, É POSSÍVEL INSERIR AS CLASSES
// JÁ O PARÂMETRO BASEPACKAGES É NECESSÁRIO INSERIR A STRING COM O NOME
// DOS PACOTES, POR CONTA DISSO SE MUDAR ALGUM PACOTE, TERÁ QUE MUDAR O NOME
// AQUI
// PORTANTE, É MELHOR DEIXAR O NOME DA CLASSE
//É NECESSÁRIO INSERIR TODAS AS CLASSES QUE SERÃO UTILIZADAS PELO SPRING
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDao.class })
public class AppWebConfiguration {

	// CLASSE DO SPRING
	//RESOLVEDOR INTERNO DE PÁGINAS
	//TODA CLASSE GERENCIADA PELO SPRING PRECISA DA ANOTAÇÃO BEAN
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		//Prefixo e Sufixo
		//PREFIXO QUE SERA JUNTADO COM O O RETORNO DO HomeController
		resolver.setPrefix("/WEB-INF/views/");
		//Tipos dos arquivos
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

}
