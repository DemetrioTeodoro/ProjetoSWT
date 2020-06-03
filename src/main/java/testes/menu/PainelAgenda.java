package testes.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

public class PainelAgenda extends JPanel {
	private TelaEditarOS telaEditarOS = null;
	private JTable tblAgenda;
	private String[] colunasTabelaAgenda = { " Nº Ordem Serviço ", " Profissional (contato) ", " Descrição do Serviço ",
			" Endereço ", " Cliente(contato) " };

	/**
	 * Create the panel.
	 */
	public PainelAgenda() {

		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblInicio = new JLabel("Data de In\u00EDcio (*)");

		JLabel lblTermino = new JLabel("Data de T\u00E9rmino (*)");

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
				telaEditarOS = new TelaEditarOS();
				telaEditarOS.setVisible(true);
				telaEditarOS.setLocationRelativeTo(null);
			}
		});

		DatePicker datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setText("");
		datePicker.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(PainelAgenda.class.getResource("/icones/calendar-icon.png")));

		DatePicker datePicker_1 = new DatePicker();
		datePicker_1.getComponentToggleCalendarButton().setText("");
		datePicker_1.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(PainelAgenda.class.getResource("/icones/calendar-icon.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(25).addComponent(lblNewLabel))
				.addGroup(groupLayout.createSequentialGroup().addGap(674)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGap(177).addComponent(btExportar))
				.addGroup(groupLayout.createSequentialGroup().addGap(21).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(datePicker,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTermino, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(datePicker_1,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNomeProf, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(cbProfissional,
								GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(126).addComponent(btnNewButton)))
						.addGap(12)
						.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(32).addComponent(lblNewLabel).addGap(15)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton_1)
								.addComponent(btExportar))
						.addGap(14)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblInicio).addGap(6)
										.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(lblTermino).addGap(13)
										.addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(24).addComponent(lblNomeProf).addGap(13)
										.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(56).addComponent(btnNewButton))
								.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 439,
										GroupLayout.PREFERRED_SIZE))));
		setLayout(groupLayout);

	}

	private void limparTabela() {
		tblAgenda.setModel(new DefaultTableModel(new Object[][] { colunasTabelaAgenda, }, colunasTabelaAgenda));
	}
}