package testes.menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PainelCadastroOS01 extends JPanel {

	private JTextField textField;
	private Date dataAtual = new Date();
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtBairro;
	private String[] nomes = { "Thaisa Mom CPF: 12345678910", "Demetrio CPF: 12345678911"};

	/**
	 * Create the panel.
	 */
	public PainelCadastroOS01() {

		JLabel lblNumeroOS = new JLabel("N\u00B0 Odem de Servi\u00E7o:");

		MaskFormatter formatoOrdemServico;

		try {
			formatoOrdemServico = new MaskFormatter("######");
			textField = new JFormattedTextField(formatoOrdemServico);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ano = new SimpleDateFormat("/yyyy").format(dataAtual);
		JLabel label = new JLabel(ano);
		
		JLabel lblCliente = new JLabel("Cliente:");
		
		JComboBox cbCliente = new JComboBox(nomes);
		
		JCheckBox chckbxMesmoEnderecoDo = new JCheckBox("Mesmo endere\u00E7o do Cliente");
		
		JLabel lblRua = new JLabel("Rua:");
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep:");
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		
		JTextArea txtDescricao = new JTextArea();
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		
		JPanel panel = new JPanel();
		
		DatePicker datePicker = new DatePicker();
		
		DatePicker datePicker_1 = new DatePicker();
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JComboBox cbCategoria = new JComboBox();
		
		JLabel lblCategoria_1 = new JLabel("Categoria:");
		lblCategoria_1.setEnabled(false);
		
		JComboBox cbCategoria2 = new JComboBox();
		cbCategoria2.setEnabled(false);
		
		JButton btnCategoria = new JButton("Categoria");
		btnCategoria.setIcon(new ImageIcon(PainelCadastroOS01.class.getResource("/icones/Button-Add-icon.png")));
		
		JLabel lblProfissionais = new JLabel("Profissionais:");
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnCadastrar = new JButton("Cadastrar");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblCliente)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cbCliente, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblCategoria)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(cbCategoria, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblDataInicial)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblCategoria_1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(cbCategoria2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addComponent(lblDataFinal)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnCategoria))))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblDescricao)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtDescricao))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(lblRua)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNumero)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxMesmoEnderecoDo)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblCep)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblBairro)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNumeroOS)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblProfissionais)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCadastrar)
							.addGap(96)))
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
					.addGap(76))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNumeroOS)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCliente)
								.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addComponent(chckbxMesmoEnderecoDo)
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCep)
								.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBairro)
								.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRua)
								.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumero)
								.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescricao))
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDataInicial)
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDataFinal)
								.addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(40)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCategoria)
										.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCategoria_1)
										.addComponent(cbCategoria2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(51)
									.addComponent(btnCategoria)))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProfissionais)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(118)
							.addComponent(btnCadastrar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 761, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero OS:");
		lblNewLabel.setBounds(190, 67, 71, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNumeroOsDoc = new JLabel("numero");
		lblNumeroOsDoc.setBounds(272, 67, 56, 16);
		panel.add(lblNumeroOsDoc);
		
		JLabel lblCliente_1 = new JLabel("Cliente:");
		lblCliente_1.setBounds(190, 96, 56, 16);
		panel.add(lblCliente_1);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(246, 96, 56, 16);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(342, 96, 56, 16);
		panel.add(lblCpf);
		
		JLabel lblCpfdoc = new JLabel("CpfDoc");
		lblCpfdoc.setBounds(380, 96, 56, 16);
		panel.add(lblCpfdoc);
		
		JLabel lblCep_1 = new JLabel("Cep:");
		lblCep_1.setBounds(190, 135, 56, 16);
		panel.add(lblCep_1);
		
		JLabel lblCepdoc = new JLabel("CepDoc");
		lblCepdoc.setBounds(224, 135, 56, 16);
		panel.add(lblCepdoc);
		
		JLabel lblBairroDoc = new JLabel("Bairro:");
		lblBairroDoc.setBounds(319, 135, 56, 16);
		panel.add(lblBairroDoc);
		
		JLabel lblBairrodoc = new JLabel("BairroDoc");
		lblBairrodoc.setBounds(365, 135, 56, 16);
		panel.add(lblBairrodoc);
		
		JLabel lblRua_1 = new JLabel("Rua:");
		lblRua_1.setBounds(190, 176, 56, 16);
		panel.add(lblRua_1);
		
		JLabel lblNomerua = new JLabel("NomeRua");
		lblNomerua.setBounds(224, 176, 316, 16);
		panel.add(lblNomerua);
		
		JLabel lblNumeroEndDoc = new JLabel("Numero:");
		lblNumeroEndDoc.setBounds(190, 216, 56, 16);
		panel.add(lblNumeroEndDoc);
		
		JLabel lblNumeroEndereco = new JLabel("numero endereco");
		lblNumeroEndereco.setBounds(246, 216, 101, 16);
		panel.add(lblNumeroEndereco);
		
		JLabel lblDescricaoDoc = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricaoDoc.setBounds(190, 268, 71, 16);
		panel.add(lblDescricaoDoc);
		
		JLabel lblDescricaodoc = new JLabel("descricaoDoc");
		lblDescricaodoc.setBounds(257, 268, 283, 71);
		panel.add(lblDescricaodoc);
		
		JLabel lblDataInicialDoc = new JLabel("Data Inicial:");
		lblDataInicialDoc.setBounds(190, 373, 71, 16);
		panel.add(lblDataInicialDoc);
		
		JLabel lblDatainicialDocResul = new JLabel("dataInicialDoc");
		lblDatainicialDocResul.setBounds(273, 373, 74, 16);
		panel.add(lblDatainicialDocResul);
		
		JLabel lblDataFinalDoc = new JLabel("Data Final:");
		lblDataFinalDoc.setBounds(380, 373, 71, 16);
		panel.add(lblDataFinalDoc);
		
		JLabel lblDataFinalDocResult = new JLabel("dataFinalDocResult");
		lblDataFinalDocResult.setBounds(453, 373, 65, 16);
		panel.add(lblDataFinalDocResult);
		
		JLabel lblCategoriaDoc = new JLabel("Categoria:");
		lblCategoriaDoc.setBounds(190, 426, 71, 16);
		panel.add(lblCategoriaDoc);
		
		JLabel lblCategoriaDocResult = new JLabel("categoriaDocResult");
		lblCategoriaDocResult.setBounds(257, 426, 109, 16);
		panel.add(lblCategoriaDocResult);
		
		JLabel lblCategoriaDoc2 = new JLabel("Categoria:");
		lblCategoriaDoc2.setBounds(190, 467, 71, 16);
		panel.add(lblCategoriaDoc2);
		
		JLabel lblCategoriaDocResult2 = new JLabel("categoriaDocResult2");
		lblCategoriaDocResult2.setBounds(257, 467, 109, 16);
		panel.add(lblCategoriaDocResult2);
		
		JLabel lblProfissional = new JLabel("Profissional:");
		lblProfissional.setBounds(190, 528, 71, 16);
		panel.add(lblProfissional);
		
		JLabel lblProfissionalDoc = new JLabel("profissionalDoc");
		lblProfissionalDoc.setBounds(272, 528, 94, 16);
		panel.add(lblProfissionalDoc);
		
		JLabel lblNumeroOs = new JLabel("");
		lblNumeroOs.setBounds(36, 5, 736, 743);
		lblNumeroOs.setIcon(new ImageIcon(PainelCadastroOS01.class.getResource("/icones/folha-de-papel-branco.jpg")));
		panel.add(lblNumeroOs);
		setLayout(groupLayout);

	}
}
