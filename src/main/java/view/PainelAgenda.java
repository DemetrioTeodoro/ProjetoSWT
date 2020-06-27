package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import controller.OrdemServicoController;
import controller.ProfissionalController;
import model.details.Agenda;
import model.entity.OrdemServico;
import model.entity.Profissional;
import model.seletor.AgendaSeletor;

import javax.swing.LayoutStyle.ComponentPlacement;

public class PainelAgenda extends JPanel {
	private TelaEditarOS telaEditarOS = null;
	private DatePicker dpInicio;
	private DatePicker dpFim;
	private ArrayList<Agenda> agendas;
	private JTable tblAgenda;
	private String[] colunasTabelaAgenda = { " Data de Início ", " Data Término Previsto ",
			"   Endereco (bairro - cidade/UF)   ", "Cliente (telefone)", "Número OS" };

	/**
	 * Create the panel.
	 */
	public PainelAgenda() {

		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblInicio = new JLabel("Data de In\u00EDcio (*)");

		JLabel lblTermino = new JLabel("Data de T\u00E9rmino (*)");

		dpInicio = new DatePicker();
		dpInicio.getComponentToggleCalendarButton().setText("");
		dpInicio.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(PainelAgenda.class.getResource("/icones/calendar-icon.png")));

		dpFim = new DatePicker();
		dpFim.getComponentToggleCalendarButton().setText("");
		dpFim.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(PainelAgenda.class.getResource("/icones/calendar-icon.png")));

		JLabel lblNomeProf = new JLabel("Nome Profissional (CPF) :");

		ProfissionalController pControl = new ProfissionalController();
		ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
		profissionais = pControl.listarProfissionais();
		JComboBox cbProfissional = new JComboBox(profissionais.toArray());
		cbProfissional.setSelectedIndex(-1);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendaSeletor seletor = new AgendaSeletor();
				seletor.setDataInicio(dpInicio.getDate());
				seletor.setDataTermino(dpFim.getDate());
				seletor.setProfissional((Profissional) cbProfissional.getSelectedItem());
				OrdemServicoController control = new OrdemServicoController();
				agendas = new ArrayList<Agenda>();
				agendas = control.listarOSAgenda(seletor);
				cbProfissional.setSelectedIndex(-1);
			}
		});

		tblAgenda = new JTable();
		tblAgenda.setCellSelectionEnabled(true);

		limparTabela();

		JButton btnVisualizar = new JButton("Visualizar OS");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaEditarOS = new TelaEditarOS();
				telaEditarOS.setVisible(true);
				telaEditarOS.setLocationRelativeTo(null);
			}
		});

		JButton btnExportar = new JButton("Exportar");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(25).addComponent(lblAgenda))
				.addGroup(groupLayout.createSequentialGroup().addGap(389)
						.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addGap(722)
						.addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(21).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(dpInicio,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTermino, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(dpFim,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNomeProf, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(cbProfissional,
								GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(126).addComponent(btnConsultar,
								GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
						.addGap(9)
						.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 962, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(32).addComponent(lblAgenda).addGap(15)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnVisualizar)
								.addComponent(btnExportar))
						.addGap(14)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblInicio).addGap(6)
										.addComponent(dpInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(lblTermino).addGap(13)
										.addComponent(dpFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(24).addComponent(lblNomeProf).addGap(13)
										.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(56).addComponent(btnConsultar))
								.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 520,
										GroupLayout.PREFERRED_SIZE))));
		setLayout(groupLayout);

	}

	private void limparTabela() {
		tblAgenda.setModel(new DefaultTableModel(new Object[][] { colunasTabelaAgenda, }, colunasTabelaAgenda));
	}
}