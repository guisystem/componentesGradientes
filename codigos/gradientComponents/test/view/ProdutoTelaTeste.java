package view;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ProdutoController;

class ProdutoTelaTeste {

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
	void testarInicializarTela() {
		ProdutoTela.main(null);
		produtoTela.setResizable(false);
		produtoTela.setLocationRelativeTo(null);
		produtoTela.setVisible(true);
		
		assertTrue(produtoTela.isVisible());

		controller.adicionarProduto();
		produtoTela.getTableProduto().setRowSelectionInterval(0, 0);
		assertEquals(1, produtoTela.getTableModel().getRowCount());
		assertEquals(0, produtoTela.getTableProduto().getSelectedRow());
		
		produtoTela.getTextFieldNome().setText("Caderno");
		produtoTela.getTextFieldQuantidade().setText("200");
		produtoTela.getTextFieldValor().setText("21.50");
		
		controller.adicionarProduto();
		produtoTela.getTableProduto().setRowSelectionInterval(1, 1);
		assertEquals(2, produtoTela.getTableModel().getRowCount());
		assertEquals(1, produtoTela.getTableProduto().getSelectedRow());
		
	}

}
