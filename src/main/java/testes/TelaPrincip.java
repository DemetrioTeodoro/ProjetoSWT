package testes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class TelaPrincip extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincip frame = new TelaPrincip();
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
	public TelaPrincip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGerenciamento = new JMenu("Gerenciamento");
		mnGerenciamento.setIcon(new ImageIcon(TelaPrincip.class.getResource("/icones/icons8-gerente-de-informa\u00E7\u00F5es-do-cliente.png")));
		menuBar.add(mnGerenciamento);
		
		JMenuItem mntmServios_3 = new JMenuItem("Servi\u00E7os");
		mnGerenciamento.add(mntmServios_3);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setIcon(new ImageIcon(TelaPrincip.class.getResource("/icones/icons8-adicionar-48.png")));
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmProfissionais = new JMenuItem("Profissionais");
		mnCadastrar.add(mntmProfissionais);
		
		JMenuItem mntmServios = new JMenuItem("Servi\u00E7os");
		mnCadastrar.add(mntmServios);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		mnAtualizar.setIcon(new ImageIcon(TelaPrincip.class.getResource("/icones/settings-icon.png")));
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmProfissionais_1 = new JMenuItem("Profissionais");
		mnAtualizar.add(mntmProfissionais_1);
		
		JMenuItem mntmServios_1 = new JMenuItem("Servi\u00E7os");
		mnAtualizar.add(mntmServios_1);
		
		JMenu mnRemover = new JMenu("Remover");
		mnRemover.setIcon(new ImageIcon(TelaPrincip.class.getResource("/icones/icons8-excluir-26.png")));
		menuBar.add(mnRemover);
		
		JMenuItem mntmProfissionais_2 = new JMenuItem("Profissionais");
		mnRemover.add(mntmProfissionais_2);
		
		JMenuItem mntmServios_2 = new JMenuItem("Servi\u00E7os");
		mnRemover.add(mntmServios_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
