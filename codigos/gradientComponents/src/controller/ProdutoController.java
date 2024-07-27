package controller;

import javax.swing.JOptionPane;

import controller.helper.ProdutoHelper;
import model.ModelProduto;
import view.ProdutoTela;

public class ProdutoController {

	private final ProdutoTela produtoTela;
	private final ProdutoHelper helper;
	
	public ProdutoController(ProdutoTela produtoTela) {
		this.produtoTela = produtoTela;
		this.helper = new ProdutoHelper(produtoTela);
	}

	public ModelProduto adicionarProduto() {
		ModelProduto novoProduto = helper.obterModelo();
		
		if(helper.verificarCampos()) {			
			if(helper.validarNomesDiferentes()) {
				if(helper.validarQuantidade()) {
					if(helper.validarValor()) {
						
						produtoTela.getTableModel().addRow(novoProduto);
						helper.limparTela();
						
					}else {
						JOptionPane.showMessageDialog(null, "Valor inválido!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Quantidade inválida!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Esse nome de produto já existe!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!");			
		}
		
		return novoProduto;
	}

	public void atualizarProduto() {
		
		if(produtoTela.getTableProduto().getSelectedRow() != -1) {
			if(helper.verificarCampos()) {			
				if(helper.validarQuantidade()) {
					if(helper.validarValor()) {
						
						produtoTela.getTableModel().setValueAt(produtoTela.getTextFieldNome().getText(), produtoTela.getTableProduto().getSelectedRow(), 0);
						produtoTela.getTableModel().setValueAt(produtoTela.getTextFieldQuantidade().getText(), produtoTela.getTableProduto().getSelectedRow(), 1);
						produtoTela.getTableModel().setValueAt(produtoTela.getTextFieldValor().getText(), produtoTela.getTableProduto().getSelectedRow(), 2);
						
						helper.limparTela();							
					}else {
						JOptionPane.showMessageDialog(null, "Valor inválido!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Quantidade inválida!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");			
			}
		}else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar");
		}
	}

	public void excluirProduto() {
		if(produtoTela.getTableProduto().getSelectedRow() != -1) {
			if(JOptionPane.showConfirmDialog(null, "Deseja excluir esse produto?", "Tem certeza?", JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
				produtoTela.getTableModel().removeRow(produtoTela.getTableProduto().getSelectedRow());
				helper.limparTela();				
			}
		}else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir");
		}
	}

	public void preencherCamposParaAtualizar() {
		helper.preencherCampos();
	}

}
