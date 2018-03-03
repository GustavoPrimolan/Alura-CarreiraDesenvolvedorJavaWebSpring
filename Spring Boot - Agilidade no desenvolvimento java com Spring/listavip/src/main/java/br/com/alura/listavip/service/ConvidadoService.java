package br.com.alura.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

//DIZ PARA O SPRING QUE A CLASSE É UM SERVIÇO
@Service
public class ConvidadoService {

	// INJETA O REPOSITORY
	@Autowired
	private ConvidadoRepository repository;
	
	
	public Iterable<Convidado> obterTodos() {
		Iterable<Convidado> convidados = repository.findAll();
		return convidados;
	}
	
	public void salvar(Convidado convidado) {
		repository.save(convidado);
	}
}
