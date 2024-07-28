package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoController;
import model.ProdutoTabelModel;

public class ProdutoTela extends JFrame {
	
	private JPanel contentPane;
	private JTable tableProduto;
	private JTextField textFieldNome;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;
	private JButtonGradient btnSalvar;
	private JButtonGradient btnAtualizar;
	private JButtonGradient btnExcluir;
	
	private ProdutoController controller;
	private ProdutoTabelModel tableModel = new ProdutoTabelModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.put("OptionPane.yesButtonText", "Sim");
					UIManager.put("OptionPane.noButtonText", "Não");
					UIManager.put("OptionPane.cancelButtonText", "Cancelar");
					
					ProdutoTela frame = new ProdutoTela();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public ProdutoTela() {
		
		controller = new ProdutoController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 494);
		contentPane = new JPainelGradient();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 659, 261);
		contentPane.add(scrollPane);
		
		tableProduto = new JTable();
		tableProduto.setRowHeight(20);
		tableProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.preencherCamposParaAtualizar();
			}
		});
		tableProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(tableProduto.getSelectedRow() != -1) {
					controller.preencherCamposParaAtualizar();				
				}
			}
		});
		tableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProduto.setFont(new Font("Arial", Font.PLAIN, 12));
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Title1", "Title2", "Title3"
			}
		));
		scrollPane.setViewportView(tableProduto);
		tableProduto.setModel(tableModel);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldNome.setBorder(new LineBorder(Color.WHITE));
		textFieldNome.setForeground(Color.BLACK);
		textFieldNome.setBounds(10, 97, 239, 27);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBorder(new LineBorder(Color.WHITE));
		textFieldQuantidade.setForeground(Color.BLACK);
		textFieldQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldQuantidade.setBounds(259, 97, 200, 26);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		textFieldValor = new JTextField();
		textFieldValor.setBorder(new LineBorder(Color.WHITE));
		textFieldValor.setForeground(Color.BLACK);
		textFieldValor.setFont(new Font("Arial", Font.PLAIN, 12));
		textFieldValor.setBounds(469, 97, 200, 27);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setBounds(10, 78, 58, 14);
		contentPane.add(lblDescricao);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setBounds(259, 78, 69, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValor.setForeground(Color.WHITE);
		lblValor.setBounds(469, 78, 35, 14);
		contentPane.add(lblValor);
		
		btnSalvar = new JButtonGradient();
		btnSalvar.setText("SALVAR");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalvar.setForeground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSalvar.setForeground(Color.WHITE);
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.adicionarProduto();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalvar.setBounds(10, 144, 120, 28);
		contentPane.add(btnSalvar);
		
		btnAtualizar = new JButtonGradient();
		btnAtualizar.setText("ATUALIZAR");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtualizar.setForeground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtualizar.setForeground(Color.WHITE);
			}
		});
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.atualizarProduto();
			}
		});
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtualizar.setBounds(137, 144, 112, 28);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButtonGradient();
		btnExcluir.setText("EXCLUIR");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExcluir.setForeground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExcluir.setForeground(Color.WHITE);
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.excluirProduto();
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.setBounds(347, 144, 112, 28);
		contentPane.add(btnExcluir);
		
		JLabel lblAbaProdutos = new JLabel("Produtos");
		lblAbaProdutos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAbaProdutos.setForeground(Color.WHITE);
		lblAbaProdutos.setBounds(299, 20, 80, 20);
		contentPane.add(lblAbaProdutos);
	}

	public JTable getTableProduto() {
		return tableProduto;
	}

	public void setTableProduto(JTable tableProduto) {
		this.tableProduto = tableProduto;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextFieldQuantidade() {
		return textFieldQuantidade;
	}

	public void setTextFieldQuantidade(JTextField textFieldQuantidade) {
		this.textFieldQuantidade = textFieldQuantidade;
	}

	public JTextField getTextFieldValor() {
		return textFieldValor;
	}

	public void setTextFieldValor(JTextField textFieldValor) {
		this.textFieldValor = textFieldValor;
	}

	public ProdutoTabelModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(ProdutoTabelModel tableModel) {
		this.tableModel = tableModel;
	}
	
}
