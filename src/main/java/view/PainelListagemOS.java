package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.CategoriaController;
import controller.ClienteController;
import controller.OrdemServicoController;
import controller.ProfissionalController;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.OrdemServico;
import model.entity.Profissional;
import model.seletor.OrdemServicoSeletor;

public class PainelListagemOS extends JPanel {
	private TelaEditarOS telaEditarOS = null;
	private JTable tblOrdemServico;
	private String[] colunasTabelaOS = { "Número da Ordem", "Nome do Cliente", "Nome do Profissional", "Categoria" };
	private JTextField txtNumeroOS;
	private ClienteController clienteController = new ClienteController();
	private CategoriaController categoriaController = new CategoriaController();
	private OrdemServicoController ordemServicoController = new OrdemServicoController();
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<OrdemServico> ordemServicos = new ArrayList<OrdemServico>();
	private JComboBox cbCategoria;
	private JComboBox cbCliente;

	/**
	 * Create the panel.
	 */
	public PainelListagemOS() {

		JLabel lblConsultaDeOrdens = new JLabel("Consulta de Ordem de Servi\u00E7o");
		lblConsultaDeOrdens.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNomeCliente = new JLabel("Nome do Cliente:");

		JLabel lblCategoria = new JLabel("Categoria:");

		categorias = categoriaController.listarCategorias();
		cbCategoria = new JComboBox(categorias.toArray());

		JLabel lblNumeroOS = new JLabel("N\u00FAmero da OS:");

		clientes = clienteController.listarClientes();
		cbCliente = new JComboBox(clientes.toArray());

		tblOrdemServico = new JTable();

		limparTabela();

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrdemServicoSeletor seletor = new OrdemServicoSeletor();
				String numeroOS = txtNumeroOS.getText();
				Categoria categoria = (Categoria) cbCategoria.getSelectedItem();
				Cliente cliente = (Cliente) cbCliente.getSelectedItem();
				seletor.setCatgoria(categoria);
				seletor.setCliente(cliente);
				seletor.setNumeroOS(numeroOS);

				ordemServicos = ordemServicoController.listarClientes(seletor);
				atualizarTabelaOS();
			}
		});

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		txtNumeroOS = new JTextField();
		txtNumeroOS.setColumns(10);

		JButton btnEditarOs = new JButton("Visualizar OS");
		btnEditarOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaEditarOS = new TelaEditarOS();
				telaEditarOS.setVisible(true);
				telaEditarOS.setLocationRelativeTo(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(lblConsultaDeOrdens,
						GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(59)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNomeCliente)
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(cbCliente,
										GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCategoria)
								.addGroup(groupLayout.createSequentialGroup().addGap(11).addComponent(cbCategoria,
										GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNumeroOS, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(11).addComponent(txtNumeroOS,
										GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(72).addComponent(btnConsultar,
										GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
						.addGap(93)
						.addComponent(tblOrdemServico, GroupLayout.PREFERRED_SIZE, 818, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup().addGap(477)
						.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE).addGap(236)
						.addComponent(btnEditarOs, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(13)
						.addComponent(lblConsultaDeOrdens, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addGap(72)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNomeCliente).addGap(25)
										.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20).addComponent(lblCategoria).addGap(13)
										.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(30).addComponent(lblNumeroOS).addGap(13)
										.addComponent(txtNumeroOS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(33).addComponent(btnConsultar))
								.addGroup(groupLayout.createSequentialGroup().addGap(14).addComponent(tblOrdemServico,
										GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)))
						.addGap(50).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnFechar)
								.addComponent(btnEditarOs))));
		setLayout(groupLayout);

	}

	protected void atualizarTabelaOS() {

		limparTabela();

		DefaultTableModel model = (DefaultTableModel) tblOrdemServico.getModel();
		for (OrdemServico os : ordemServicos) {
			System.out.println(ordemServicos);
			String[] novaLinha = new String[7];
			novaLinha[0] = os.getNumeroOS();
			novaLinha[1] = os.getCliente().getNome();
			novaLinha[2] = os.getProfissionais().toString();
			novaLinha[3] = os.getCategorias().toString();


			model.addRow(novaLinha);
		}
	}

	private void limparTabela() {

		tblOrdemServico.setModel(new DefaultTableModel(new Object[][] { colunasTabelaOS, }, colunasTabelaOS));
	}
}
