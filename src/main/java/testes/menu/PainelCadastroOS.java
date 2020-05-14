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

public class PainelCadastroOS extends JPanel {

	private JTextField textField;
	private Date dataAtual = new Date();
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtBairro;

	/**
	 * Create the panel.
	 */
	public PainelCadastroOS() {

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
		
		JComboBox comboBox = new JComboBox();
		
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
		
		DatePicker datePicker = new DatePicker();
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		
		DatePicker datePicker_1 = new DatePicker();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDataInicial)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(46)
											.addComponent(lblDataFinal)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblDescricao)
											.addGap(18)
											.addComponent(txtDescricao, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)))
									.addGap(26))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(51)
									.addComponent(lblRua)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNumero)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblCep)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblBairro)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCliente)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
								.addComponent(chckbxMesmoEnderecoDo)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(298)
							.addComponent(lblNumeroOS)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroOS)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCliente)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(chckbxMesmoEnderecoDo)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua)
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumero)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCep)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBairro)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescricao))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataInicial)
						.addComponent(lblDataFinal)
						.addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(184))
		);
		setLayout(groupLayout);

	}
}
