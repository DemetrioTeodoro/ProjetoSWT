package testes.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarCliente frame = new TelaEditarCliente();
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
	public TelaEditarCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCpf = new JLabel("CPF / CNPJ :");
		lblCpf.setBounds(26, 88, 94, 16);
		
		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(maskCpf);
			txtCpf.setBounds(94, 86, 109, 20);
			txtCpf.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(26, 118, 57, 16);

		txtNome = new JTextField();
		txtNome.setBounds(94, 117, 696, 22);
		txtNome.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(26, 171, 182, 15);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblRua = new JLabel("Rua :");
		lblRua.setBounds(27, 214, 41, 16);

		txtRua = new JTextField();
		txtRua.setBounds(90, 211, 696, 22);
		txtRua.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero :");
		lblNumero.setBounds(27, 247, 54, 16);

		txtNumero = new JTextField();
		txtNumero.setBounds(90, 244, 75, 22);
		txtNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(223, 247, 45, 16);

		txtBairro = new JTextField();
		txtBairro.setBounds(272, 244, 281, 22);
		txtBairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(615, 247, 31, 16);

		JFormattedTextField txtCep = new JFormattedTextField((AbstractFormatter) null);
		txtCep.setBounds(664, 244, 122, 22);

		JLabel lblCidade = new JLabel("Cidade :");
		lblCidade.setBounds(27, 280, 48, 16);

		txtCidade = new JTextField();
		txtCidade.setBounds(90, 277, 454, 22);
		txtCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(609, 280, 47, 16);

		JComboBox cbEstado = new JComboBox();
		cbEstado.setBounds(668, 276, 118, 22);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(26, 339, 51, 15);
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(31, 375, 59, 16);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(90, 372, 113, 22);
		txtTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(319, 372, 40, 16);

		txtEmail = new JTextField();
		txtEmail.setBounds(365, 369, 421, 22);
		txtEmail.setColumns(10);

		JButton btnSalvar = new JButton("Editar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(203, 524, 137, 25);

		JButton btnLimpar = new JButton("Cancelar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(467, 524, 137, 25);
		contentPane.setLayout(null);

		JLabel lblCadastroProfissional = new JLabel("Cliente");
		lblCadastroProfissional.setBounds(26, 13, 224, 19);
		lblCadastroProfissional.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.setLayout(null);
		contentPane.add(txtCpf);
		contentPane.add(lblCadastroProfissional);
		contentPane.add(lblCpf);
		contentPane.add(lblNome);
		contentPane.add(txtNome);
		contentPane.add(lblEndereco);
		contentPane.add(lblRua);
		contentPane.add(txtRua);
		contentPane.add(lblNumero);
		contentPane.add(txtNumero);
		contentPane.add(lblBairro);
		contentPane.add(txtBairro);
		contentPane.add(lblCep);
		contentPane.add(txtCep);
		contentPane.add(lblCidade);
		contentPane.add(txtCidade);
		contentPane.add(lblEstado);
		contentPane.add(cbEstado);
		contentPane.add(lblContato);
		contentPane.add(lblTelefone);
		contentPane.add(txtTelefone);
		contentPane.add(lblEmail);
		contentPane.add(txtEmail);
		contentPane.add(btnSalvar);
		contentPane.add(btnLimpar);
		
		
	}
}
