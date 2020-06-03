package testes.menu;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

public class TelaEditarOS extends JFrame {

	private JPanel contentPane;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarOS frame = new TelaEditarOS();
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
	public TelaEditarOS() {
		setTitle("Edi\u00E7\u00E3o da Ordem de Servi\u00E7o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumOrdemServico = new JLabel("N\u00B0 Odem de Servi\u00E7o:");
		lblNumOrdemServico.setBounds(70, 64, 121, 16);
		contentPane.add(lblNumOrdemServico);

		JLabel lblGeradorNumero = new JLabel("GeradorNumero");
		lblGeradorNumero.setEnabled(false);
		lblGeradorNumero.setBounds(198, 64, 91, 16);
		contentPane.add(lblGeradorNumero);

		JLabel lblAno = new JLabel("/2020");
		lblAno.setBounds(296, 64, 33, 16);
		contentPane.add(lblAno);

		JCheckBox chckbxFinalizada = new JCheckBox("Finalizada");
		chckbxFinalizada.setBounds(556, 60, 113, 25);
		contentPane.add(chckbxFinalizada);

		JLabel lblEdicaoDaOrdem = new JLabel("Edi\u00E7\u00E3o da Ordem de Servi\u00E7o");
		lblEdicaoDaOrdem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdicaoDaOrdem.setBounds(33, 13, 217, 16);
		contentPane.add(lblEdicaoDaOrdem);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(70, 108, 44, 16);
		contentPane.add(lblCliente);

		JComboBox cbCliente = new JComboBox(new Object[] {});
		cbCliente.setBounds(119, 105, 550, 22);
		contentPane.add(cbCliente);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereco.setBounds(72, 145, 56, 15);
		contentPane.add(lblEndereco);

		JCheckBox chckbxMesmoEnderecoDo = new JCheckBox("Mesmo endere\u00E7o do Cliente");
		chckbxMesmoEnderecoDo.setBounds(72, 171, 187, 25);
		contentPane.add(chckbxMesmoEnderecoDo);
		
		MaskFormatter formatoCep;

		try {
			formatoCep = new MaskFormatter("#####-###");
			txtCep = new JFormattedTextField(formatoCep);
			txtCep.setColumns(10);
			txtCep.setBounds(104, 224, 137, 22);
			contentPane.add(txtCep);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(72, 227, 27, 16);
		contentPane.add(lblCEP);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(303, 224, 366, 22);
		contentPane.add(txtBairro);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(259, 227, 39, 16);
		contentPane.add(lblBairro);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(72, 279, 27, 16);
		contentPane.add(lblRua);

		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(104, 276, 354, 22);
		contentPane.add(txtRua);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(476, 279, 45, 16);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(526, 276, 143, 22);
		contentPane.add(txtNumero);

		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(142, 316, 527, 84);
		contentPane.add(txtArea);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(70, 319, 60, 16);
		contentPane.add(lblDescricao);

		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setBounds(70, 419, 68, 16);
		contentPane.add(lblDataInicial);

		DatePicker datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(TelaEditarOS.class.getResource("/icones/calendar-icon.png")));
		datePicker.getComponentToggleCalendarButton().setText("");
		datePicker.setBounds(143, 417, 187, 22);
		contentPane.add(datePicker);

		JLabel lblDataTermino = new JLabel("Data Prevista Termino:");
		lblDataTermino.setBounds(342, 421, 144, 16);
		contentPane.add(lblDataTermino);

		DatePicker datePicker_1 = new DatePicker();
		datePicker_1.getComponentToggleCalendarButton()
				.setIcon(new ImageIcon(TelaEditarOS.class.getResource("/icones/calendar-icon.png")));
		datePicker_1.getComponentToggleCalendarButton().setText("");
		datePicker_1.setBounds(482, 419, 187, 22);
		contentPane.add(datePicker_1);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(70, 484, 60, 16);
		contentPane.add(lblCategoria);

		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(142, 481, 188, 22);
		contentPane.add(cbCategoria);

		JLabel lblProfissional = new JLabel("Profissionais:");
		lblProfissional.setBounds(342, 481, 76, 16);
		contentPane.add(lblProfissional);

		JComboBox cbProfissional = new JComboBox();
		cbProfissional.setBounds(423, 478, 187, 22);
		contentPane.add(cbProfissional);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(198, 563, 83, 25);
		contentPane.add(btnLimpar);

		JButton btnConfirmarEdicao = new JButton("Confirmar Edi\u00E7\u00E3o");
		btnConfirmarEdicao.setBounds(459, 563, 158, 25);
		contentPane.add(btnConfirmarEdicao);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(TelaEditarOS.class.getResource("/icones/Button-Add-icon.png")));
		button_1.setBounds(620, 477, 49, 25);
		contentPane.add(button_1);
	}
}
