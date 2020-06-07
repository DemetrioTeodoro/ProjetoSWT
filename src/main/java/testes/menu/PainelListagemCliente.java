package testes.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PainelListagemCliente extends JPanel {
	private TelaEditarCliente telaEditarCliente = null;
	private JTable tblClientes;
	private String[] colunasTabelaCliente = { "Nome do Cliente", "CPF/CNPJ", "Cliente Ativo", "Telefone" };
	private JTextField textField;
	private JTextField txtCpfCnpj;

	/**
	 * Create the panel.
	 */
	public PainelListagemCliente() {

		JLabel lblConsultaClientes = new JLabel("Consulta de Clientes");
		lblConsultaClientes.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblCPFCNPJ = new JLabel("CPF/CNPJ:");

		JLabel lblNomeCliente = new JLabel("Nome do cliente:");

		tblClientes = new JTable();

		limparTabela();

		JButton btnConsultar = new JButton("Consultar");

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		JButton btnEditar = new JButton("Visualizar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					telaEditarCliente = new TelaEditarCliente();
					telaEditarCliente.setVisible(true);
					telaEditarCliente.setLocationRelativeTo(null);
			}
		});

		textField = new JTextField();
		textField.setColumns(10);
		
		txtCpfCnpj = new JTextField();
		txtCpfCnpj.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblConsultaClientes, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeCliente)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCPFCNPJ, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(txtCpfCnpj, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(70)
									.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
							.addGap(66)
							.addComponent(tblClientes, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(425)
							.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(302)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addGap(34))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblConsultaClientes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNomeCliente)
							.addGap(13)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblCPFCNPJ)
							.addGap(11)
							.addComponent(txtCpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(btnConsultar))
						.addComponent(tblClientes, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditar)
						.addComponent(btnFechar)))
		);
		setLayout(groupLayout);

	}

	protected void atualizarTabelaOS() {

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
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

		tblClientes.setModel(new DefaultTableModel(new Object[][] { colunasTabelaCliente, }, colunasTabelaCliente));
	}
}
