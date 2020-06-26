package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.CategoriaController;
import controller.ProfissionalController;
import helpers.Estados;
import model.entity.Categoria;
import model.entity.Endereco;
import model.entity.Profissional;

public class TelaEditProfissional extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JRadioButton rdbAtivar;
	private JComboBox<Categoria> cbCategoria;
	private JComboBox<String> cbEstado;
	private JButton btnLimpar;
	private JTextArea txtArea;

	private ArrayList<Categoria> categorias;
	private Endereco endereco = new Endereco();
	private ProfissionalController profissionalController = new ProfissionalController();
	private Profissional profissional = new Profissional();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditProfissional frame = new TelaEditProfissional();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaEditProfissional() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			contentPane.setLayout(null);
			txtCpf = new JFormattedTextField(maskCpf);
			txtCpf.setBounds(90, 42, 109, 20);
			getContentPane().add(txtCpf);
			txtCpf.setColumns(10);
		} catch (ParseException e) {
			System.out.println("Erro ao tentar formatar CPF.");
			System.out.println("Causa: " + e.getMessage());
			e.printStackTrace();
		}

		JButton btnConsultarCpf = new JButton("Consultar");
		btnConsultarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profissional = null;
				String cpf = txtCpf.getText();
				String msg = profissionalController.validarTxtCpf(cpf);
				if (msg.isEmpty()) {
					profissional = profissionalController.buscarProfissionalPorCpf(cpf);
					popularTela(profissional);
				} else {
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		btnConsultarCpf.setBounds(209, 41, 89, 23);
		contentPane.add(btnConsultarCpf);

		txtNome = new JTextField();
		txtNome.setBounds(90, 73, 405, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		final JRadioButton rdbAtivar = new JRadioButton("Ativar");
		rdbAtivar.setBounds(361, 41, 109, 23);
		rdbAtivar.setSelected(true);
		getContentPane().add(rdbAtivar);

		txtRua = new JTextField();
		txtRua.setBounds(90, 160, 208, 20);
		getContentPane().add(txtRua);
		txtRua.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(415, 160, 80, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(373, 129, 122, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(90, 191, 109, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		Estados siglasEstados = new Estados();
		final JComboBox<String> cbEstado = new JComboBox(siglasEstados.consultarEstados().toArray());
		cbEstado.setBounds(432, 191, 63, 20);
		cbEstado.setSelectedIndex(-1);
		getContentPane().add(cbEstado);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(409, 268, 86, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(90, 268, 208, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		CategoriaController catControl = new CategoriaController();

		final JComboBox<Categoria> cbCategoria = new JComboBox(catControl.listarCategorias().toArray());
		cbCategoria.setBounds(214, 399, 131, 20);
		cbCategoria.setSelectedIndex(-1);
		getContentPane().add(cbCategoria);

		MaskFormatter maskCep;
		try {
			maskCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(maskCep);
			txtCep.setBounds(90, 129, 86, 20);
			getContentPane().add(txtCep);
			txtCep.setColumns(10);
		} catch (ParseException e) {
			System.out.println("Erro ao tentar formatar CEP(máscara).");
			System.out.println("Causa: " + e.getMessage());
			e.printStackTrace();
		}

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(21, 271, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblTel = new JLabel("Telefone :");
		lblTel.setBounds(334, 271, 62, 14);
		contentPane.add(lblTel);

		JLabel lblCategoria = new JLabel("Categoria (s) :");
		lblCategoria.setBounds(90, 402, 86, 14);
		contentPane.add(lblCategoria);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(21, 314, 145, 14);
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEspecialidade);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(21, 233, 145, 14);
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblContato);

		JLabel lblCidade = new JLabel("Cidade :");
		lblCidade.setBounds(21, 194, 46, 14);
		contentPane.add(lblCidade);

		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(21, 132, 46, 14);
		contentPane.add(lblCep);

		JLabel lblRua = new JLabel("Rua :");
		lblRua.setBounds(21, 163, 46, 14);
		contentPane.add(lblRua);

		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(370, 194, 46, 14);
		contentPane.add(lblEstado);

		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(321, 133, 50, 14);
		contentPane.add(lblBairro);

		JLabel lblNumero = new JLabel("N\u00FAmero : ");
		lblNumero.setBounds(347, 163, 60, 14);
		contentPane.add(lblNumero);

		JLabel lblEndereo = new JLabel("Endere\u00E7o\r\n");
		lblEndereo.setBounds(21, 104, 145, 14);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEndereo);

		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(30, 45, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(15, 76, 46, 14);
		contentPane.add(lblNome);

		JLabel lblTitulo = new JLabel("Edi\u00E7\u00E3o de Profissional");
		lblTitulo.setBounds(15, 11, 369, 14);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblTitulo);

		txtArea = new JTextArea();
		txtArea.setBounds(214, 353, 281, 23);
		txtArea.setEditable(false);
		contentPane.add(txtArea);

		JButton btnAddCategoria = new JButton("");
		btnAddCategoria.setBounds(350, 396, 28, 23);
		btnAddCategoria
				.setIcon(new ImageIcon(TelaEditProfissional.class.getResource("/icones/Button-Add-icon-24px.png")));
		contentPane.add(btnAddCategoria);

		btnAddCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoriaSelecionada = (Categoria) cbCategoria.getSelectedItem();
				int check = 0;

				for (int i = 0; i < categorias.size(); i++) {
					if (categoriaSelecionada.getId() != categorias.get(i).getId()) {
						check++;
						break;
					}
				}
				if (check > 0) {
					categorias.add(categoriaSelecionada);
					txtArea.setText(categorias.toString());
				} else {
					JOptionPane.showMessageDialog(null, "Categoria já foi adicionada anteriormente");
				}
				categoriaSelecionada = null;
				cbCategoria.setSelectedIndex(-1);
			}
		});

		JButton btnDelCategoria = new JButton("");
		btnDelCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoriaSelecionada = (Categoria) cbCategoria.getSelectedItem();
				int check = 0;

				for (int i = 0; i < categorias.size(); i++) {
					if (categoriaSelecionada.getId() == categorias.get(i).getId()) {
						categorias.remove(categorias.get(i));
						check = 1;
						txtArea.setText(categorias.toString());
					}
				}
				if (check == 0) {
					JOptionPane.showMessageDialog(null, "Categoria não pode ser excluída, pois não foi adicionada");
				}
				categoriaSelecionada = null;
				cbCategoria.setSelectedIndex(-1);
			}
		});

		btnDelCategoria.setIcon(new ImageIcon(TelaEditProfissional.class.getResource("/icones/delete-icon.png")));
		btnDelCategoria.setBounds(388, 396, 28, 23);
		contentPane.add(btnDelCategoria);

		JLabel lblCategoriasSelecionadas = new JLabel("Categoria(s) selecionada(s) :");
		lblCategoriasSelecionadas.setBounds(21, 358, 178, 14);
		contentPane.add(lblCategoriasSelecionadas);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(161, 474, 100, 23);
		getContentPane().add(btnSalvar);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfissionalController control = new ProfissionalController();
				String mensagem = control.atualizar(txtNome.getText(), txtCpf.getText(), rdbAtivar.isSelected(),
						txtEmail.getText(), txtTelefone.getText(), txtCep.getText(), txtRua.getText(),
						txtNumero.getText(), txtBairro.getText(), txtCidade.getText(),
						(String) cbEstado.getSelectedItem(), categorias);
				JOptionPane.showMessageDialog(null, mensagem);
				String sucesso = "Profissional (" + profissional.toString() + ") alterado com sucesso!";
				if (mensagem.contains(sucesso)) {
					limpar();

				}
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(324, 474, 100, 23);
		getContentPane().add(btnLimpar);

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});

		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.setBounds(196, 126, 102, 23);
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cep = txtCep.getText().trim().replace("-", "");
				if (cep != null && !cep.trim().isEmpty()) {
					endereco = profissionalController.buscarEnderecoPorCep(txtCep.getText());
					txtCidade.setText(endereco.getCidade().replace("Ã³", "ó").replace("Ã§", "ç"));
					txtBairro.setText(endereco.getBairro());
					txtRua.setText(endereco.getRua());
					cbEstado.setSelectedItem(endereco.getEstado());
				} else {
					String msg = " Digite o cep. ";
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		contentPane.add(btnBuscarCep);
	}

	private void popularTela(Profissional profissional) {
		this.categorias = new ArrayList<Categoria>();

		this.txtNome.setText(profissional.getNome());
		this.txtCep.setText(profissional.getEndereco().getCep());
		this.txtBairro.setText(profissional.getEndereco().getBairro());
		this.txtRua.setText(profissional.getEndereco().getRua());
		this.txtNumero.setText(profissional.getEndereco().getNumero());
		this.txtCidade.setText(profissional.getEndereco().getCidade());
		this.txtEmail.setText(profissional.getEmail());
		this.txtTelefone.setText(profissional.getTelefone());
		this.categorias = profissional.getCategorias();
		this.txtArea.setText(categorias.toString());
		this.cbEstado.setSelectedItem(profissional.getEndereco().getEstado());
	}

	private void limpar() {

		this.txtNome.setText("");
		this.txtCpf.setText("");
		this.txtCep.setText("");
		this.txtBairro.setText("");
		this.txtRua.setText("");
		this.txtNumero.setText("");
		this.txtCidade.setText("");
		this.txtEmail.setText("");
		this.txtTelefone.setText("");
		this.txtArea.setText("");
		this.profissional = null;

	}
}
