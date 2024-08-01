package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import view.ProdutoTela;

class ProdutoControllerTeste {

	private ProdutoController controller;
	private ProdutoTela produtoTela;
	
	@BeforeEach
	void iniciar() {
		produtoTela = new ProdutoTela();
		controller = new ProdutoController(produtoTela);
		
		produtoTela.getTextFieldNome().setText("Caneta");
		produtoTela.getTextFieldQuantidade().setText("100");
		produtoTela.getTextFieldValor().setText("1.50");
	}
	
	@Test
	void testarAdicionarProduto() {
		controller.adicionarProduto();
		assertEquals(1, produtoTela.getTableProduto().getRowCount());
		assertEquals("", produtoTela.getTextFieldNome().getText());
	}
	
	@Test
	void testarAtualizarProduto() {
		controller.adicionarProduto();
		
		produtoTela.getTextFieldNome().setText("Lápis");
		produtoTela.getTextFieldQuantidade().setText("200");
		produtoTela.getTextFieldValor().setText("1.50");
		
		produtoTela.getTableProduto().setRowSelectionInterval(0, 0);
		controller.atualizarProduto();
		
		assertEquals("Lápis", produtoTela.getTableProduto().getValueAt(0, 0));
		assertEquals("", produtoTela.getTextFieldNome().getText());
	}
	
	@Test
	void testarExcluirProduto() {
		controller.adicionarProduto();
		
		produtoTela.getTableProduto().setRowSelectionInterval(0, 0);
		boolean excluiu = controller.excluirProduto();
		
		if(excluiu) {
			assertEquals(0, produtoTela.getTableProduto().getRowCount());
			assertEquals("", produtoTela.getTextFieldNome().getText());			
		}else {
			assertEquals(1, produtoTela.getTableProduto().getRowCount());
		}
	}

}
