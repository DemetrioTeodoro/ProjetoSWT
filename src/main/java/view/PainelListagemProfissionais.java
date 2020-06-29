package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.CDATASection;

import com.github.lgooddatepicker.components.DatePicker;

import controller.CategoriaController;
import controller.ClienteController;
import controller.ProfissionalController;
import helpers.JTextFieldSomenteNumeros;
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
	private TelaEditProfissional telaEditProfissional = new TelaEditProfissional();
	private JTextField txtNome;
	private JTextFieldSomenteNumeros txtQdeOS;
	private JComboBox<Categoria> cbCategoria;
	private JTable tblProfissionais;
	private String[] colunasTabelaProfissionais = { " Profissional "," CPF " , " Telefone "," Categoria ", "Qde OS Exec."};
	private ArrayList<Profissional> profissionais;
	private ProfissionalController controller = new ProfissionalController();
	
	/**
	 * Create the panel.
	 */
	public PainelListagemProfissionais() {
		
		JButton btAdicionar = new JButton("Cadastrar");
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
		
		CategoriaController catControl = new CategoriaController();
		JComboBox<Categoria> cbCategoria = new JComboBox(catControl.listarCategorias().toArray());
		cbCategoria.setSelectedIndex(-1);
		
		JLabel lblCidade = new JLabel("Cidade :");
		
		JLabel lblQdeOS = new JLabel("Quantidade de ordens de serviço vinculadas:");
		
		ArrayList<String>cidades = controller.buscarCidades();
		JComboBox cbCidade = new JComboBox(cidades.toArray());
		cbCidade.setSelectedIndex(-1);
		
		txtQdeOS = new JTextFieldSomenteNumeros();
		txtQdeOS.setColumns(10);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfissionalSeletor seletor = new ProfissionalSeletor();
				seletor.setNome(txtNome.getText());
				seletor.setCategoria((Categoria) cbCategoria.getSelectedItem());
				seletor.setCidade((String) cbCidade.getSelectedItem());
				seletor.setQdeOS(txtQdeOS.getText());
				profissionais = controller.listarProfissionaisPorSeletor(seletor);
				atualizarTabelaProfissionais();
				if(profissionais.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum resultado para esta consulta.");
				}
				cbCategoria.setSelectedIndex(-1);
				cbCidade.setSelectedIndex(-1);
				txtNome.setText("");
				txtQdeOS.setText("");
			}
		});
		
		tblProfissionais = new JTable();
		limparTabela();
		
		JButton btnVisualizar = new JButton("Editar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaEditProfissional.setVisible(true);
				telaEditProfissional.setLocationRelativeTo(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
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
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addGap(51)
					.addComponent(tblProfissionais, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addGap(234)
					.addComponent(btnVisualizar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
					.addComponent(btAdicionar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnVisualizar)
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
							.addGap(48)
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

	private String buscarQdeOS(int idprofissional) {
		int qde_os = 0;
		 String qde= "";
		try {
		qde_os = controller.buscarQdeOS(idprofissional);
		qde= ""+qde_os;
		}catch (Exception e) {
			System.out.println("Qde_OS = 0"+ e.getMessage());
			qde = "0";
		}
		 return qde;
	}

	private void limparTabela() {

		tblProfissionais.setModel(new DefaultTableModel(new Object[][] { colunasTabelaProfissionais, }, colunasTabelaProfissionais));
	}

}
