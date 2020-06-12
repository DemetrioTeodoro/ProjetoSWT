package testes.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class PainelListagemProfissionais extends JPanel {
	
	private TelaCadEditProfissionalx telaCadEditProfissional = new TelaCadEditProfissionalx();
	private JTextField txtNome;
	private JTextField txtQdeOS;
	private JTextField txtDataInicio;
	private JTextField txtDataTermino;
	private JTable tblProfissionais;
	private String[] colunasTabelaProfissionais = { " Profissional "," CPF " , " Telefone "," Cidade "," Categoria ", "Qde OS Exec."};
	

	/**
	 * Create the panel.
	 */
	public PainelListagemProfissionais() {
		
		JButton btAdicionar = new JButton("Adicionar Profissional");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadEditProfissional.setVisible(true);
				telaCadEditProfissional.setLocationRelativeTo(null);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Profissionais Cadastrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNome = new JLabel("Nome :");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria :");
		
		JComboBox cbCategoria = new JComboBox();
		
		JLabel lblCidade = new JLabel("Cidade :");
		
		JLabel lblQdeOS = new JLabel("Quantidade de Ordem de Servi\u00E7os Executadas:");
		
		JComboBox cbCidade = new JComboBox();
		
		txtQdeOS = new JTextField();
		txtQdeOS.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("Dispon\u00EDvel no Per\u00EDodo :");
		
		JLabel lblDataInicio = new JLabel("Data In\u00EDcio");
		
		JLabel lblDataTermino = new JLabel("Data T\u00E9rmino");
		
		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);
		
		txtDataTermino = new JTextField();
		txtDataTermino.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDataInicio = new JButton("");
		btnDataInicio.setIcon(new ImageIcon(PainelListagemProfissionais.class.getResource("/icones/calendar-icon.png")));
		btnDataInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDataTermino = new JButton("");
		btnDataTermino.setIcon(new ImageIcon(PainelListagemProfissionais.class.getResource("/icones/calendar-icon.png")));
		
		tblProfissionais = new JTable();
		limparTabela();
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadEditProfissional.setVisible(true);
				telaCadEditProfissional.setLocationRelativeTo(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addGap(258)
					.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(211)
					.addComponent(btAdicionar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNome)
							.addGap(29)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCategoria)
							.addGap(9)
							.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCidade)
							.addGap(23)
							.addComponent(cbCidade, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQdeOS)
							.addGap(12)
							.addComponent(txtQdeOS, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPeriodo)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(lblDataInicio, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(lblDataTermino, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btnDataInicio, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(txtDataTermino, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btnDataTermino, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(116)
							.addComponent(btnConsultar)))
					.addGap(65)
					.addComponent(tblProfissionais, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel))
						.addComponent(btnVisualizar)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(btAdicionar)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNome))
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblCategoria))
								.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblCidade))
								.addComponent(cbCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblQdeOS))
								.addComponent(txtQdeOS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblPeriodo)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataInicio)
								.addComponent(lblDataTermino))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(txtDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnDataInicio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(txtDataTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(btnDataTermino, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
							.addGap(44)
							.addComponent(btnConsultar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(tblProfissionais, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE))))
		);
		setLayout(groupLayout);
		

	}



	private void limparTabela() {
		tblProfissionais.setModel(new DefaultTableModel(new Object[][] { colunasTabelaProfissionais, }, colunasTabelaProfissionais));
		
	}
}
