package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.OrdemServicoController;
import model.details.CadastroOS;
import model.entity.Categoria;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.OrdemServico;
import model.entity.Profissional;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class TelaPDF extends JFrame {

	private JPanel contentPane;
	private JLabel lblNumeroOSDoc;
	private JLabel lblClienteDoc;
	private JLabel lblEnderecoDoc;
	private JLabel lblDescricaoDoc;
	private JLabel lblDataInicialDoc;
	private JLabel lblDataPrevistaTerminoDoc;
	private JLabel lblCategoriaDoc;
	private JLabel lblProfissionalDoc;
	private OrdemServicoController ordemServicoController = new OrdemServicoController();
	private CadastroOS modelOS = new CadastroOS();
	private Date dataAtual = new Date();

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

		lblNumeroOSDoc = new JLabel("");
		lblNumeroOSDoc.setBounds(271, 188, 105, 14);
		panel.add(lblNumeroOSDoc);

		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(190, 227, 56, 16);
		panel.add(lblCliente);

		lblClienteDoc = new JLabel();
		lblClienteDoc.setBounds(264, 227, 313, 16);
		panel.add(lblClienteDoc);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(190, 267, 71, 16);
		panel.add(lblEndereco);

		lblEnderecoDoc = new JLabel("");
		lblEnderecoDoc.setVerticalAlignment(SwingConstants.TOP);
		lblEnderecoDoc.setBounds(94, 290, 526, 77);
		panel.add(lblEnderecoDoc);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(190, 389, 71, 16);
		panel.add(lblDescricao);

		lblDescricaoDoc = new JLabel(modelOS.getDescricao());
		lblDescricaoDoc.setVerticalAlignment(SwingConstants.TOP);
		lblDescricaoDoc.setBounds(257, 388, 320, 70);
		panel.add(lblDescricaoDoc);

		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setBounds(190, 493, 71, 16);
		panel.add(lblDataInicial);

		lblDataInicialDoc = new JLabel("");
		lblDataInicialDoc.setBounds(190, 520, 105, 16);
		panel.add(lblDataInicialDoc);

		JLabel lblDataPrevistaTermino = new JLabel("Data Prevista de Término:");
		lblDataPrevistaTermino.setBounds(379, 493, 159, 16);
		panel.add(lblDataPrevistaTermino);

		lblDataPrevistaTerminoDoc = new JLabel("");
		lblDataPrevistaTerminoDoc.setBounds(379, 520, 127, 16);
		panel.add(lblDataPrevistaTerminoDoc);

		JLabel lblCategoria = new JLabel("Categoria (s):");
		lblCategoria.setBounds(190, 565, 86, 16);
		panel.add(lblCategoria);

		lblCategoriaDoc = new JLabel("");
		lblCategoriaDoc.setBounds(190, 590, 387, 16);
		panel.add(lblCategoriaDoc);

		JLabel lblProfissional = new JLabel("Profissionais :");
		lblProfissional.setBounds(190, 635, 117, 16);
		panel.add(lblProfissional);

		lblProfissionalDoc = new JLabel("");
		lblProfissionalDoc.setBounds(190, 660, 387, 16);
		panel.add(lblProfissionalDoc);

		JLabel lblDocPDF = new JLabel("");
		lblDocPDF.setIcon(new ImageIcon(TelaPDF.class.getResource("/icones/folha-de-papel-branco.jpg")));
		lblDocPDF.setBounds(-49, 110, 736, 743);
		panel.add(lblDocPDF);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String msg = ordemServicoController.cadastrarOS(modelOS);
				JOptionPane.showMessageDialog(null, msg);
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

	private String carregarCategorias(ArrayList<Categoria> categorias) {
		String cats = "";
		for (int i = 0; i < categorias.size(); i++) {
			if (i != 0) {
				cats += ", " + categorias.get(i).toString();
			} else {
				cats += categorias.get(i).toString();
			}
		}
		return cats;
	}

	private String carregarProfissionais(ArrayList<Profissional> profissionais) {
		String profs = "";
		for (int i = 0; i < profissionais.size(); i++) {
			if (i != 0) {
				profs += ", " + profissionais.get(i).toString();
			} else {
				profs += profissionais.get(i).toString();
			}
		}
		return profs;
	}

	public CadastroOS enviarDados(CadastroOS cadOS) {
		String ano = new SimpleDateFormat("/yyyy").format(dataAtual);
		cadOS.setNumeroOS(cadOS.getNumeroOS()+ano);
		lblNumeroOSDoc.setText(cadOS.getNumeroOS());
		lblClienteDoc.setText(cadOS.getCliente().toString());
		lblEnderecoDoc.setText(cadOS.getEndereco().toString());
		lblDescricaoDoc.setText(cadOS.getDescricao());
		lblDataInicialDoc.setText(cadOS.getDataInicio().toString());
		lblDataPrevistaTerminoDoc.setText(cadOS.getDataPrevistaFim().toString());
		lblCategoriaDoc.setText(carregarCategorias(cadOS.getCategorias()));
		lblProfissionalDoc.setText(carregarProfissionais(cadOS.getProfissionais()));

		return modelOS = cadOS;

	}
}
