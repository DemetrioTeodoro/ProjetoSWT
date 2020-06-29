package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
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

public class TelaEditarOS extends JFrame {

	private JPanel contentPane;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	
	private ClienteController clienteController = new ClienteController();
	private CategoriaController categoriaController = new CategoriaController();
	private OrdemServicoController ordemServicoController = new OrdemServicoController();
	private ProfissionalController profissionalController = new ProfissionalController();

	private ArrayList<Profissional> profissionais = new ArrayList<Profissional>();
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Profissional> profsxCategoria = new ArrayList<Profissional>();
	private ArrayList<OrdemServico> ordemServicos = new ArrayList<OrdemServico>();
	private JComboBox cbCliente;
	private JComboBox cbCategoria;
	private JComboBox cbProfissional;
	private JTextField txtCidade;
	private JComboBox cbEstados;
	private JCheckBox chckbxFinalizada;
	private JTextField txtNumeroOS;
	private JComboBox cbOrdemServico;
	private JTextArea txtArea;
	private DatePicker datePicker;
	private DatePicker datePicker_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarOS frame = new TelaEditarOS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaEditarOS() {
		setTitle("Edi\u00E7\u00E3o da Ordem de Servi\u00E7o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumOrdemServico = new JLabel("N\u00B0 Odem de Servi\u00E7o:");
		lblNumOrdemServico.setBounds(70, 84, 121, 16);
		contentPane.add(lblNumOrdemServico);

		JLabel lblAno = new JLabel("/2020");
		lblAno.setBounds(296, 84, 33, 16);
		contentPane.add(lblAno);

		chckbxFinalizada = new JCheckBox("Servi\u00E7o Finalizado");
		chckbxFinalizada.setBounds(526, 80, 143, 25);
		contentPane.add(chckbxFinalizada);

		JLabel lblEdicaoDaOrdem = new JLabel("Edi\u00E7\u00E3o da Ordem de Servi\u00E7o");
		lblEdicaoDaOrdem.setBounds(33, 13, 217, 16);
		lblEdicaoDaOrdem.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblEdicaoDaOrdem);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(70, 128, 44, 16);
		contentPane.add(lblCliente);

		clientes = clienteController.listarClientes();
		cbCliente = new JComboBox(clientes.toArray());
		cbCliente.setBounds(119, 125, 550, 22);
		contentPane.add(cbCliente);
		cbCliente.setSelectedIndex(-1);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(70, 156, 56, 15);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEndereco);

		JCheckBox chckbxMesmoEnderecoDo = new JCheckBox("Mesmo endere\u00E7o do Cliente");
		chckbxMesmoEnderecoDo.setBounds(73, 180, 187, 25);
		contentPane.add(chckbxMesmoEnderecoDo);
		
		chckbxMesmoEnderecoDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbCliente.getSelectedIndex() < 0) {
					JOptionPane.showMessageDialog(null, "Favor informe um cliente.");
				} else {
					Endereco end = null;
					try {
						end = clienteController.consultarEnderecoCliente((Cliente) cbCliente.getSelectedItem());

					} catch (Exception er) {
						System.out.println("Erro ao buscar endereço pelo Cliente. Causa: " + er.getMessage());
					}

					if (end != null) {
						txtRua.setText(end.getRua());
						txtNumero.setText(end.getNumero());
						txtBairro.setText(end.getBairro());
						txtCidade.setText(end.getCidade());
						txtCep.setText(end.getCep());
						cbEstados.setSelectedItem(end.getEstado());
					}
				}
			}
		});
		
		MaskFormatter formatoCep;

		try {
			formatoCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(formatoCep);
			txtCep.setBounds(143, 224, 98, 22);
			txtCep.setColumns(10);
			contentPane.add(txtCep);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(72, 227, 27, 16);
		contentPane.add(lblCEP);

		txtBairro = new JTextField();
		txtBairro.setBounds(405, 276, 104, 22);
		txtBairro.setColumns(10);
		contentPane.add(txtBairro);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(365, 279, 144, 16);
		contentPane.add(lblBairro);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(72, 279, 27, 16);
		contentPane.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(143, 276, 210, 22);
		txtRua.setColumns(10);
		contentPane.add(txtRua);

		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(521, 279, 56, 16);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(578, 276, 91, 22);
		txtNumero.setColumns(10);
		contentPane.add(txtNumero);

		txtArea = new JTextArea();
		txtArea.setBounds(143, 316, 526, 84);
		contentPane.add(txtArea);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(70, 319, 77, 16);
		contentPane.add(lblDescricao);

		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setBounds(70, 419, 68, 16);
		contentPane.add(lblDataInicial);

		datePicker = new DatePicker();
		datePicker.setBounds(143, 417, 187, 22);
		datePicker.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(TelaEditarOS.class.getResource("/icones/calendar-icon.png")));
		datePicker.getComponentToggleCalendarButton().setText("");
		contentPane.add(datePicker);

		JLabel lblDataTermino = new JLabel("Data Prevista Termino:");
		lblDataTermino.setBounds(349, 421, 130, 16);
		contentPane.add(lblDataTermino);

		datePicker_1 = new DatePicker();
		datePicker_1.setBounds(482, 419, 187, 22);
		datePicker_1.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(TelaEditarOS.class.getResource("/icones/calendar-icon.png")));
		datePicker_1.getComponentToggleCalendarButton().setText("");
		contentPane.add(datePicker_1);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(70, 484, 60, 16);
		contentPane.add(lblCategoria);
		
		ArrayList<Categoria> categoriasSelecionadas = new ArrayList<Categoria>();
		ArrayList<Profissional> profissionaisSelecionados = new ArrayList<Profissional>();

		categorias = categoriaController.listarCategorias();
		cbCategoria = new JComboBox(categorias.toArray());
		cbCategoria.setBounds(143, 481, 175, 22);
		contentPane.add(cbCategoria);
		cbCategoria.setSelectedIndex(-1);
		cbProfissional = new JComboBox<Profissional>();
		
		JLabel lblProfissional = new JLabel("Profissionais:");
		lblProfissional.setBounds(328, 481, 90, 16);
		contentPane.add(lblProfissional);

		cbProfissional = new JComboBox();
		cbProfissional.setBounds(430, 477, 187, 22);
		contentPane.add(cbProfissional);

		cbCategoria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbProfissional.removeAllItems();
				Categoria categoria = (Categoria) cbCategoria.getSelectedItem();
				if (!categoriasSelecionadas.contains(categoria)) {
					categoriasSelecionadas.add(categoria);
				}
				if (datePicker.getText().isEmpty() || datePicker_1.getText().isEmpty()
						|| datePicker.getDate().isAfter(datePicker_1.getDate())) {
					JOptionPane.showMessageDialog(null,
							"Antes da seleção do profissional, favor informar as datas de início e previsão de término, "+
					        "onde data de início deve ser menor que a data prevista para término");
				} else {

					try {
						profsxCategoria = profissionalController.listarProfissionaisPorCategoria(categoria.getId(),
								datePicker.getDate(), datePicker_1.getDate());
						if(profsxCategoria.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Nenhum profissional disponível para a categoria "+categoria+ " no período informado.");
						}

					} catch (Exception e2) {
						System.out.println(
								"Erro ao trazer dados para o combox profs x categoria."+
						" Causa: " + e2.getMessage());// acusa este erro mas combo é feito corretamente...
					}

					cbProfissional.addItem("SELECIONE PROFISSIONAL");
					for (int i = 0; i < profsxCategoria.size(); i++) {
						cbProfissional.addItem(profsxCategoria.get(i));
					}
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(198, 563, 83, 25);
		contentPane.add(btnLimpar);

		JButton btnConfirmarEdicao = new JButton("Confirmar Edi\u00E7\u00E3o");
		btnConfirmarEdicao.addActionListener(new ActionListener() {
			private OrdemServico cadOS = new OrdemServico();
			private OrdemServico os;

			public void actionPerformed(ActionEvent e) {
				os = (OrdemServico) cbOrdemServico.getSelectedItem();
				cadOS.setId(os.getId());
				cadOS.setNumeroOS(txtNumeroOS.getText() + lblAno.getText());
				cadOS.setCliente((Cliente) cbCliente.getSelectedItem());
				Endereco endereco = new Endereco(txtRua.getText(), txtNumero.getText(), txtBairro.getText(),
						txtCidade.getText(), (String) cbEstados.getSelectedItem(), txtCep.getText());
				cadOS.setEndereco(endereco);
				cadOS.setCategorias(categoriasSelecionadas);
				cadOS.setProfissionais(profissionaisSelecionados);
				cadOS.setDataInicio(datePicker.getDate());
				cadOS.setDataTermino(datePicker_1.getDate());
				cadOS.setDataPrevistaFim(datePicker_1.getDate());
				if (chckbxFinalizada.isSelected()) {
					Date dataAtual = new Date();
					cadOS.setDataTermino(LocalDate.parse(dataAtual.toString()));
				}
				cadOS.setDescricao(txtArea.getText());

				String msg = ordemServicoController.validarCamposAtualizar(cadOS);
				if (!msg.isEmpty()) {

					JOptionPane.showMessageDialog(null, msg);
					msg = "";
				} else {
					msg = ordemServicoController.atualizar(cadOS);
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		btnConfirmarEdicao.setBounds(459, 563, 158, 25);
		contentPane.add(btnConfirmarEdicao);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profissional profSelecionado = (Profissional) cbProfissional.getSelectedItem();
				if (profissionaisSelecionados.contains(profSelecionado)) {
					JOptionPane.showMessageDialog(null, "Profissional já foi selecionado");
				} else {
					profissionaisSelecionados.add(profSelecionado);

				}
			}
		});
		button_1.setBounds(620, 477, 49, 25);
		button_1.setIcon(new ImageIcon(TelaEditarOS.class.getResource("/icones/Button-Add-icon.png")));
		contentPane.add(button_1);
		
		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.addActionListener(new ActionListener() {
			private Endereco endereco;

			public void actionPerformed(ActionEvent e) {
				String cep = txtCep.getText().trim().replace("-", "");
				if (cep != null && !cep.trim().isEmpty()) {
					endereco = ordemServicoController.buscarEnderecoPorCep(txtCep.getText());
					txtCidade.setText(endereco.getCidade().replace("Ã³", "ó").replace("Ã§", "ç").replace("Ã­", "í"));
					txtBairro.setText(endereco.getBairro().replace("Ã³", "ó").replace("Ã§", "ç").replace("Ã­", "í"));
					txtRua.setText(endereco.getRua());
					cbEstados.setSelectedItem(endereco.getEstado());
				} else {
					String msg = " Digite o cep. ";
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		btnBuscarCep.setBounds(253, 223, 97, 25);
		contentPane.add(btnBuscarCep);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(362, 227, 56, 16);
		contentPane.add(lblEstado);
		
		Estados estados = new Estados();
		cbEstados = new JComboBox(estados.consultarEstados().toArray());
		cbEstados.setBounds(409, 224, 77, 22);
		contentPane.add(cbEstados);
		cbEstados.setSelectedIndex(-1);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(498, 227, 56, 16);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(548, 224, 121, 22);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		MaskFormatter formatoNumero;

		
		try {
			formatoNumero = new MaskFormatter("#####");
			txtNumeroOS = new JFormattedTextField(formatoNumero);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtNumeroOS.setBounds(202, 81, 91, 22);
		contentPane.add(txtNumeroOS);
		txtNumeroOS.setColumns(10);
		
		ordemServicos = ordemServicoController.listarTodos();
		cbOrdemServico = new JComboBox(ordemServicos.toArray());
		cbOrdemServico.setBounds(198, 46, 233, 22);
		contentPane.add(cbOrdemServico);
		
		JLabel lblOrdemDeServio = new JLabel("Ordem de Servi\u00E7o:");
		lblOrdemDeServio.setBounds(70, 42, 121, 29);
		contentPane.add(lblOrdemDeServio);
		
		JButton btnBuscar = new JButton("Buscar OS");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdemServico os = new OrdemServico();
				os = (OrdemServico) cbOrdemServico.getSelectedItem();
				
				txtNumeroOS.setText(os.getNumeroOS());
				txtArea.setText(os.getDescricao());
				txtBairro.setText(os.getEndereco().getBairro());
				txtCidade.setText(os.getEndereco().getCidade());
				txtRua.setText(os.getEndereco().getRua());
				txtNumero.setText(os.getEndereco().getNumero());
				txtCep.setText(os.getEndereco().getCep());
				cbEstados.setSelectedItem(os.getEndereco().getEstado());
				
				
			}
		});
		btnBuscar.setBounds(443, 45, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrdemServico os = (OrdemServico) cbOrdemServico.getSelectedItem();
				String msg = "";
				msg = ordemServicoController.excluir(os);
				
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnExcluir.setBounds(572, 46, 97, 25);
		contentPane.add(btnExcluir);
	}
}
