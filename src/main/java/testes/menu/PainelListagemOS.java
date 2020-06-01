package testes.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PainelListagemOS extends JPanel {
	private TelaEditarOS telaEditarOS = null;
	private JTable tblOrdemServico;
	private String[] colunasTabelaOS = { "Número da Ordem", "Nome do Cliente", "Nome do Profissional", "Categoria" };
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PainelListagemOS() {

		JLabel lblListagemDeOrdens = new JLabel("Listagem de Ordens de Servi\u00E7o");
		lblListagemDeOrdens.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNomeCliente = new JLabel("Nome do cliente:");

		JLabel lblCategoria = new JLabel("Categoria:");

		JComboBox cbProfissional = new JComboBox();

		JLabel lblNumeroOS = new JLabel("N\u00FAmero do OS:");

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

		JButton btnEditarOs = new JButton("Editar OS");
		btnEditarOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (telaEditarOS == null) {
					telaEditarOS = new TelaEditarOS();
					telaEditarOS.setVisible(true);
					telaEditarOS.setLocationRelativeTo(null);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblListagemDeOrdens, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(btnEditarOs, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblListagemDeOrdens, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNomeCliente)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblCategoria)
							.addGap(13)
							.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(btnFechar)
						.addComponent(btnEditarOs)))
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
