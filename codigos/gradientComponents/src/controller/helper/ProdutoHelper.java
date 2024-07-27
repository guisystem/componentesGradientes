package controller.helper;

import model.ModelProduto;
import view.ProdutoTela;

public class ProdutoHelper {

	private final ProdutoTela produtoTela;

	public ProdutoHelper(ProdutoTela produtoTela) {
		super();
		this.produtoTela = produtoTela;
	}

	public ModelProduto obterModelo() {
		String nome = produtoTela.getTextFieldNome().getText();
		String quantidadeTela = produtoTela.getTextFieldQuantidade().getText();
		String valorTela = produtoTela.getTextFieldValor().getText();
		
		int quantidade = 0;
		double valor = 0;
		
		try {
			quantidade = Integer.parseInt(quantidadeTela);
			valor = Double.parseDouble(valorTela);
			
		}catch (Exception e) {
			
		}
		
		ModelProduto produto = new ModelProduto(nome, quantidade, valor);
		return produto;
	}

	public boolean verificarCampos() {
		if(produtoTela.getTextFieldNome().getText().trim().isEmpty() || produtoTela.getTextFieldQuantidade().getText().trim().isEmpty() ||
				produtoTela.getTextFieldValor().getText().trim().isEmpty()) {
			return false;
		}
		
		return true;
	}

	public boolean validarNomesDiferentes() {
		int numeroLinhas = produtoTela.getTableProduto().getRowCount();
		String nome = produtoTela.getTextFieldNome().getText();
		
		for(int i = 0; i < numeroLinhas; i++) {
			String nomeTabela = produtoTela.getTableProduto().getValueAt(numeroLinhas - 1, 0).toString();
			
			if(nomeTabela.equalsIgnoreCase(nome.trim())) {
				return false;
			}
		}
		
		return true;
	}

	@SuppressWarnings("unused")
	public boolean validarQuantidade() {
		String quantidadeTela = produtoTela.getTextFieldQuantidade().getText();
		int quantidade = 0;
		
		try {
			quantidade = Integer.parseInt(quantidadeTela);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	public boolean validarValor() {
		String valorTela = produtoTela.getTextFieldValor().getText();
		double valor = 0;
		
		try {
			valor = Double.parseDouble(valorTela);
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
	public void preencherCampos() {
		int i = produtoTela.getTableProduto().getSelectedRow();
		
		if(i == -1) {
			
		}else {
			produtoTela.getTextFieldNome().setText(produtoTela.getTableProduto().getValueAt(i, 0).toString());
			produtoTela.getTextFieldQuantidade().setText(produtoTela.getTableProduto().getValueAt(i, 1).toString());
			produtoTela.getTextFieldValor().setText(produtoTela.getTableProduto().getValueAt(i, 2).toString());
		}	
	}

	public void limparTela() {
		produtoTela.getTextFieldNome().setText("");
		produtoTela.getTextFieldQuantidade().setText("");
		produtoTela.getTextFieldValor().setText("");
		
	}
	
}
