package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//HERDA AS CONFIGURAÇÕES DO SPRING
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//CLASSE QUE SERÁ UTILIZANDO COMO SENDO A CLASSE DE CONFIGURAÇÃO DO PROJETO WEB
		//TODAS AS CLASSES DE CONFIGURAÇÃO DEVERÃO SER ADICIONADAS AQUI
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		//URL QUE O SPRING IRÁ MAPEAR
		return new String[] {"/"};
	}
	
}
