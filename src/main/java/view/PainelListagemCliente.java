package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import model.entity.Cliente;
import model.seletor.ClienteSeletor;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelListagemCliente extends JPanel {
	
	private TelaEditarCliente telaEditarCliente = null;
	private JTable tblClientes;
	private String[] colunasTabelaCliente = { "Nome do Cliente", "CPF/CNPJ", "Telefone" , "Cliente Ativo"};
	private JTextField txtNome;
	private JFormattedTextField txtCpfCnpj;
	private ArrayList<Cliente> clientes;
	private MaskFormatter cnpjMask;
	private MaskFormatter cpfMask;
	private Cliente cliente = new Cliente();;

	/**
	 * Create the panel.
	 */
	public PainelListagemCliente() {

		JLabel lblConsultaClientes = new JLabel("Consulta de Clientes");
		lblConsultaClientes.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNomeCliente = new JLabel("Nome do Cliente");
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tblClientes = new JTable();
		/*tblClientes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblClientes.getSelectedRow();
				cliente.setNome((String) tblClientes.getValueAt(row, 0));
				cliente.setInscricao((String) tblClientes.getValueAt(row, 1));
				cliente.setTelefone((String) tblClientes.getValueAt(row, 2));
				//Pegar Endereco de cliente selecionado
			}
		});*/

		limparTabela();

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteSeletor seletor = new ClienteSeletor();
				seletor.setNome(txtNome.getText());
				seletor.setInscricao(txtCpfCnpj.getText());
				
				ClienteController controller = new ClienteController();
				clientes = controller.listarClientes(seletor);
				atualizarTabelaClientes();
			}
		});

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

		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtCpfCnpj = new JFormattedTextField();
		txtCpfCnpj.setColumns(10);
		try {
			cnpjMask = new MaskFormatter("##.###.###/####-##");
			cpfMask = new MaskFormatter("###.###.###-##");
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		JRadioButton rdbtnCpf = new JRadioButton("CPF");
		
		JRadioButton rdbtnCnpj = new JRadioButton("CNPJ");
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnCpf);
		radioGroup.add(rdbtnCnpj);
		
		rdbtnCpf.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtCpfCnpj.setValue(null);
					txtCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
				}
			}
		});
		
		
		rdbtnCnpj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtCpfCnpj.setValue(null);
					txtCpfCnpj.setFormatterFactory(new DefaultFormatterFactory(cnpjMask));
				}
			}
		});

		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblConsultaClientes, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(78)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNomeCliente)
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCpfCnpj, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnCpf)
											.addGap(37)
											.addComponent(rdbtnCnpj)))
									.addGap(66))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(105)))
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
							.addGap(2)
							.addComponent(lblNomeCliente)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnCnpj)
								.addComponent(rdbtnCpf))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(btnConsultar))
						.addComponent(tblClientes, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditar)
						.addComponent(btnFechar)))
		);
		setLayout(groupLayout);

	}

	private void atualizarTabelaClientes() {

		this.limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
		
		for ( Cliente c : clientes) {
			
			String[] novaLinha = new String[7];
			novaLinha[0] = c.getNome();
			novaLinha[1] = c.getInscricao();
			novaLinha[2] = c.getTelefone();
			novaLinha[3] = String.valueOf(c.isAtivo() == true ? "Ativo" : "Inativado");

			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {

		tblClientes.setModel(new DefaultTableModel(new Object[][] { colunasTabelaCliente, }, colunasTabelaCliente));
	}
}
