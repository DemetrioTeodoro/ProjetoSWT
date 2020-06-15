package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.CategoriaController;
import controller.ClienteController;
import controller.OrdemServicoController;
import controller.ProfissionalController;
import helpers.Estados;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.OrdemServico;
import model.entity.Profissional;

public class PainelCadastroOS extends JPanel {
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	private String descricao;
	private Date dataAtual = new Date();
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextArea txtDescricao;
	private TelaPDF telaPDF = new TelaPDF();
	private JLabel lblGeradorNumero;
	private ClienteController clienteController = new ClienteController();
	private CategoriaController categoriaController = new CategoriaController();
	private OrdemServicoController ordemServicoController = new OrdemServicoController();
	private ProfissionalController profissionalController = new ProfissionalController();
	private ArrayList<Profissional> profissionais;
	private ArrayList<Categoria> categorias;
	private ArrayList<Cliente> clientes;
	private JComboBox cbCategoria;
	private JComboBox cbCliente;
	private JComboBox cbProfissional;
	private JTextField txtCidade;
	private JComboBox cbEstados;

	/**
	 * Create the panel.
	 */
	public PainelCadastroOS() {

		JLabel lblNumeroOS = new JLabel("N\u00B0 Odem de Servi\u00E7o:");

		MaskFormatter formatoOrdemServico;

		String ano = new SimpleDateFormat("/yyyy").format(dataAtual);
		JLabel label = new JLabel(ano);

		JLabel lblCliente = new JLabel("Cliente:");
		
		clientes = clienteController.listarClientes();
		cbCliente = new JComboBox(clientes.toArray());

		JCheckBox chckbxMesmoEnderecoDo = new JCheckBox("Mesmo endere\u00E7o do Cliente");

		JLabel lblRua = new JLabel("Rua:");

		txtRua = new JTextField();
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero");

		txtNumero = new JTextField();
		txtNumero.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");

		MaskFormatter formatoCep;

		try {
			formatoCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(formatoCep);
			txtCep.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblBairro = new JLabel("Bairro:");

		txtBairro = new JTextField();
		txtBairro.setColumns(10);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");

		txtDescricao = new JTextArea();

		JLabel lblDataInicial = new JLabel("Data Inicial:");

		JLabel lblDataPrevistaTermino = new JLabel("Data Prevista Termino:");

		final DatePicker dateInicial = new DatePicker();
		dateInicial.getComponentToggleCalendarButton().setText("");
		dateInicial.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelCadastroOS.class.getResource("/icones/calendar-icon.png")));

		final DatePicker datePrevistaFinal = new DatePicker();
		datePrevistaFinal.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelCadastroOS.class.getResource("/icones/calendar-icon.png")));
		datePrevistaFinal.getComponentToggleCalendarButton().setText("");

		Estados estado = new Estados();
		ArrayList<String> estados = (ArrayList<String>) estado.consultarEstados();
		cbEstados = new JComboBox(estados.toArray());
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");

		categorias = categoriaController.listarCategorias();
		cbCategoria = new JComboBox(categorias.toArray());

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComboProfissionalPorCategoria cbProf = new ComboProfissionalPorCategoria();
				int idCategoria = cbCategoria.getSelectedIndex();
				cbProf.getDados(idCategoria);
				cbProf.setVisible(true);
			}
		});
		btnAdd.setIcon(new ImageIcon(PainelCadastroOS.class.getResource("/icones/Button-Add-icon.png")));

		JLabel lblProfissionais = new JLabel("Profissionais:");

		profissionais = profissionalController.listarProfissionais();
		cbProfissional = new JComboBox(profissionais.toArray());

		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				//String numeroOS = lblGeradorNumero.getText();
				Cliente cliente = new Cliente();
				
				cliente = (Cliente) cbCliente.getSelectedItem();
				
				/*if (chckbxMesmoEnderecoDo.isSelected()) {
					//TODO
				} else {
					cep = txtCep.getText();
					bairro = txtBairro.getText();
					rua = txtRua.getText();
					numero = txtNumero.getText();
				}*/
		
					descricao = txtDescricao.getText();
				
				LocalDate dataInicial = dateInicial.getDate();
				LocalDate dataPrevistaFinal = datePrevistaFinal.getDate();
				String cep = txtCep.getText();
				String bairro = txtBairro.getText();
				String rua = txtRua.getText();
				String numero = txtNumero.getText();
				Categoria categoria = (Categoria) cbCategoria.getSelectedItem();
				Profissional profissional = (Profissional) cbProfissional.getSelectedItem();
				ArrayList<Profissional> pros = new ArrayList<Profissional>();
				//TODO Validação
				pros.add(profissional);
				Endereco endereco = new Endereco();
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				endereco.setRua(rua);
				endereco.setNumero(numero);
				endereco.setEstado("SC");
				endereco.setCidade("Floripa");
				/*Profissional p = new Profissional();
				p.setNome("Arnaldo dos testes");
				p.setInscricao("12121451352");
				p.setTelefone("995874526");
				p.setEmail("testes@gmail.com");
				p.setDataCadastro(dataInicial);
				p.setCategorias(categorias);
				p.setDataCadastro(dataInicial);
				p.setEndereco(endereco);
				p.setAtivo(true);
				System.out.println(endereco);
				System.out.println(p);
				cliente.setNome("Arnaldo dos Testes");
				cliente.setInscricao("5228");
				cliente.setEhCpf(true);
				cliente.setAtivo(true);
				cliente.isAtivo();
				cliente.isEhCpf();
				cliente.setDataCadastro(dateInicial.getDate());
				cliente.setTelefone("665894455");
				cliente.setEmail("testando@gmail.com");
				cliente.setEndereco(endereco);*/
				System.out.println(cliente);
				
				/*Profissional p2 = new Profissional();
				p2.setNome("Arnaldo dos testes2");
				p2.setInscricao("2222222222");
				p2.setTelefone("995874524");
				p2.setEmail("testes@gmail.com");
				p2.setDataCadastro(dataInicial);
				p2.setCategorias(categorias);
				p2.setDataCadastro(dataInicial);
				p2.setEndereco(endereco);
				p2.setAtivo(true);
				pros.add(p);
				pros.add(p2);*/

				OrdemServico os = new OrdemServico();
				//os.setId(1);
				os.setNumeroOS("1");
				os.setCategorias(categorias);
				os.setCliente(cliente);
				os.setDataInicio(dateInicial.getDate());
				os.setDataPrevistaFim(dateInicial.getDate());
				os.setDescricao(descricao);
				os.setEndereco(endereco);
				os.setProfissionais(pros);
				os.setDataTermino(dateInicial.getDate());
				System.out.println(os);
				String msg= ordemServicoController.cadastrarOS(os);
				JOptionPane.showMessageDialog(null, msg);
				/*telaPDF.getDados(numeroOS, cliente, descricao, dataInicial, dataPrevistaFinal, categoria, profissional,endereco);
				
				telaPDF.setVisible(true);
				telaPDF.setLocationRelativeTo(null);*/
			}
		});

		JLabel lblCadastroOrdemDeServio = new JLabel("Cadastro Ordem de Servi\u00E7o");
		lblCadastroOrdemDeServio.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnLimpar = new JButton("Limpar");
		
		lblGeradorNumero = new JLabel("GeradorNumero");
		lblGeradorNumero.setEnabled(false);
		
		JCheckBox chckbxFinalizada = new JCheckBox("Finalizada");
		
		JLabel lblEstado = new JLabel("Estado:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCadastroOrdemDeServio))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNumeroOS)
					.addGap(7)
					.addComponent(lblGeradorNumero)
					.addGap(7)
					.addComponent(label)
					.addGap(227)
					.addComponent(chckbxFinalizada, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCliente)
					.addGap(5)
					.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblEndereo))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(chckbxMesmoEnderecoDo))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblCep)
					.addGap(5)
					.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(cbEstados, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblRua)
					.addGap(5)
					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblBairro)
					.addGap(5)
					.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(lblNumero)
					.addGap(12)
					.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblDescricao)
					.addGap(12)
					.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblDataInicial)
					.addGap(5)
					.addComponent(dateInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(140)
							.addComponent(datePrevistaFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDataPrevistaTermino, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCategoria)
					.addGap(12)
					.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblProfissionais)
					.addGap(5)
					.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAdd))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(249)
					.addComponent(btnVisualizar))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblCadastroOrdemDeServio)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNumeroOS))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblGeradorNumero))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(label))
						.addComponent(chckbxFinalizada))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCliente))
						.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblEndereo)
					.addGap(11)
					.addComponent(chckbxMesmoEnderecoDo)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCep))
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado))
						.addComponent(cbEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCidade)))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRua))
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBairro))
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumero))
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDescricao))
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblDataInicial))
						.addComponent(dateInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(datePrevistaFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(lblDataPrevistaTermino)))))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblCategoria))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblProfissionais))
						.addComponent(cbProfissional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLimpar)
						.addComponent(btnVisualizar)))
		);
		setLayout(groupLayout);
		

	}
}
