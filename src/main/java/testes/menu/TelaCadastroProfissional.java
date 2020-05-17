package testes.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;

public class TelaCadastroProfissional extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProfissional frame = new TelaCadastroProfissional();
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
	public TelaCadastroProfissional() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(26, 88, 31, 16);

		JFormattedTextField txtCpf = new JFormattedTextField();
		txtCpf.setBounds(92, 85, 138, 22);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(26, 118, 57, 16);

		txtNome = new JTextField();
		txtNome.setBounds(87, 115, 675, 22);
		txtNome.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(26, 171, 182, 15);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblRua = new JLabel("Rua :");
		lblRua.setBounds(27, 214, 41, 16);

		txtRua = new JTextField();
		txtRua.setBounds(89, 211, 673, 22);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero :");
		lblNumero.setBounds(27, 247, 54, 16);

		txtNumero = new JTextField();
		txtNumero.setBounds(99, 244, 75, 22);
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(223, 247, 45, 16);

		txtBairro = new JTextField();
		txtBairro.setBounds(272, 244, 281, 22);
		txtBairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(615, 247, 31, 16);

		JFormattedTextField txtCep = new JFormattedTextField((AbstractFormatter) null);
		txtCep.setBounds(664, 244, 113, 22);

		JLabel lblCidade = new JLabel("Cidade :");
		lblCidade.setBounds(27, 280, 48, 16);

		txtCidade = new JTextField();
		txtCidade.setBounds(97, 277, 454, 22);
		txtCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(609, 280, 47, 16);

		JComboBox cbEstado = new JComboBox();
		cbEstado.setBounds(668, 276, 109, 22);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(26, 339, 51, 15);
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(31, 375, 59, 16);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(100, 372, 113, 22);
		txtTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(319, 372, 40, 16);

		txtEmail = new JTextField();
		txtEmail.setBounds(365, 369, 421, 22);
		txtEmail.setColumns(10);

		JLabel lblEspecialidade = new JLabel("Especialidade Profissional");
		lblEspecialidade.setBounds(26, 429, 154, 15);
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblCategoria = new JLabel("Categoria :");
		lblCategoria.setBounds(26, 466, 64, 16);

		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(100, 462, 245, 22);

		JLabel lblCategorias = new JLabel("Categoria(s) Selecionada(s) :");
		lblCategorias.setBounds(356, 466, 148, 16);

		textField_7 = new JTextField();
		textField_7.setBounds(498, 463, 274, 22);
		textField_7.setEditable(false);
		textField_7.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(203, 524, 137, 25);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(467, 524, 137, 25);
		getContentPane().setLayout(null);

		JLabel lblCadastroProfissional = new JLabel("Cadastro de Profissional");
		lblCadastroProfissional.setBounds(26, 13, 224, 19);
		lblCadastroProfissional.setFont(new Font("Tahoma", Font.BOLD, 15));
		getContentPane().add(lblCadastroProfissional);
		getContentPane().add(lblCpf);
		getContentPane().add(txtCpf);
		getContentPane().add(lblNome);
		getContentPane().add(txtNome);
		getContentPane().add(lblEndereco);
		getContentPane().add(lblRua);
		getContentPane().add(txtRua);
		getContentPane().add(lblNumero);
		getContentPane().add(txtNumero);
		getContentPane().add(lblBairro);
		getContentPane().add(txtBairro);
		getContentPane().add(lblCep);
		getContentPane().add(txtCep);
		getContentPane().add(lblCidade);
		getContentPane().add(txtCidade);
		getContentPane().add(lblEstado);
		getContentPane().add(cbEstado);
		getContentPane().add(lblContato);
		getContentPane().add(lblTelefone);
		getContentPane().add(txtTelefone);
		getContentPane().add(lblEmail);
		getContentPane().add(txtEmail);
		getContentPane().add(lblEspecialidade);
		getContentPane().add(lblCategoria);
		getContentPane().add(cbCategoria);
		getContentPane().add(textField_7);
		getContentPane().add(lblCategorias);
		getContentPane().add(btnSalvar);
		getContentPane().add(btnLimpar);
	}

}
