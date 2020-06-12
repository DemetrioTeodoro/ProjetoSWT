package view;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import helpers.Estados;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PainelCadastroCliente01 extends JPanel {

	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNum;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JFormattedTextField txtInscricao;
	private MaskFormatter cnpjMask;
	private MaskFormatter cpfMask;
	private MaskFormatter cepMask;
	private JComboBox cbEstado;

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente01() {

		JLabel lblNewLabel = new JLabel("N\u00FAmero de Inscri\u00E7\u00E3o: ");

		txtInscricao = new JFormattedTextField();

		try {
			cnpjMask = new MaskFormatter("##.###.###/####-##");
			cpfMask = new MaskFormatter("###.###.###-##");
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		JRadioButton rdbtCpf = new JRadioButton("CPF");

		rdbtCpf.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtInscricao.setValue(null);
					txtInscricao.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
				}
			}
		});

		final JRadioButton rdbtCnpj = new JRadioButton("CNPJ");

		rdbtCnpj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					txtInscricao.setValue(null);
					txtInscricao.setFormatterFactory(new DefaultFormatterFactory(cnpjMask));
				}
			}
		});

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtCpf);
		radioGroup.add(rdbtCnpj);

		final JRadioButton rdbAtivo = new JRadioButton("Ativo");
		rdbAtivo.setSelected(true);

		JLabel lblNome = new JLabel("Nome :");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cadastro de Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));

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

		try {
			cepMask = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(cepMask);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblNewLabel_4 = new JLabel("Contato");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblTel = new JLabel("Telefone :");

		txtTel = new JTextField();
		txtTel.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		Estados listEstados = new Estados();

		final JComboBox<String> cbEstado = new JComboBox(listEstados.consultarEstados().toArray());

		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController control = new ClienteController();
				String mensagem = control.salvar(txtInscricao.getText(), txtNome.getText(), rdbtCnpj.isSelected(),
						rdbtCnpj.isSelected(), rdbAtivo.isSelected(), txtTel.getText(), txtEmail.getText(),
						txtCep.getText(), txtRua.getText(), txtNum.getText(), txtBairro.getText(), txtCidade.getText(),
						(String) cbEstado.getSelectedItem());
				JOptionPane.showMessageDialog(null, mensagem);
				limparCampos();
			}
		});

		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 57,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
								.addComponent(
										lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addGroup(groupLayout.createSequentialGroup().addComponent(rdbtCpf)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtCnpj).addGap(18)
										.addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtInscricao, GroupLayout.PREFERRED_SIZE, 138,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
										.addComponent(rdbAtivo))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblTel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 113,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(
														btSalvar, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblEmail)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(134).addComponent(
														btLimpar, GroupLayout.PREFERRED_SIZE, 105,
														GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtEmail, 449, 449, 449))))
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 182,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(51).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblCidade).addGap(22)
										.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 454,
												GroupLayout.PREFERRED_SIZE)
										.addGap(58).addComponent(lblEstado).addGap(18)
										.addComponent(cbEstado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNum).addComponent(lblRua, GroupLayout.PREFERRED_SIZE,
														41, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, 75,
																GroupLayout.PREFERRED_SIZE)
														.addGap(49)
														.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 45,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 281,
																GroupLayout.PREFERRED_SIZE)
														.addGap(62).addComponent(lblCep).addGap(18).addComponent(txtCep,
																GroupLayout.PREFERRED_SIZE, 113,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(txtRua))))))
				.addGap(82)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(35).addComponent(lblNewLabel_1).addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rdbtCpf)
								.addComponent(rdbtCnpj).addComponent(lblNewLabel)
								.addComponent(txtInscricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbAtivo))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(32).addComponent(lblNome))
								.addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(txtNome,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(34).addComponent(lblNewLabel_2).addGap(25)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRua))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(lblNum))
								.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBairro))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCep)))
						.addGap(10)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(4).addComponent(lblCidade))
								.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(txtCidade,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEstado)))
						.addGap(40).addComponent(lblNewLabel_4).addGap(12)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(lblTel))
								.addGroup(groupLayout.createSequentialGroup().addGap(3)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblEmail)
												.addComponent(txtTel, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE).addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(btSalvar).addComponent(btLimpar))
						.addGap(43)));
		setLayout(groupLayout);

	}

	protected void limparCampos() {
		this.txtInscricao.setText("");
		this.txtNome.setText("");
		this.txtRua.setText("");
		this.txtNum.setText("");
		this.txtBairro.setText("");
		this.txtCidade.setText("");
		this.txtCep.setText("");

		this.txtTel.setText("");
		this.txtEmail.setText("");

//		this.cbEstado.setSelectedIndex(-1);
	}
}
