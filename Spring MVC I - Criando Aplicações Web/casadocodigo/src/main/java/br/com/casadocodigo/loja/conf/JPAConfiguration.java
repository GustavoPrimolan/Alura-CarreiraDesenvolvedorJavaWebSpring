package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//TRANSAÇÃO PARA O SPRING TOMAR CONTA
@EnableTransactionManagement
public class JPAConfiguration {
	
	//MÉTODOS QUE CRIAM NAS CONFIGURAÇÕES PRECISAM SER CONHECIDOS PELO SPRING
	//POR ISSO A ANOTAÇÃO BEAN
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		
		//ADAPTADOR DO HIBERNATE QUE IREMOS UTILIZAR
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		
		//CONFIGURAÇÕES DO BANCO DE DADOS
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		factoryBean.setDataSource(dataSource);
		
		//PROPRIEDADES DO HIBERNATE 
		Properties props = new Properties();
		//- O DIALETO UTILIZADO NA APLICAÇÃO
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		//MOSTRAR O SQL
		props.setProperty("hibernate.show_sql", "true");
		//GERENCIAR O BANCO
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		factoryBean.setJpaProperties(props);
		
		//AS ENTIDADES QUE SERÃO UTILIZADAS
		factoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");
		
		
		return factoryBean;
	}
	
	//SEJA RECONHECIDO PELO SPRING PARA SER O CRIADOR DA TRANSAÇÃO
	@Bean
	public JpaTransactionManager transactionalManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
}
