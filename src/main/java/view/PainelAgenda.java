package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

import controller.AgendaController;
import controller.ProfissionalController;
import model.details.Agenda;
import model.entity.Profissional;
import model.seletor.AgendaSeletor;

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
				String msg = "";
				AgendaController control = new AgendaController();
				msg = control.validarCamposObrigatorios(dpInicio.getDate(), dpFim.getDate());
				if (msg.isEmpty()) {
					AgendaSeletor seletor = new AgendaSeletor();
					seletor.setDataInicio(dpInicio.getDate());
					seletor.setDataTermino(dpFim.getDate());
					seletor.setProfissional((Profissional) cbProfissional.getSelectedItem());
					agendas = new ArrayList<Agenda>();
					agendas = control.listarOSAgenda(seletor);
					if (agendas.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nenhum resultado para esta consulta.");
					} else {
						atualizarTabelaAgenda();
					}
				} else {
					JOptionPane.showMessageDialog(null, msg);
				}
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

		JButton btnGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jcf = new JFileChooser();
				jcf.setDialogTitle("Salvar relatório como...");
				String msg = "";
				int resultado = jcf.showSaveDialog(null);
				if (resultado == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = jcf.getSelectedFile().getAbsolutePath();
					
					AgendaController agendaController = new AgendaController();
					msg = agendaController.gerarRelatorioAgenda(agendas, caminhoEscolhido);
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});

		JLabel lblPeriodo = new JLabel("Per\u00EDodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dpInicio.clear();
				dpFim.clear();
				cbProfissional.setSelectedIndex(-1);
				limparTabela();
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblAgenda))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPeriodo)
							.addGap(322)
							.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(722)
							.addComponent(btnGerarRelatorio, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(dpInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTermino, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(dpFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNomeProf, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(126)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnLimpar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnConsultar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
							.addGap(9)
							.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 962, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblAgenda)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVisualizar)
								.addComponent(btnGerarRelatorio))
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPeriodo)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInicio)
							.addGap(6)
							.addComponent(dpInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(lblTermino)
							.addGap(13)
							.addComponent(dpFim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(lblNomeProf)
							.addGap(13)
							.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnConsultar)
							.addGap(30)
							.addComponent(btnLimpar))
						.addComponent(tblAgenda, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

	}

	private void atualizarTabelaAgenda() {

		this.limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblAgenda.getModel();

		for (Agenda a : agendas) {

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");

			String[] novaLinha = new String[6];
			novaLinha[0] = a.getInicio().format(formatador);
			novaLinha[1] = a.getFim().format(formatador);
			novaLinha[2] = a.TextoEndereco();
			novaLinha[3] = a.TextoCliente();
			novaLinha[4] = a.getNumOS();

			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {
		tblAgenda.setModel(new DefaultTableModel(new Object[][] { colunasTabelaAgenda, }, colunasTabelaAgenda));
	}
}