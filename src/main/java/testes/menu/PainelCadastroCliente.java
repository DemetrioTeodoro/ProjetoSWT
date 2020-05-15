package testes.menu;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class PainelCadastroCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRua;
	private JTextField txtNum;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente() {
		
		JLabel lblNome = new JLabel("Nome :");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JRadioButton rdbtCpf = new JRadioButton("CPF");
		
		JRadioButton rdbtCnpj = new JRadioButton("CNPJ");
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("ENDERE\u00C7O");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRua = new JLabel("Rua :");
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		
		JLabel lblNum = new JLabel("N\u00FAmero :");
		
		txtNum = new JTextField();
		txtNum.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro :");
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade :");
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado :");
		
		JLabel lblCep = new JLabel("CEP :");
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CONTATO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblTel = new JLabel("Telefone :");
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JComboBox cbEstado = new JComboBox();
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(175)
							.addComponent(rdbtCpf)
							.addGap(2)
							.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addComponent(rdbtCnpj)
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTel)
									.addGap(10)
									.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(63)
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEmail))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCidade)
									.addGap(22)
									.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
									.addGap(56)
									.addComponent(lblEstado)
									.addGap(10)
									.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNome))
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNum)
										.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addGap(49)
											.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
											.addGap(70)
											.addComponent(lblCep)
											.addGap(10)
											.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtRua))))
							.addGap(44)))
					.addGap(91))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_1)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtCpf)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtCnpj)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNome))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(45)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRua))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNum))
						.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBairro))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCep))
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCidade))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblEstado))
						.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(lblNewLabel_4)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTel))
						.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail))))
		);
		setLayout(groupLayout);

	}
}
