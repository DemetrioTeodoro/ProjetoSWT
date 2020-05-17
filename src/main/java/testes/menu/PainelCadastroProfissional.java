package testes.menu;

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

public class PainelCadastroProfissional extends JPanel {

	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNum;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JFormattedTextField txtCpf;
	private MaskFormatter cpfMask;
	private MaskFormatter cepMask;
	private JComboBox cbEstado;
	private JTextField txtCategoriaSelect;

	/**
	 * Create the panel.
	 */
	public PainelCadastroProfissional() {
		
		JLabel lblCpf = new JLabel("CPF :");
		
		try {
			cpfMask = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(cpfMask);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblNome = new JLabel("Nome :");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JLabel lblTituloCadProf = new JLabel("Cadastro de Profissional");
		lblTituloCadProf.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblTituloEnd = new JLabel("Endere\u00E7o");
		lblTituloEnd.setFont(new Font("Tahoma", Font.BOLD, 12));

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

		JLabel lblTituloContato = new JLabel("Contato");
		lblTituloContato.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblTel = new JLabel("Telefone :");

		txtTel = new JTextField();
		txtTel.setColumns(10);

		JLabel lblEmail = new JLabel("Email :");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		JComboBox cbEstado = new JComboBox();

		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ProfissionalController control = new ProfissionalController();
			}
		});

		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		
		JLabel lblTituloEspProf = new JLabel("Especialidade Profissional");
		lblTituloEspProf.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCategoria = new JLabel("Categoria :");
		
		JComboBox cbCategoria = new JComboBox();
		
		JLabel lblCategoriaSelect = new JLabel("Categoria(s) Selecionada(s) :");
		
		txtCategoriaSelect = new JTextField();
		txtCategoriaSelect.setEditable(false);
		txtCategoriaSelect.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblCpf)
							.addGap(35)
							.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 675, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblTituloEnd, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(lblNum)
							.addGap(18)
							.addComponent(txtNum, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(lblCep)
							.addGap(18)
							.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(lblCidade)
							.addGap(22)
							.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(lblEstado)
							.addGap(18)
							.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblTituloContato))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(lblTel)
							.addGap(10)
							.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(lblEmail)
							.addGap(6)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblTituloEspProf))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblCategoria)
							.addGap(10)
							.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCategoriaSelect, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(142)
									.addComponent(txtCategoriaSelect, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(227)
							.addComponent(btSalvar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(127)
							.addComponent(btLimpar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblTituloCadProf, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblTituloCadProf)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCpf))
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(lblTituloEnd)
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRua))
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addGap(40)
					.addComponent(lblTituloContato)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblTel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txtTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblTituloEspProf)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblCategoria))
						.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblCategoriaSelect))
								.addComponent(txtCategoriaSelect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btSalvar)
						.addComponent(btLimpar)))
		);
		setLayout(groupLayout);

	}

	protected void limparCampos() {
		this.txtCpf.setText("");
		this.txtNome.setText("");
		this.txtRua.setText("");
		this.txtNum.setText("");
		this.txtBairro.setText("");
		this.txtCidade.setText("");
		this.txtCep.setText("");

		this.txtTel.setText("");
		this.txtEmail.setText("");

		this.cbEstado.setSelectedIndex(-1);
	}

}
