package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

//O SPRING MAPEIA O DAO
//É MAIS SEMÂNTICO
@Repository
//ANOTATION QUE PERMITE QUE A CLASSE SEJA GERENCIADO PELO SPRING
//@Component
//DEIXA A CLASSE COMO TRANSACIONAL QUE DEIXA O SPRING TOMAR CONTA
//UTILIZANDO O PACOTE DO SPRING
@Transactional
public class ProdutoDao {
	
	//INJETA A DEPENDÊNCIA DO ENTITY MANAGER
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}
}
