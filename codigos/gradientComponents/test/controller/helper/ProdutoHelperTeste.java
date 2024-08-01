package controller.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ProdutoController;
import model.ModelProduto;
import view.ProdutoTela;

class ProdutoHelperTeste {

	private ProdutoHelper helper;
	private ProdutoController controller;
	private ProdutoTela produtoTela;
	
	@BeforeEach
	void iniciar() {
		produtoTela = new ProdutoTela();
		controller = new ProdutoController(produtoTela);
		helper = new ProdutoHelper(produtoTela);
		
		produtoTela.getTextFieldNome().setText("Caneta");
		produtoTela.getTextFieldQuantidade().setText("100");
		produtoTela.getTextFieldValor().setText("1.50");
	}
	
	@Test
	void testarObterModelo() {
		ModelProduto produto = helper.obterModelo();
		
		assertEquals("Caneta", produto.getNome());
	}
	
	@Test
	void testarVerificarCamposVazios() {
		produtoTela.getTextFieldNome().setText("");
		assertFalse(helper.verificarCampos());
	}
	
	@Test
	void testarVerificarCamposPreenchidos() {
		assertTrue(helper.verificarCampos());
	}
	
	@Test
	void testarValidarNomesDiferentes_iguais() {
		controller.adicionarProduto();
		
		produtoTela.getTextFieldNome().setText("Caneta");
		
		assertFalse(helper.validarNomesDiferentes());
	}
	
	@Test
	void testarValidarNomesDiferentes_diferentes() {
		
		assertTrue(helper.validarNomesDiferentes());
	}
	
	@Test
	void testarValidarQuantidade_valida() {
		produtoTela.getTextFieldQuantidade().setText("100");
		
		assertTrue(helper.validarQuantidade());
	}
	
	@Test
	void testarValidarQuantidade_invalida() {
		produtoTela.getTextFieldQuantidade().setText("100re");
		
		assertFalse(helper.validarQuantidade());
	}
	
	@Test
	void testarValidarValor_valido() {
		produtoTela.getTextFieldValor().setText("1.50");
		
		assertTrue(helper.validarValor());
	}
	
	@Test
	void testarValidarValor_invalido() {
		produtoTela.getTextFieldValor().setText("1.50r3");
		
		assertFalse(helper.validarValor());
	}
	
	@Test
	void testarPreencherCamposSemSelecionarLinha() {
		helper.preencherCampos();
		assertEquals(-1, produtoTela.getTableProduto().getSelectedRow());
	}
	
	@Test
	void testarPreencherCamposComLinhaSelecionada() {
		controller.adicionarProduto();
		
		produtoTela.getTableProduto().setRowSelectionInterval(0, 0);
		helper.preencherCampos();
		
		assertEquals("100", produtoTela.getTextFieldQuantidade().getText());
	}
	
	@Test
	void testarLimparTela() {
		helper.limparTela();
		assertEquals("", produtoTela.getTextFieldValor().getText());
	}

}
