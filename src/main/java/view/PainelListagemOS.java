package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.CategoriaController;
import controller.ClienteController;
import controller.OrdemServicoController;
import controller.ProfissionalController;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Profissional;

public class PainelListagemOS extends JPanel {
	private TelaEditarOS telaEditarOS = null;
	private JTable tblOrdemServico;
	private String[] colunasTabelaOS = { "Número da Ordem", "Nome do Cliente", "Nome do Profissional", "Categoria" };
	private JTextField textField;
	private ClienteController clienteController = new ClienteController();
	private CategoriaController categoriaController = new CategoriaController();
	private OrdemServicoController ordemServicoController = new OrdemServicoController();
	private ArrayList<Categoria> categorias;
	private ArrayList<Cliente> clientes;
	private JComboBox cbCategoria;

	/**
	 * Create the panel.
	 */
	public PainelListagemOS() {

		JLabel lblConsultaDeOrdens = new JLabel("Consulta de Ordem de Servi\u00E7o");
		lblConsultaDeOrdens.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");

		JLabel lblCategoria = new JLabel("Categoria:");

		categorias = categoriaController.listarCategorias();
		cbCategoria = new JComboBox(categorias.toArray());

		JLabel lblNumeroOS = new JLabel("N\u00FAmero da OS:");

		JComboBox cbDataInicialOS = new JComboBox();

		tblOrdemServico = new JTable();

		limparTabela();

		JButton btnConsultar = new JButton("Consultar");

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnEditarOs = new JButton("Visualizar OS");
		btnEditarOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					telaEditarOS = new TelaEditarOS();
					telaEditarOS.setVisible(true);
					telaEditarOS.setLocationRelativeTo(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblConsultaDeOrdens, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeCliente)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCategoria)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNumeroOS, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(cbDataInicialOS, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(72)
									.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
							.addGap(93)
							.addComponent(tblOrdemServico, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(477)
							.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(236)
							.addComponent(btnEditarOs, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addGap(134))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblConsultaDeOrdens, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNomeCliente)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblCategoria)
							.addGap(13)
							.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblNumeroOS)
							.addGap(13)
							.addComponent(cbDataInicialOS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnConsultar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(tblOrdemServico, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditarOs)
						.addComponent(btnFechar)))
		);
		setLayout(groupLayout);

	}

	protected void atualizarTabelaOS() {

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
//		for (  : ) {
//			String[] novaLinha = new String[7];
//			novaLinha[0] = String.valueOf(telefone.getId());
//			novaLinha[1] = telefone.getCodigoPais();
//			novaLinha[2] = String.valueOf(telefone.getDdd());
//			novaLinha[3] = String.valueOf(telefone.getNumero());
//			novaLinha[4] = String.valueOf(telefone.isAtivo());
//			novaLinha[5] = String.valueOf(telefone.isMovel());
//			novaLinha[6] = String.valueOf(telefone.getDono());
//
//			model.addRow(novaLinha);
//		}
	}

	private void limparTabela() {

		tblOrdemServico.setModel(new DefaultTableModel(new Object[][] { colunasTabelaOS, }, colunasTabelaOS));
	}
}
