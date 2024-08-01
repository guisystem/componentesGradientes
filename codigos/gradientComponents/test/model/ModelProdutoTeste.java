package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelProdutoTeste {

	private ModelProduto produto = new ModelProduto();
	
	@BeforeEach
	void iniciar() {
		produto = new ModelProduto("Caneta", 100, 2);
	}
	
	@Test
	void testarGetSetNome() {
		produto.setNome("Caderno");
		assertEquals("Caderno", produto.getNome());
	}
	
	@Test
	void testarGetSetQuantidade() {
		produto.setQuantidade(200);
		assertEquals(200, produto.getQuantidade());
	}
	
	@Test
	void testarGetSetValor() {
		produto.setValor(1);
		assertEquals(1, produto.getValor());
	}

}
