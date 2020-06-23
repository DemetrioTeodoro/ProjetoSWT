package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

import controller.ClienteController;
import controller.ProfissionalController;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Profissional;
import model.seletor.ClienteSeletor;
import model.seletor.ProfissionalSeletor;

import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class PainelListagemProfissionais extends JPanel {
	
	private TelaCadEditProfissional telaCadEditProfissional = new TelaCadEditProfissional();
	private JTextField txtNome;
	private JTextField txtQdeOS;
	private JTextField txtDataInicio;
	private JTextField txtDataTermino;
	private JTable tblProfissionais;
	private String[] colunasTabelaProfissionais = { " Profissional "," CPF " , " Telefone "," Categoria ", "Qde OS Exec."};
	private ArrayList<Profissional> profissionais;
	private ProfissionalController controller = new ProfissionalController();
	
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
		
		JLabel lblDataInicio = new JLabel("Data In\u00EDcio:");
		
		JLabel lblDataTermino = new JLabel("Data T\u00E9rmino:");
		final DatePicker DataInicio = new DatePicker();
		DataInicio.getComponentToggleCalendarButton().setText("");
		DataInicio.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(PainelCadastroOS.class.getResource("/icones/calendar-icon.png")));

		final DatePicker DataTermino = new DatePicker();
		DataTermino.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(PainelCadastroOS.class.getResource("/icones/calendar-icon.png")));
		DataTermino.getComponentToggleCalendarButton().setText("");
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfissionalSeletor seletor = new ProfissionalSeletor();
				seletor.setNome(txtNome.getText());
				seletor.setCategoria((Categoria) cbCategoria.getSelectedItem());
				seletor.setCidade((String) cbCidade.getSelectedItem());
				seletor.setDataInicio(DataInicio.getDate());
				seletor.setDataPrevTermino(DataTermino.getDate());
				seletor.setQdeOS(txtQdeOS.getText());
				profissionais = controller.listarProfissionaisPorSeletor(seletor);
				atualizarTabelaProfissionais();
			}
		});
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
									.addGap(116)
									.addComponent(btnConsultar))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(45)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(DataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDataInicio, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
									.addGap(66)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDataTermino, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(DataTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(65)
							.addComponent(tblProfissionais, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
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
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDataInicio)
								.addComponent(lblDataTermino))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(DataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(DataTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addComponent(btnConsultar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(tblProfissionais, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		setLayout(groupLayout);
		

	}
	
	private void atualizarTabelaProfissionais() {

		this.limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblProfissionais.getModel();
		
		for ( Profissional p : profissionais) {
			//" Profissional "," CPF " , " Telefone "," Cidade "," Categoria ", "Qde OS Exec."};
			
			String[] novaLinha = new String[6];
			novaLinha[0] = p.getNome();
			novaLinha[1] = p.getInscricao();
			novaLinha[2] = p.getTelefone();
			novaLinha[3] = p.getCategorias().toString();
		    novaLinha[4] = buscarQdeOS(p.getId());

			model.addRow(novaLinha);
		}
	}

	private String buscarQdeOS(int id) {
		int qde_os = 0;
		qde_os = controller.buscarQdeOS(id);
		 String qde= ""+qde_os;
		 
		 return qde;
	}

	private void limparTabela() {

		tblProfissionais.setModel(new DefaultTableModel(new Object[][] { colunasTabelaProfissionais, }, colunasTabelaProfissionais));
	}

}
