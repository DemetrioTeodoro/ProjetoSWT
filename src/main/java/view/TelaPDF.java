package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrdemServicoController;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.OrdemServico;
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
	private ArrayList<Categoria> categoriasTela;
	private ArrayList<Profissional> profissionaisTela;
	private Cliente clienteTela;
	private JLabel lblNomeRua;
	private OrdemServicoController ordemServicoController = new OrdemServicoController();

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
		lblNome.setBounds(246, 216, 175, 16);
		panel.add(lblNome);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(446, 216, 56, 16);
		panel.add(lblCPF);

		lblCpfDoc = new JLabel("CpfDoc");
		lblCpfDoc.setBounds(484, 216, 121, 16);
		panel.add(lblCpfDoc);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(190, 255, 56, 16);
		panel.add(lblCep);

		lblCepDoc = new JLabel("CepDoc");
		lblCepDoc.setBounds(224, 255, 83, 16);
		panel.add(lblCepDoc);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(319, 255, 56, 16);
		panel.add(lblBairro);

		lblBairroDoc = new JLabel("BairroDoc");
		lblBairroDoc.setBounds(365, 255, 201, 16);
		panel.add(lblBairroDoc);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(190, 296, 56, 16);
		panel.add(lblRua);

		lblNomeRua = new JLabel("NomeRua");
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
		lblCategoriaDoc.setBounds(257, 546, 261, 16);
		panel.add(lblCategoriaDoc);

		JLabel lblCategoria2 = new JLabel("Categoria:");
		lblCategoria2.setBounds(190, 587, 71, 16);
		panel.add(lblCategoria2);

		lblCategoriaDoc2 = new JLabel("categoriaDocResult2");
		lblCategoriaDoc2.setBounds(257, 587, 248, 16);
		panel.add(lblCategoriaDoc2);

		JLabel lblProfissional = new JLabel("Profissional:");
		lblProfissional.setBounds(190, 648, 71, 16);
		panel.add(lblProfissional);

		lblProfissionalDoc = new JLabel("profissionalDoc");
		lblProfissionalDoc.setBounds(272, 648, 246, 16);
		panel.add(lblProfissionalDoc);

		JLabel lblDocPDF = new JLabel("");
		lblDocPDF.setIcon(new ImageIcon(TelaPDF.class.getResource("/icones/folha-de-papel-branco.jpg")));
		lblDocPDF.setBounds(36, 125, 736, 743);
		panel.add(lblDocPDF);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			private String descricao;

			public void actionPerformed(ActionEvent arg0) {
				String numeroOS = lblNumeroOSDoc.getText();
				String cep = lblCepDoc.getText();
				String bairro = lblBairroDoc.getText();
				String rua = lblNomeRua.getText();
				String numero = lblNumeroEndDoc.getText();
				if (lblDescricaoDoc.getText() != null) {
					descricao = lblDescricaoDoc.getText();
				}
				LocalDate dataInicial = LocalDate.parse(lblDataInicialDoc.getText());
				LocalDate dataPrevistaFinal = LocalDate.parse(lblDataFinalDoc.getText());
				/*
				 * int idCategoria = categorias.getId(); int idProfissioanl =
				 * profissionais.getId();
				 */

				Endereco endereco = new Endereco();
				endereco.setCep(cep);
				endereco.setBairro(bairro);
				endereco.setRua(rua);
				endereco.setNumero(numero);

				OrdemServico ordemServico = new OrdemServico();
				ordemServico.setCategorias(categoriasTela);
				ordemServico.setCliente(clienteTela);
				ordemServico.setEndereco(endereco);
				ordemServico.setProfissionais(profissionaisTela);
				ordemServico.setDataInicio(dataInicial);
				ordemServico.setDataPrevistaFim(dataPrevistaFinal);
				ordemServico.setDescricao(descricao);

				//ordemServico = ordemServicoController.cadastrarOS(ordemServico);
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

	public void getDados(String numeroOS, Cliente clientes, String descricao, LocalDate dataInicial,
			LocalDate dataPrevistaFinal, ArrayList<Categoria> categorias, ArrayList<Profissional> profissionais,
			Endereco endereco) {
		categoriasTela = categorias;
		profissionaisTela = profissionais;
		clienteTela = clientes;

		lblDescricaoDoc.setText(descricao);
		lblBairroDoc.setText(endereco.getBairro());
		lblDataInicialDoc.setText(dataInicial.toString());
		lblDataFinalDoc.setText(dataPrevistaFinal.toString());
		lblCepDoc.setText(endereco.getCep());
		lblNomeRua.setText(endereco.getRua());
		lblNumeroEndDoc.setText(endereco.getNumero());
		for (int i = 0; i < profissionais.size(); i++) {
			lblProfissionalDoc.setText(profissionais.toString());
			
		}
		lblCategoriaDoc.setText(categorias.toString());
	}

	/*
	 * public void getDados(String numeroOS, Cliente cliente, String descricao,
	 * LocalDate dataInicial, LocalDate dataPrevistaFinal, Categoria categoria,
	 * Profissional profissional, Endereco endereco) {
	 * 
	 * categoriasTela = categorias; profissionais = profissionais; clientes =
	 * cliente;
	 * 
	 * lblDescricaoDoc.setText(descricao);
	 * lblBairroDoc.setText(endereco.getBairro());
	 * lblDataInicialDoc.setText(dataInicial.toString());
	 * lblDataFinalDoc.setText(dataPrevistaFinal.toString());
	 * lblCepDoc.setText(endereco.getCep()); lblNomeRua.setText(endereco.getRua());
	 * lblNumeroEndDoc.setText(endereco.getNumero());
	 * lblCategoriaDoc.setText(categoria.getNome());
	 * lblProfissionalDoc.setText(profissional.getNome()); }
	 */

}
