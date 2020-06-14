package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProfissionalController;
import model.entity.Profissional;

import javax.swing.JComboBox;

public class ComboProfissionalPorCategoria extends JFrame {

	private JPanel contentPane;
	private ProfissionalController profissionalController = new ProfissionalController();
	private ArrayList<Profissional> profissionais = new ArrayList<Profissional>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboProfissionalPorCategoria frame = new ComboProfissionalPorCategoria();
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
	public ComboProfissionalPorCategoria() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(profissionais.toArray());
		comboBox.setBounds(152, 107, 144, 22);
		contentPane.add(comboBox);
	}

	public void getDados(int idCategoria) {
		profissionais = profissionalController.listarProfissionaisPorCategoria(idCategoria);
		
		
	}

}
