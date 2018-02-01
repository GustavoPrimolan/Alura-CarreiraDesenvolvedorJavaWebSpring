package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProdutoDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.CarrinhoCompras;

//HABILITA O WEB MVC DO SPRING
@EnableWebMvc
// SPRING IRÁ SCANEAR PELOS COMPONENTES DELE A CLASSE
// O PARÂMETRO BASE PACKAGE CLASSES, É POSSÍVEL INSERIR AS CLASSES
// JÁ O PARÂMETRO BASEPACKAGES É NECESSÁRIO INSERIR A STRING COM O NOME
// DOS PACOTES, POR CONTA DISSO SE MUDAR ALGUM PACOTE, TERÁ QUE MUDAR O NOME
// AQUI
// PORTANTE, É MELHOR DEIXAR O NOME DA CLASSE
// É NECESSÁRIO INSERIR TODAS AS CLASSES QUE SERÃO UTILIZADAS PELO SPRING
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDao.class, FileSaver.class, CarrinhoCompras.class })
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	// CLASSE DO SPRING
	// RESOLVEDOR INTERNO DE PÁGINAS
	// TODA CLASSE GERENCIADA PELO SPRING PRECISA DA ANOTAÇÃO BEAN
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// Prefixo e Sufixo
		// PREFIXO QUE SERA JUNTADO COM O O RETORNO DO HomeController
		resolver.setPrefix("/WEB-INF/views/");
		// Tipos dos arquivos
		resolver.setSuffix(".jsp");
		
		//LIBERA O CARRINHO DE COMPRAS NO JSP
		//TODOS OS BEANS FICAM COMO ATRIBUTOS NA JSP
		//ENTRETANTO É PERIGOSO, POIS DEIXAR TODOS OS BEANS DISPONÍVEIS NA PÁGINA
		//resolver.setExposeContextBeansAsAttributes(true);
		
		//QUAL BEAN VOCÊ DESEJA LIBERAR
		//PRIMEIRA LETRA SEMPRE MINÚSCULA
		resolver.setExposedContextBeanNames("carrinhoCompras");
		
		return resolver;
	}

	// MÉTODO QUE ENTREGA O MESSAGES.PROPERTIES
	// PARA QUE SEJA GERENCIADO PELO SPRING
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		// TEMPO QUE VAI DEMORAR PARA RECARREGAR
		messageSource.setCacheSeconds(1);

		return messageSource;
	}

	// MÉTODO QUE TRABALHA COM A PARTE DE CONVERSÃO DE DATAS E ENTRE OUTROS TIPOS
	// SPRING ESPERA QUE SEJA ESSE O NOME DO MÉTODO
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		// REGISTRA NO CONVERSION SERVICE
		registrar.registerFormatters(conversionService);

		return conversionService;

	}

	// NECESSÁRIO PARA RESOLVER A INSERÇÃO DOS ARQUIVOS
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	//NECESSÁRIO PARA INSERIR O CSS E AS IMAGENS
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/css", "/resources/imagens");
	}

	
	//DA O RestTemplate PARA ELE
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
