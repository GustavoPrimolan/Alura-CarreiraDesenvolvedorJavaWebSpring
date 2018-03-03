package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//ANOTAÇÃO É UM AGLOMERADO DE VÁRIAS ANOTAÇÕES
//ELA É UMA ANOTAÇÃO QUE CONFIGURA, SCANEA E FAZ O TRABALHO DE OUTRAS ANOTAÇÕES
//CONFIGURA O SPRING BOOT
@SpringBootApplication
//ELE PODE SER UM CONTROLLER (SPRING MVC)
//@Controller
public class Configuracao {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
	
	//CONFIGURAÇÃO DO HIBERNATE JPA
	//PRECISA SER UM BEAN PARA O SPRING GERENCIAR
	/*
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	*/
	
	
}
