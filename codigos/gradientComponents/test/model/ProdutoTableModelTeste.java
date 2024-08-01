package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTableModelTeste {

	private ProdutoTabelModel produtoTabelModel;
	private ModelProduto produto1;
	private ModelProduto produto2;
	private ModelProduto produto3;
	
	@BeforeEach
	void iniciar() {
		produtoTabelModel = new ProdutoTabelModel();
		produto1 = new ModelProduto("produto1", 1, 1);
		produto2 = new ModelProduto("produto2", 2, 2);
		produto3 = new ModelProduto("produto3", 3, 3);
	}
	
	@Test
	void testarGetColumnName() {
		assertEquals("Descrição", produtoTabelModel.getColumnName(0));
	}
	
	@Test
	void testarGetRowCountSemDados() {
		assertEquals(0, produtoTabelModel.getRowCount());
	}
	
	@Test
	void testarGetRowCountComDados() {
		produtoTabelModel.addRow(produto1);
		assertEquals(1, produtoTabelModel.getRowCount());
	}
	
	@Test
	void testarGetColumnCount() {
		assertEquals(3, produtoTabelModel.getColumnCount());
	}
	
	@Test
	void testarGetValueAtExcecao() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			produtoTabelModel.getValueAt(0, 0);
		});
	}
	
	@Test
	void testarGetValueAtColuna0() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.addRow(produto2);
		produtoTabelModel.addRow(produto3);
		
		assertEquals("produto1", produtoTabelModel.getValueAt(0, 0));
	}
	
	@Test
	void testarGetValueAtColuna1() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.addRow(produto2);
		produtoTabelModel.addRow(produto3);
		
		assertEquals(2, produtoTabelModel.getValueAt(1, 1));
	}
	
	@Test
	void testarGetValueAtColuna2() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.addRow(produto2);
		produtoTabelModel.addRow(produto3);
		
		assertEquals(3.0, produtoTabelModel.getValueAt(2, 2));
	}

	@Test
	void testarGetValueAtColunaNull() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.addRow(produto2);
		produtoTabelModel.addRow(produto3);
		
		assertEquals(null, produtoTabelModel.getValueAt(1, 4));
	}
	
	@Test
	void testarSetValueAtColunaExcecao() {
		produtoTabelModel.setValueAt("NovoProduto", 1, 3);
	}
	
	@Test
	void testarSetValueAtColuna0() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.setValueAt("produto1", 0, 0);
		
		assertEquals("produto1", produtoTabelModel.getValueAt(0, 0));
	}
	
	@Test
	void testarSetValueAtColuna1() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.setValueAt("3", 0, 1);
		
		assertEquals(3, produtoTabelModel.getValueAt(0, 1));
	}
	
	@Test
	void testarSetValueAtColuna2() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.setValueAt("2", 0, 2);
		
		assertEquals(2.0, produtoTabelModel.getValueAt(0, 2));
	}
	
	@Test
	void testarRemoveRow() {
		produtoTabelModel.addRow(produto1);
		
		assertEquals(1, produtoTabelModel.getRowCount());

		produtoTabelModel.removeRow(0);
		assertEquals(0, produtoTabelModel.getRowCount());
		
	}
	
	@Test
	void testarGetProduto() {
		produtoTabelModel.addRow(produto1);
		produtoTabelModel.addRow(produto2);
		
		assertEquals("produto2", produtoTabelModel.getProduto(1).getNome());
		assertEquals(2, produtoTabelModel.getProduto(1).getQuantidade());
		assertEquals(2, produtoTabelModel.getProduto(1).getValor());
		
	}
	
}
