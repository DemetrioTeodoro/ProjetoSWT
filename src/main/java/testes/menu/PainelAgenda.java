package testes.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class PainelAgenda extends JPanel {
	private JTextField txtInicio;
	private JTextField txtTermino;
	private JTable tblAgenda;
	private String[] colunasTabelaAgenda = { " Nº Ordem Serviço ", " Profissional (contato) "," Descrição do Serviço " , " Endereço ", " Cliente(contato) "};
	

	/**
	 * Create the panel.
	 */
	public PainelAgenda() {
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblInicio = new JLabel("Data de In\u00EDcio (*)");
		
		JLabel lblTermino = new JLabel("Data de T\u00E9rmino (*)");
		
		txtInicio = new JTextField();
		txtInicio.setColumns(10);
		
		JButton btCalendarioInicio = new JButton("");
		btCalendarioInicio.setIcon(new ImageIcon(PainelAgenda.class.getResource("/icones/calendar-icon.png")));
		btCalendarioInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		txtTermino = new JTextField();
		txtTermino.setColumns(10);
		
		JButton btCalendarioTermino = new JButton("");
		btCalendarioTermino.setIcon(new ImageIcon(PainelAgenda.class.getResource("/icones/calendar-icon.png")));
				
		JLabel lblNomeProf = new JLabel("Nome Profissional (CPF) :");
		
		JComboBox cbProfissional = new JComboBox();
		
		JButton btExportar = new JButton("Exportar");
		
		JButton btnNewButton = new JButton("Consultar");
		
		tblAgenda = new JTable();
		tblAgenda.setCellSelectionEnabled(true);
		
		limparTabela();
		
		JButton btnNewButton_1 = new JButton("Visualizar OS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(105)
					.addComponent(lblTermino, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(324)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(177)
					.addComponent(btExportar))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btCalendarioInicio, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(77)
							.addComponent(txtTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(btCalendarioTermino, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNomeProf, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(btnNewButton)))
					.addGap(6)
					.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblInicio))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTermino))
						.addComponent(btnNewButton_1)
						.addComponent(btExportar))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btCalendarioInicio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btCalendarioTermino, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblNomeProf)
							.addGap(6)
							.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE))))
		);
		setLayout(groupLayout);

	}


	private void limparTabela() {
		tblAgenda.setModel(new DefaultTableModel(new Object[][] { colunasTabelaAgenda, }, colunasTabelaAgenda));
	}
}