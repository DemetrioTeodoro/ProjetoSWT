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

		MaskFormatter formatoOrdemServico;

		try {
			formatoOrdemServico = new MaskFormatter("######");
			txtNumeroOs = new JFormattedTextField(formatoOrdemServico);
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
		
		
		MaskFormatter formatoCep;

		try {
			formatoCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(formatoCep);
			txtCep.setColumns(10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		
		JTextArea txtDescricao = new JTextArea();
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		
		JLabel lblDataPrevistaTermino = new JLabel("Data Prevista Termino:");
		
		DatePicker datePicker = new DatePicker();
		
		DatePicker datePicker_1 = new DatePicker();
		
		JLabel lblCategoria = new JLabel("Categoria:");
		
		JComboBox cbCategoria = new JComboBox();
		
		JButton btnCategoria = new JButton("Categoria");
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnCategoria.setIcon(new ImageIcon(PainelCadastroOS01.class.getResource("/icones/Button-Add-icon.png")));
		
		JLabel lblProfissionais = new JLabel("Profissionais:");
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				telaPDF.setVisible(true);
				telaPDF.setLocationRelativeTo(null);
			}
		});
		
		JLabel lblCadastroOrdemDeServio = new JLabel("Cadastro Ordem de Servi\u00E7o");
		lblCadastroOrdemDeServio.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnLimpar = new JButton("Limpar");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCadastroOrdemDeServio))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNumeroOS)
					.addGap(5)
					.addComponent(txtNumeroOs, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(label))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCliente)
					.addGap(5)
					.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblEndereo))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(chckbxMesmoEnderecoDo))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblCep)
					.addGap(5)
					.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblBairro)
					.addGap(5)
					.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblRua)
					.addGap(5)
					.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNumero)
					.addGap(5)
					.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblDescricao)
					.addGap(12)
					.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblDataInicial)
					.addGap(5)
					.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataPrevistaTermino, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblCategoria)
					.addGap(12)
					.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblProfissionais)
					.addGap(5)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnCategoria))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(249)
					.addComponent(btnCadastrar))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblCadastroOrdemDeServio)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumeroOS))
						.addComponent(txtNumeroOs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label)))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCliente))
						.addComponent(cbCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblEndereo)
					.addGap(11)
					.addComponent(chckbxMesmoEnderecoDo)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCep))
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBairro))
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRua))
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNumero))
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDescricao))
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblDataInicial))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(lblDataPrevistaTermino))
						.addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblCategoria))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(cbCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblProfissionais))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnCategoria))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLimpar)
						.addComponent(btnCadastrar)))
		);
		setLayout(groupLayout);

	}
}
