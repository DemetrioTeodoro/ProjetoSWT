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

public class TelaCadEditProfissional extends JFrame {

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
	private ArrayList<Categoria> categorias;
	private Endereco endereco = new Endereco();
	private JTextArea txtArea;
	private ProfissionalController profissionalController = new ProfissionalController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadEditProfissional frame = new TelaCadEditProfissional();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadEditProfissional() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(maskCpf);
			txtCpf.setBounds(90, 42, 109, 20);
			getContentPane().add(txtCpf);
			txtCpf.setColumns(10);
		} catch (ParseException e) {
			System.out.println("Erro ao tentar formatar CPF.");
			System.out.println("Causa: " + e.getMessage());
			e.printStackTrace();
		}

		txtNome = new JTextField();
		txtNome.setBounds(90, 73, 380, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		final JRadioButton rdbAtivar = new JRadioButton("Ativar");
		rdbAtivar.setBounds(227, 41, 109, 23);
		rdbAtivar.setSelected(true);
		getContentPane().add(rdbAtivar);

		txtRua = new JTextField();
		txtRua.setBounds(90, 160, 208, 20);
		getContentPane().add(txtRua);
		txtRua.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(390, 160, 80, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(348, 129, 126, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(90, 191, 109, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		Estados siglasEstados = new Estados();
		final JComboBox<String> cbEstado = new JComboBox(siglasEstados.consultarEstados().toArray());
		cbEstado.setBounds(407, 191, 63, 20);
		cbEstado.setSelectedIndex(-1);
		getContentPane().add(cbEstado);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(384, 268, 86, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(90, 268, 208, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		CategoriaController catControl = new CategoriaController();

		final JComboBox<Categoria> cbCategoria = new JComboBox(catControl.listarCategorias().toArray());

		cbCategoria.setBounds(104, 347, 131, 20);
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
		lblTel.setBounds(309, 271, 62, 14);
		contentPane.add(lblTel);

		JLabel lblCategoria = new JLabel("Categoria (s) :");
		lblCategoria.setBounds(21, 350, 100, 14);
		contentPane.add(lblCategoria);

		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEspecialidade.setBounds(21, 314, 145, 14);
		contentPane.add(lblEspecialidade);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContato.setBounds(21, 233, 145, 14);
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
		lblEstado.setBounds(345, 194, 46, 14);
		contentPane.add(lblEstado);

		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(296, 133, 50, 14);
		contentPane.add(lblBairro);

		JLabel lblNumero = new JLabel("N\u00FAmero : ");
		lblNumero.setBounds(322, 163, 60, 14);
		contentPane.add(lblNumero);

		JLabel lblEndereo = new JLabel("Endere\u00E7o\r\n");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(21, 104, 145, 14);
		contentPane.add(lblEndereo);

		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(30, 45, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(15, 76, 46, 14);
		contentPane.add(lblNome);

		JLabel lblTitulo = new JLabel("Cadastro de Profissional");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitulo.setBounds(15, 11, 369, 14);
		contentPane.add(lblTitulo);

		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(292, 365, 178, 23);
		contentPane.add(txtArea);

		JButton btnAddCategoria = new JButton("");
		categorias = new ArrayList<Categoria>();
		btnAddCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categoria categoriaSelecionada = (Categoria) cbCategoria.getSelectedItem();

				if (categorias.contains(categoriaSelecionada)) {
					JOptionPane.showMessageDialog(null, "Categoria já foi selecionada");
				} else {

					categorias.add(categoriaSelecionada);
					txtArea.setText(categorias.toString());

				}
				categoriaSelecionada = null;
				cbCategoria.setSelectedIndex(-1);
			}

		});

		btnAddCategoria
				.setIcon(new ImageIcon(TelaCadEditProfissional.class.getResource("/icones/Button-Add-icon-24px.png")));
		btnAddCategoria.setBounds(240, 344, 28, 23);
		contentPane.add(btnAddCategoria);

		JLabel lblCategoriasSelecionadas = new JLabel("Categoria(s) selecionada(s) :");
		lblCategoriasSelecionadas.setBounds(292, 350, 178, 14);
		contentPane.add(lblCategoriasSelecionadas);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(108, 439, 100, 23);
		getContentPane().add(btnSalvar);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfissionalController control = new ProfissionalController();
				String mensagem = control.salvar(txtNome.getText(), txtCpf.getText(), rdbAtivar.isSelected(),
						txtEmail.getText(), txtTelefone.getText(), txtCep.getText(), txtRua.getText(),
						txtNumero.getText(), txtBairro.getText(), txtCidade.getText(),
						(String) cbEstado.getSelectedItem(), categorias);

				JOptionPane.showMessageDialog(null, mensagem);

				if (mensagem.contains("Cadastro realizado com sucesso")) {
					limpar();
					cbEstado.setSelectedIndex(-1);
				}
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(271, 439, 100, 23);
		getContentPane().add(btnLimpar);

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});

		JButton btnBuscarCep = new JButton("Buscar Cep");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cep = txtCep.getText().trim().replace("-", "");
				if (cep != null && !cep.trim().isEmpty()) {
					try {
					endereco = profissionalController.buscarEnderecoPorCep(txtCep.getText());
					txtCidade.setText(endereco.getCidade().replace("Ã³", "ó").replace("Ã§", "ç").replace("Ã­", "í"));
					txtBairro.setText(endereco.getBairro().replace("Ã³", "ó").replace("Ã§", "ç").replace("Ã­", "í"));
					txtRua.setText(endereco.getRua());
					cbEstado.setSelectedItem(endereco.getEstado());
					}catch (Exception eCEP) {
						System.out.println("CEP INVÁLIDO!. Erro: "+eCEP.getMessage());
						JOptionPane.showMessageDialog(null, "CEP inválido!");
					}
				} else {
					String msg = " Digite o CEP. ";
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		btnBuscarCep.setBounds(182, 122, 102, 25);
		contentPane.add(btnBuscarCep);
		
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
		btnDelCategoria.setIcon(new ImageIcon(TelaCadEditProfissional.class.getResource("/icones/delete-icon.png")));
		btnDelCategoria.setBounds(240, 378, 28, 23);
		contentPane.add(btnDelCategoria);

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
		this.categorias = new ArrayList<Categoria>();

	}
}
