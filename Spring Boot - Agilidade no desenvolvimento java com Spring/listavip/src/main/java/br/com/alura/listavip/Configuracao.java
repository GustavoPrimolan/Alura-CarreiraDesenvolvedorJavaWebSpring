package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//ANOTA��O � UM AGLOMERADO DE V�RIAS ANOTA��ES
//ELA � UMA ANOTA��O QUE CONFIGURA, SCANEA E FAZ O TRABALHO DE OUTRAS ANOTA��ES
//CONFIGURA O SPRING BOOT
@SpringBootApplication
//ELE PODE SER UM CONTROLLER (SPRING MVC)
//@Controller
public class Configuracao {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
	
	//CONFIGURA��O DO HIBERNATE JPA
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
