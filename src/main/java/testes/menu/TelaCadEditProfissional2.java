package testes.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.CategoriaController;
import controller.ProfissionalController;
import helpers.Estados;
import model.BO.CategoriaBO;
import model.entity.Categoria;
import model.entity.Profissional;

import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaCadEditProfissional2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField textField_7;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JRadioButton rdbDesativar;
	private JComboBox<Categoria> cbCategoria;
	private JComboBox<String> cbEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadEditProfissional2 frame = new TelaCadEditProfissional2();
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
	public TelaCadEditProfissional2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCpf = new JLabel("CPF :");
		
		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(maskCpf);
			txtCpf.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNome = new JLabel("Nome :");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblRua = new JLabel("Rua :");

		txtRua = new JTextField();
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero :");

		txtNumero = new JTextField();
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro :");

		txtBairro = new JTextField();
		txtBairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP :");

		//final JFormattedTextField txtCep = new JFormattedTextField((AbstractFormatter) null);
		
		MaskFormatter maskCep;
		try {
			maskCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(maskCep);
			txtCep.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblCidade = new JLabel("Cidade :");

		txtCidade = new JTextField();
		txtCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado :");
		
		Estados siglasEstados =new Estados();
		final JComboBox cbEstado = new JComboBox(siglasEstados.consultarEstados().toArray());
		cbEstado.setSelectedIndex(-1);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblTelefone = new JLabel("Telefone :");

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		JLabel lblEspecialidade = new JLabel("Especialidade Profissional");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblCategoria = new JLabel("Categoria :");

		CategoriaController catControl = new CategoriaController();
		
		final JComboBox cbCategoria = new JComboBox(catControl.listarCategorias().toArray());
		cbCategoria.setSelectedIndex(-1);

		JLabel lblCategorias = new JLabel("Categoria(s) Selecionada(s) :");

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfissionalController control = new ProfissionalController();
				String mensagem = control.salvar(txtNome.getText(), txtCpf.getText(), rdbDesativar.isSelected(),
				txtEmail.getText(), txtTelefone.getText(), txtCep.getText(), txtRua.getText(), txtNumero.getText(), 
				txtBairro.getText(), txtCidade.getText(), (String)cbEstado.getSelectedItem(), (Categoria)cbCategoria.getSelectedItem());
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		

		JLabel lblCadastroProfissional = new JLabel("Cadastro de Profissional");
		lblCadastroProfissional.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JRadioButton rdbDesativar = new JRadioButton("Desativar Profissional");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblCadastroProfissional, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblEndereco, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblContato))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(116)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblEspecialidade))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblCategorias, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(198)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(127)
					.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbDesativar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)))
					.addGap(43))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblCadastroProfissional)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(rdbDesativar)
					.addGap(18)
					.addComponent(lblEndereco)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(lblContato)
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblEspecialidade)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCategoria, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCategorias, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		
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
		this.rdbDesativar.setSelected(false);
		this.cbCategoria.setSelectedIndex(-1); 
		this.cbEstado.setSelectedIndex(-1); 
		
	}
}
