package testes.menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPDF extends JFrame {

	private JPanel contentPane;

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
		
		JLabel label = new JLabel("Numero OS:");
		label.setBounds(190, 187, 71, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("numero");
		label_1.setBounds(272, 187, 56, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Cliente:");
		label_2.setBounds(190, 216, 56, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("nome");
		label_3.setBounds(246, 216, 56, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("CPF:");
		label_4.setBounds(342, 216, 56, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("CpfDoc");
		label_5.setBounds(380, 216, 56, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Cep:");
		label_6.setBounds(190, 255, 56, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("CepDoc");
		label_7.setBounds(224, 255, 56, 16);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Bairro:");
		label_8.setBounds(319, 255, 56, 16);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("BairroDoc");
		label_9.setBounds(365, 255, 56, 16);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Rua:");
		label_10.setBounds(190, 296, 56, 16);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("NomeRua");
		label_11.setBounds(224, 296, 316, 16);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Numero:");
		label_12.setBounds(190, 336, 56, 16);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("numero endereco");
		label_13.setBounds(246, 336, 101, 16);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("Descri\u00E7\u00E3o:");
		label_14.setBounds(190, 388, 71, 16);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("descricaoDoc");
		label_15.setBounds(257, 388, 283, 71);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("Data Inicial:");
		label_16.setBounds(190, 493, 71, 16);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("dataInicialDoc");
		label_17.setBounds(273, 493, 74, 16);
		panel.add(label_17);
		
		JLabel label_18 = new JLabel("Data Final:");
		label_18.setBounds(380, 493, 71, 16);
		panel.add(label_18);
		
		JLabel label_19 = new JLabel("dataFinalDocResult");
		label_19.setBounds(453, 493, 65, 16);
		panel.add(label_19);
		
		JLabel label_20 = new JLabel("Categoria:");
		label_20.setBounds(190, 546, 71, 16);
		panel.add(label_20);
		
		JLabel label_21 = new JLabel("categoriaDocResult");
		label_21.setBounds(257, 546, 109, 16);
		panel.add(label_21);
		
		JLabel label_22 = new JLabel("Categoria:");
		label_22.setBounds(190, 587, 71, 16);
		panel.add(label_22);
		
		JLabel label_23 = new JLabel("categoriaDocResult2");
		label_23.setBounds(257, 587, 109, 16);
		panel.add(label_23);
		
		JLabel label_24 = new JLabel("Profissional:");
		label_24.setBounds(190, 648, 71, 16);
		panel.add(label_24);
		
		JLabel label_25 = new JLabel("profissionalDoc");
		label_25.setBounds(272, 648, 94, 16);
		panel.add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon(TelaPDF.class.getResource("/icones/folha-de-papel-branco.jpg")));
		label_26.setBounds(36, 125, 736, 743);
		panel.add(label_26);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(766, 612, 97, 25);
		contentPane.add(btnConfirmar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(766, 578, 97, 25);
		contentPane.add(btnFechar);
		setUndecorated(true);
	}
}
