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
import model.entity.Endereco;

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
	private Endereco endereco = new Endereco();
	private ClienteController clienteController = new ClienteController();

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
		
		rdbtCpf.setSelected(true);

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
			System.out.println("Erro ao formatar CEP. Causa: "+e.getMessage());
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

		cbEstado = new JComboBox(listEstados.consultarEstados().toArray());
		cbEstado.setSelectedIndex(-1);

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
		
		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cep = txtCep.getText().trim().replace("-", "");
				if (cep != null && !cep.trim().isEmpty()) {
					try {
					endereco = clienteController.buscarEnderecoPorCep(txtCep.getText());
					txtCidade.setText(endereco.getCidade().replace("Ã³", "ó").replace("Ã§", "ç").replace("Ã­", "í"));
					txtBairro.setText(endereco.getBairro().replace("Ã³", "ó").replace("Ã§", "ç").replace("Ã­", "í"));
					txtRua.setText(endereco.getRua());
					cbEstado.setSelectedItem(endereco.getEstado());
					}catch (Exception eCEP) {
						System.out.println("CEP INVÁLIDO!. Erro: "+eCEP.getMessage());
						JOptionPane.showMessageDialog(null, "CEP inválido!");
						txtCep.setText("");
					}
				} else {
					String msg = " Digite o CEP. ";
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(rdbtCpf)
					.addGap(4)
					.addComponent(rdbtCnpj)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(txtInscricao, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(392)
					.addComponent(rdbAtivo))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 787, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNum)
					.addGap(18)
					.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(lblCep)
					.addGap(18)
					.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnBuscarCep))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCidade)
					.addGap(22)
					.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblEstado)
					.addGap(18)
					.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_4))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(lblTel)
					.addGap(5)
					.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(176)
					.addComponent(lblEmail)
					.addGap(7)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(233)
					.addComponent(btSalvar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(134)
					.addComponent(btLimpar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(txtInscricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbAtivo))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(lblNewLabel_2)
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRua))
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNum))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblBairro))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblCep))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscarCep))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCidade))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado))
						.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(lblNewLabel_4)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTel))
						.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btSalvar)
						.addComponent(btLimpar)))
		);
		setLayout(groupLayout);

	}

	public void limparCampos() {
		this.txtInscricao.setText("");
		this.txtNome.setText("");
		this.txtRua.setText("");
		this.txtNum.setText("");
		this.txtBairro.setText("");
		this.txtCidade.setText("");
		this.txtCep.setText("");
		this.cbEstado.setSelectedIndex(-1);
		this.txtTel.setText("");
		this.txtEmail.setText("");

	}
}
