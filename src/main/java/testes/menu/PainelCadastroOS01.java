package testes.menu;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCadastroOS01 extends JPanel {

	private JTextField txtNumeroOs;
	private Date dataAtual = new Date();
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtBairro;
	private String[] nomes = { "Thaisa Mom CPF: 12345678910", "Demetrio CPF: 12345678911"};
	private TelaPDF telaPDF = new TelaPDF();

	/**
	 * Create the panel.
	 */
	public PainelCadastroOS01() {

		JLabel lblNumeroOS = new JLabel("N\u00B0 Odem de Servi\u00E7o:");
		lblNumeroOS.setBounds(51, 46, 121, 16);

		MaskFormatter formatoOrdemServico;

		try {
			formatoOrdemServico = new MaskFormatter("######");
			txtNumeroOs = new JFormattedTextField(formatoOrdemServico);
			txtNumeroOs.setBounds(177, 43, 85, 22);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String ano = new SimpleDateFormat("/yyyy").format(dataAtual);
		JLabel label = new JLabel(ano);
		label.setBounds(267, 46, 33, 16);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(51, 99, 44, 16);
		
		JComboBox cbCliente = new JComboBox(nomes);
		cbCliente.setBounds(100, 96, 346, 22);
		
		JCheckBox chckbxMesmoEnderecoDo = new JCheckBox("Mesmo endere\u00E7o do Cliente");
		chckbxMesmoEnderecoDo.setBounds(53, 162, 187, 25);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(53, 267, 27, 16);
		
		txtRua = new JTextField();
		txtRua.setBounds(85, 264, 354, 22);
		txtRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(457, 267, 45, 16);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(507, 264, 76, 22);
		txtNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(53, 218, 27, 16);
		
		
		MaskFormatter formatoCep;

		try {
			formatoCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(formatoCep);
			txtCep.setBounds(85, 215, 137, 22);
			txtCep.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(240, 218, 39, 16);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(284, 215, 299, 22);
		txtBairro.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(51, 307, 60, 16);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setBounds(123, 304, 460, 84);
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setBounds(51, 448, 68, 16);
		
		JLabel lblDataPrevistaTermino = new JLabel("Data Prevista Termino:");
		lblDataPrevistaTermino.setBounds(323, 448, 76, 16);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(124, 446, 187, 22);
		
		DatePicker datePicker_1 = new DatePicker();
		datePicker_1.setBounds(396, 446, 187, 22);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(51, 511, 60, 16);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(123, 508, 188, 22);
		
		JButton btnCategoria = new JButton("Categoria");
		btnCategoria.setBounds(614, 502, 107, 25);
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnCategoria.setIcon(new ImageIcon(PainelCadastroOS01.class.getResource("/icones/Button-Add-icon.png")));
		
		JLabel lblProfissionais = new JLabel("Profissionais:");
		lblProfissionais.setBounds(315, 508, 76, 16);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(396, 505, 187, 22);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(475, 665, 89, 25);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaPDF.setVisible(true);
				telaPDF.setLocationRelativeTo(null);
			}
		});
		
		JLabel lblCadastroOrdemDeServio = new JLabel("Cadastro Ordem de Servi\u00E7o");
		lblCadastroOrdemDeServio.setBounds(51, 13, 204, 19);
		lblCadastroOrdemDeServio.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(53, 136, 56, 15);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(143, 665, 83, 25);
		setLayout(null);
		add(lblCliente);
		add(cbCliente);
		add(lblNumeroOS);
		add(txtNumeroOs);
		add(label);
		add(lblCadastroOrdemDeServio);
		add(lblCategoria);
		add(cbCategoria);
		add(lblDataInicial);
		add(datePicker);
		add(lblDataPrevistaTermino);
		add(datePicker_1);
		add(btnCategoria);
		add(chckbxMesmoEnderecoDo);
		add(lblCep);
		add(txtCep);
		add(lblBairro);
		add(txtBairro);
		add(lblEndereo);
		add(lblDescricao);
		add(txtDescricao);
		add(lblRua);
		add(txtRua);
		add(lblNumero);
		add(txtNumero);
		add(lblProfissionais);
		add(comboBox);
		add(btnLimpar);
		add(btnCadastrar);

	}
}
