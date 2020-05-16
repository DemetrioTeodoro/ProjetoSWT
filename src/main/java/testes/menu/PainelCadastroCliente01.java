package testes.menu;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCadastroCliente01 extends JPanel {
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNum;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtCnpj;
	private final  JRadioButton rdbtCnpj;
	private final JRadioButton rdbtCpf;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente01() {
		
		this.rdbtCnpj = new JRadioButton();
		this.rdbtCpf = new JRadioButton();
		rdbtCpf.setSelected(true);
		JLabel lblNome = new JLabel("Nome :");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		final JRadioButton rdbtCpf = new JRadioButton("CPF");
		rdbtCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCnpj.setEnabled(false);
				rdbtCnpj.setSelected(false);
			}
		});
		
		MaskFormatter maskCpf;

		try {
			maskCpf = new MaskFormatter("###.###.###-##");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JRadioButton rdbtCnpj = new JRadioButton("CNPJ");
		rdbtCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCnpj.setEnabled(true);
				rdbtCpf.setSelected(false);
			}
		});
		
		MaskFormatter maskCnpj;
		try {
			maskCnpj = new MaskFormatter("##.###.###/####-##");
			txtCnpj = new JFormattedTextField(maskCnpj);
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
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
		
		MaskFormatter maskCep;
		try {
			maskCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(maskCep);
			
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		JLabel lblNewLabel_4 = new JLabel("CONTATO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblTel = new JLabel("Telefone :");
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JComboBox cbEstado = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("N\u00BA Inscri\u00E7\u00E3o: ");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(rdbtCpf)
					.addGap(18)
					.addComponent(rdbtCnpj)
					.addGap(43)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCidade)
					.addGap(22)
					.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(lblEstado)
					.addGap(10)
					.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_4))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblTel)
					.addGap(10)
					.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtRua))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNum)
							.addGap(18)
							.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(lblCep)
							.addGap(10)
							.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_1)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtCpf)
						.addComponent(rdbtCnpj)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(lblNewLabel_2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblRua))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNum))
						.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBairro))
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
					.addGap(28)
					.addComponent(lblNewLabel_4)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTel))
						.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

	}
}
