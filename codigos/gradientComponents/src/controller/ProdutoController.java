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
						produtoTela.exibeMensagemInformativa("Valor inválido!");
					}
				}else {
					produtoTela.exibeMensagemInformativa("Quantidade inválida!");
				}
			}else {
				produtoTela.exibeMensagemInformativa("Esse nome de produto já existe!");
			}
		}else {
			produtoTela.exibeMensagemInformativa("Preencha todos os campos!");
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
						produtoTela.exibeMensagemInformativa("Valor inválido!");
					}
				}else {
					produtoTela.exibeMensagemInformativa("Quantidade inválida!");
				}
			}else {
				produtoTela.exibeMensagemInformativa("Preencha todos os campos!");
			}
		}else {
			produtoTela.exibeMensagemInformativa("Selecione uma linha para atualizar");
		}
	}

	public boolean excluirProduto() {
		if(produtoTela.getTableProduto().getSelectedRow() != -1) {
			if(produtoTela.exibeMensagemDecisao("Deseja excluir esse produto?") == JOptionPane.YES_OPTION) {
				produtoTela.getTableModel().removeRow(produtoTela.getTableProduto().getSelectedRow());
				helper.limparTela();
				return true;
			}
		}else {
			produtoTela.exibeMensagemInformativa("Selecione uma linha para excluir");
		}
		
		return false;
	}

	public void preencherCamposParaAtualizar() {
		helper.preencherCampos();
	}

}
