package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Profissional;

public class TelaPDF extends JFrame {

	private JPanel contentPane;
	private JLabel lblNumeroOSDoc;
	private JLabel lblCpfDoc;
	private JLabel lblCepDoc;
	private JLabel lblBairroDoc;
	private JLabel lblNumeroEndDoc;
	private JLabel lblDescricaoDoc;
	private JLabel lblDataInicialDoc;
	private JLabel lblDataFinalDoc;
	private JLabel lblCategoriaDoc;
	private JLabel lblCategoriaDoc2;
	private JLabel lblProfissionalDoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPDF frame = new TelaPDF();
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
	public TelaPDF() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(-30, -124, 784, 761);
		contentPane.add(panel);

		JLabel lblNumeroOS = new JLabel("Numero OS:");
		lblNumeroOS.setBounds(190, 187, 71, 16);
		panel.add(lblNumeroOS);

		lblNumeroOSDoc = new JLabel("numero");
		lblNumeroOSDoc.setBounds(272, 187, 56, 16);
		panel.add(lblNumeroOSDoc);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(190, 216, 56, 16);
		panel.add(lblCliente);

		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(246, 216, 56, 16);
		panel.add(lblNome);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(342, 216, 56, 16);
		panel.add(lblCPF);

		lblCpfDoc = new JLabel("CpfDoc");
		lblCpfDoc.setBounds(380, 216, 56, 16);
		panel.add(lblCpfDoc);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(190, 255, 56, 16);
		panel.add(lblCep);

		lblCepDoc = new JLabel("CepDoc");
		lblCepDoc.setBounds(224, 255, 56, 16);
		panel.add(lblCepDoc);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(319, 255, 56, 16);
		panel.add(lblBairro);

		lblBairroDoc = new JLabel("BairroDoc");
		lblBairroDoc.setBounds(365, 255, 56, 16);
		panel.add(lblBairroDoc);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(190, 296, 56, 16);
		panel.add(lblRua);

		JLabel lblNomeRua = new JLabel("NomeRua");
		lblNomeRua.setBounds(224, 296, 316, 16);
		panel.add(lblNomeRua);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(190, 336, 56, 16);
		panel.add(lblNumero);

		lblNumeroEndDoc = new JLabel("numero endereco");
		lblNumeroEndDoc.setBounds(246, 336, 101, 16);
		panel.add(lblNumeroEndDoc);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(190, 388, 71, 16);
		panel.add(lblDescricao);

		lblDescricaoDoc = new JLabel("descricaoDoc");
		lblDescricaoDoc.setBounds(257, 388, 283, 71);
		panel.add(lblDescricaoDoc);

		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setBounds(190, 493, 71, 16);
		panel.add(lblDataInicial);

		lblDataInicialDoc = new JLabel("dataInicialDoc");
		lblDataInicialDoc.setBounds(273, 493, 74, 16);
		panel.add(lblDataInicialDoc);

		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setBounds(380, 493, 71, 16);
		panel.add(lblDataFinal);

		lblDataFinalDoc = new JLabel("dataFinalDocResult");
		lblDataFinalDoc.setBounds(453, 493, 65, 16);
		panel.add(lblDataFinalDoc);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(190, 546, 71, 16);
		panel.add(lblCategoria);

		lblCategoriaDoc = new JLabel("categoriaDocResult");
		lblCategoriaDoc.setBounds(257, 546, 109, 16);
		panel.add(lblCategoriaDoc);

		JLabel lblCategoria2 = new JLabel("Categoria:");
		lblCategoria2.setBounds(190, 587, 71, 16);
		panel.add(lblCategoria2);

		lblCategoriaDoc2 = new JLabel("categoriaDocResult2");
		lblCategoriaDoc2.setBounds(257, 587, 109, 16);
		panel.add(lblCategoriaDoc2);

		JLabel lblProfissional = new JLabel("Profissional:");
		lblProfissional.setBounds(190, 648, 71, 16);
		panel.add(lblProfissional);

		lblProfissionalDoc = new JLabel("profissionalDoc");
		lblProfissionalDoc.setBounds(272, 648, 94, 16);
		panel.add(lblProfissionalDoc);

		JLabel lblDocPDF = new JLabel("");
		lblDocPDF.setIcon(new ImageIcon(TelaPDF.class.getResource("/icones/folha-de-papel-branco.jpg")));
		lblDocPDF.setBounds(36, 125, 736, 743);
		panel.add(lblDocPDF);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numeroOS = lblNumeroOSDoc.getText();
				String idCliente = lblCategoriaDoc.getText();
				String cep = lblCepDoc.getText();
				String bairro = lblBairroDoc.getText();
				String rua = lblNomeRua.getText();
				String numero = lblNumeroEndDoc.getText();
				if (lblDescricaoDoc.getText() != null) {
					String descricao = lblDescricaoDoc.getText();
				}
				LocalDate dataInicial = LocalDate.parse(lblDataInicialDoc.getText());
				LocalDate dataPrevistaFinal = LocalDate.parse(lblDataFinalDoc.getText());
				/*String idCategoria = cbCategoria.getSelectedIndex();
				String idProfissioanl = cbProfissional.getSelectedIndex();*/
				
				//TODO Validação
				
				Endereco endereco = new Endereco();
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				endereco.setRua(rua);
				endereco.setNumero(numero);
			}
		});
		btnCadastrar.setBounds(766, 612, 97, 25);
		contentPane.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(766, 578, 97, 25);
		contentPane.add(btnCancelar);
	}

	public void getDados(String numeroOS, Cliente idCliente, String descricao, LocalDate dataInicial,
			LocalDate dataPrevistaFinal, Categoria idCategoria, Profissional idProfissioanl, Endereco endereco) {
		
		lblDescricaoDoc.setText(descricao);
		lblBairroDoc.setText(endereco.getBairro());
		lblDataInicialDoc.setText(dataInicial.toString());
		lblDataFinalDoc.setText(dataPrevistaFinal.toString());
		lblCepDoc.setText(endereco.getCep());
		lblNumeroEndDoc.setText(endereco.getNumero());
		lblCategoriaDoc.setText(idCategoria.getNome());
		lblProfissionalDoc.setText(idProfissioanl.getNome());
	}
}
