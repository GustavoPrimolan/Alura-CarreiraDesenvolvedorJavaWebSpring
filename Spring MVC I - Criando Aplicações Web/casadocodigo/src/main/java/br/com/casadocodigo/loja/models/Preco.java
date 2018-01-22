package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

//PQ ELE ESTÁ NO PRODUTO COMO ELEMENT COLLECTION
@Embeddable
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipo;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoPreco getTipo() {
		return tipo;
	}
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	
}
