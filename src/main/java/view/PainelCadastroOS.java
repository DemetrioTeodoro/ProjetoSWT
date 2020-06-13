package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.github.lgooddatepicker.components.DatePicker;

import controller.CategoriaController;
import controller.ClienteController;
import controller.OrdemServicoController;
import controller.ProfissionalController;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.OrdemServico;
import model.entity.Profissional;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PainelCadastroOS extends JPanel {
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtDescricao;
	private ClienteController clienteController = new ClienteController();
	private CategoriaController categoriaController = new CategoriaController();
	private OrdemServicoController ordemServicoController = new OrdemServicoController();
	private ProfissionalController profissionalController = new ProfissionalController();
	private ArrayList<Profissional> profissionais;
	private ArrayList<Categoria> categorias;
	private ArrayList<Cliente> clientes;
	private JComboBox cbCategoria;
	private JComboBox cbProfissional;
	private JComboBox cbCliente;

	/**
	 * Create the panel.
	 */
	public PainelCadastroOS() {
		setLayout(null);
		
		txtCep = new JTextField();
		txtCep.setBounds(69, 194, 116, 22);
		add(txtCep);
		txtCep.setColumns(10);
		
		clientes = clienteController.listarClientes();
		cbCliente = new JComboBox(clientes.toArray());
		cbCliente.setBounds(72, 117, 183, 22);
		add(cbCliente);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(314, 194, 116, 22);
		add(txtBairro);
		txtBairro.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setBounds(69, 303, 116, 22);
		add(txtRua);
		txtRua.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(324, 303, 116, 22);
		add(txtNumero);
		txtNumero.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(139, 390, 116, 22);
		add(txtDescricao);
		txtDescricao.setColumns(10);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(92, 464, 187, 22);
		add(datePicker);
		
		DatePicker datePicker_1 = new DatePicker();
		datePicker_1.setBounds(341, 464, 187, 22);
		add(datePicker_1);
		
		categorias = categoriaController.listarCategorias();
		cbCategoria = new JComboBox(categorias.toArray());
		cbCategoria.setBounds(108, 545, 147, 22);
		add(cbCategoria);
		
		profissionais = profissionalController.listarProfissionais();
		cbProfissional = new JComboBox(profissionais.toArray());
		cbProfissional.setBounds(353, 545, 147, 22);
		add(cbProfissional);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
					String descricao = txtDescricao.getText();
				
				LocalDate dataInicial = datePicker.getDate();
				LocalDate dataPrevistaFinal = datePicker_1.getDate();
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
				os.setDataInicio(dataInicial);
				os.setDataPrevistaFim(dataPrevistaFinal);
				os.setDescricao(descricao);
				os.setEndereco(endereco);
				os.setProfissionais(pros);
				os.setDataTermino(dataInicial);
				System.out.println(os);
				String msg= ordemServicoController.cadastrarOS(os);
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnSalvar.setBounds(608, 544, 97, 25);
		add(btnSalvar);

	}
}
