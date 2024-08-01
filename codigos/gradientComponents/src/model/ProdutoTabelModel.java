package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoTabelModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ModelProduto> produtos = new ArrayList<>();
	private String[] colunas = {"Descrição", "Quantidade", "Valor"};
	
	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}
	
	@Override
	public int getRowCount() {
		if(produtos.isEmpty()) {
			return 0;
		}
		return produtos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		switch(coluna) {
		
		case 0:
			return produtos.get(linha).getNome();
		case 1:
			return produtos.get(linha).getQuantidade();
		case 2:
			return produtos.get(linha).getValor();
			
		}
		
		return null;
	}
	
	@Override
	public void setValueAt(Object dado, int linha, int coluna) {
		switch(coluna) {
		
		case 0:
			produtos.get(linha).setNome((String) dado);
			break;
		case 1:
			produtos.get(linha).setQuantidade(Integer.parseInt((String) dado));
			break;
		case 2:
			produtos.get(linha).setValor(Double.parseDouble((String) dado));
			break;			
		}
		
		this.fireTableRowsUpdated(linha, linha);
	}
	
	public void addRow(ModelProduto p) {
		this.produtos.add(p);
		this.fireTableDataChanged(); // Atualiza a tabela sempre que tiver uma alteração
	}
	
	public void removeRow(int linha) {
		this.produtos.remove(linha);
		this.fireTableRowsDeleted(linha, linha); // Deleta a linha na tabela
	}
	
	public ModelProduto getProduto(int linha) {
		ModelProduto produtoLinha = new ModelProduto();
		produtoLinha.setNome(produtos.get(linha).getNome());
		produtoLinha.setQuantidade(produtos.get(linha).getQuantidade());
		produtoLinha.setValor(produtos.get(linha).getValor());
		
		return produtoLinha;
	}
	
}
