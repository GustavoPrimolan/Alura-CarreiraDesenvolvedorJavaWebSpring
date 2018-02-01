package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//COMPONENT PARA PODER INJETAR
@Component
//CADA USUÁRIO TERÁ UM CARRINHO
//O CONTROLLER PRECISA TER O SCOPE DE REQUEST
//E O DO MODEL TEM QUE SER O SESSION
//IMPLEMENTAR SERIALIZABLE PARA ARMAZENAR O OBJETO
//proxyMode, CRIA UM PROXY PARA FAZER A LIGAÇÃO DIRETA COM O CARRINHO DE COMPRAS
//O SPRING SE VIRA PARA CONSEGUIR RESOLVER AS DEPÊNDENCIAS, NÃO PRECISANDO MUDAR O SCOPO DOS CONTROLLERS
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();

	public Collection<CarrinhoItem> getItens(){
		return itens.keySet();
	}
	
	public void add(CarrinhoItem item) {
		itens.put(item, getQuantidade(item) + 1);
	}

	// SE NÃO CONTÉM A CHAVE, COLOCA O VALOR 0 DENTRO DELE, SOMANDO COM + 1 NO
	// MÉTODO add
	public Integer getQuantidade(CarrinhoItem item) {
		if (!itens.containsKey(item)) {
			itens.put(item, 0);
		}

		return itens.get(item);
	}

	public int getQuantidade() {
		// LAMBDA
		return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
	}
	
	public BigDecimal getTotal(CarrinhoItem item){
		return item.getTotal(getQuantidade(item));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (CarrinhoItem item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		
		return total;
	}

	public void remover(Integer produtoId, TipoPreco tipoPreco) {
		Produto produto = new Produto();
		produto.setId(produtoId);
		
		itens.remove(new CarrinhoItem(produto, tipoPreco));
	}

}
