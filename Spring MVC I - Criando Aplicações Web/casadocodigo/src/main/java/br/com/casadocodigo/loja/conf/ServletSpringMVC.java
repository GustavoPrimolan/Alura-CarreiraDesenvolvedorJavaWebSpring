package br.com.casadocodigo.loja.conf;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

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
	
	//FILTRO PARA ENCODING UTF-8
	//TODA REQUISIÇÃO SPRING SERÁ CONVERTIDO O ENCODING PARA UTF-8
//	@Override
//	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//		encodingFilter.setEncoding("UTF-8");
//		return new Filter[] {encodingFilter};
//	}
	
	//QUAL A PARTE QUE SERÁ CONFIGURADA COMO ARQUIVO?
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
	
}
