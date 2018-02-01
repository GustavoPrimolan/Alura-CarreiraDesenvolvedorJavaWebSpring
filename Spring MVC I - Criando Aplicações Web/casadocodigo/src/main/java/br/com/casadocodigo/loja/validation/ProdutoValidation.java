package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoValidation implements Validator {
	
	//MÉTODO PARA SABER SE SUPORTA A CLASSE QUE ESTÁ SENDO ENVIADA
	//SÓ ASSIM ELE VAI SABER SE PODE CHAMAR O VALIDATOR PARA O NOSSO PRODUTO
	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	//MÉTODO PARA FAZER A VALIDAÇÃO
	@Override
	public void validate(Object target, Errors errors) {
		// VALIDAR SE FOR VAZIO
		// INFORMAÇÕES DE ERROS, O CAMPO QUE SERÁ VERIFICADO E O CAMPO REQUISITADO
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
		
		Produto produto = (Produto) target;
		
		if (produto.getPaginas() <= 0) {
			// REJEITA O VALOR
			// CAMPO, CAMPO REQUERIDO
			errors.rejectValue("paginas", "field.required");
		}
	}
}
