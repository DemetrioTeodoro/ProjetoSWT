package testes.menu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelListagemOS extends JPanel {
	private JTable tblOrdemServico;
	private String[] colunasTabelaOS = { "Número da Ordem", "Nome do Cliente","Cliente Ativo" , "Nome do Profissional", "Categoria"};

	/**
	 * Create the panel.
	 */
	public PainelListagemOS() {

		JLabel lblListagemDeOrdens = new JLabel("Listagem de Ordens de Servi\u00E7o");
		lblListagemDeOrdens.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblCliente = new JLabel("Cliente:");

		JComboBox cbCliente = new JComboBox();

		JLabel lblProfissional = new JLabel("Profissional:");

		JComboBox cbProfissional = new JComboBox();

		JLabel lblCategoria = new JLabel("Categoria:");

		JComboBox cbCategoria = new JComboBox();
		

		tblOrdemServico = new JTable();

		limparTabela();
	
		JButton btnConsultar = new JButton("Consultar");

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(lblListagemDeOrdens,
						GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
						.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE).addGap(86)
						.addComponent(lblProfissional).addGap(12)
						.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGap(62)
						.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(tblOrdemServico, GroupLayout.PREFERRED_SIZE,
						818, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(251)
						.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE).addGap(304)
						.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(13)
						.addComponent(lblListagemDeOrdens, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGap(36)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblCliente))
								.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblProfissional))
								.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblCategoria))
								.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(49).addComponent(tblOrdemServico, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
						.addGap(46).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnFechar)
								.addComponent(btnConsultar))));
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
