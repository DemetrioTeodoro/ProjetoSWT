package testes.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelListagemCliente extends JPanel {
	private JTable tblClientes;
	private String[] colunasTabelaCliente = { "Nome do Cliente", "CPF", "CNPJ", "Cliente Ativo" , "Telefone", "Endereço"};

	/**
	 * Create the panel.
	 */
	public PainelListagemCliente() {
		
		JLabel lblListagemClientes = new JLabel("Listagem de Clientes");
		lblListagemClientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblCPF = new JLabel("CPF:");
		
		JComboBox cbCPF = new JComboBox();
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		
		JComboBox cbCNPJ = new JComboBox();
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		
		JComboBox cbEndereco = new JComboBox();
		
		tblClientes = new JTable();
		
		limparTabela();
		
		JButton btnConsultar = new JButton("Consultar");
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblListagemClientes, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(cbCPF, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
					.addGap(93)
					.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(cbCNPJ, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(lblEndereco, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(cbEndereco, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(tblClientes, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(217)
					.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(314)
					.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblListagemClientes, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCPF))
						.addComponent(cbCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCnpj))
						.addComponent(cbCNPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEndereco))
						.addComponent(cbEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(tblClientes, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFechar)
						.addComponent(btnConsultar)))
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
