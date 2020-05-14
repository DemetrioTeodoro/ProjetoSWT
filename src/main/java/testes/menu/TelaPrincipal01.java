package testes.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class TelaPrincipal01 extends JFrame {

	private PainelCadastroOS painelCadastroOS = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal01 frame = new TelaPrincipal01();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal01() {
		setTitle("GeTask: Gerencimento de Servi\u00E7os de Constru\u00E7\u00E3o Civil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOS = new JMenu("Ordem de Servi\u00E7o");
		mnOS.setIcon(new ImageIcon(TelaPrincipal01.class.getResource("/icones/icons8-ordem-de-compra-50.png")));
		menuBar.add(mnOS);
		
		JMenuItem mnitCadOs = new JMenuItem("Cadastro");
		mnitCadOs.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (painelCadastroOS == null) {
					painelCadastroOS = new PainelCadastroOS();
					contentPane.add(painelCadastroOS);
					validate();
				}
			}
		});
		mnitCadOs.setIcon(new ImageIcon(TelaPrincipal01.class.getResource("/icones/icons8-adicionar-48.png")));
		mnOS.add(mnitCadOs);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Edi\u00E7\u00E3o");
		mnOS.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta");
		mnOS.add(mntmNewMenuItem_1);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(TelaPrincipal01.class.getResource("/icones/icons8-gest\u00E3o-de-cliente-64.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mnitCadCliente = new JMenuItem("Cadastro");
		mnClientes.add(mnitCadCliente);
		
		JMenuItem mnitEditCliente = new JMenuItem("Edi\u00E7\u00E3o");
		mnClientes.add(mnitEditCliente);
		
		JMenuItem mnitListCliente = new JMenuItem("Consulta");
		mnClientes.add(mnitListCliente);
		
		JMenu mnEmpresa = new JMenu("Empresa");
		mnEmpresa.setIcon(new ImageIcon(TelaPrincipal01.class.getResource("/icones/icons8-organiza\u00E7\u00E3o-50.png")));
		menuBar.add(mnEmpresa);
		
		JMenuItem mnitCategorias = new JMenuItem("Categorias");
		mnEmpresa.add(mnitCategorias);
		
		JMenuItem mnitProfissionais = new JMenuItem("Profissionais");
		mnEmpresa.add(mnitProfissionais);
		
		JMenu mnAgenda = new JMenu("Agenda");
		mnAgenda.setIcon(new ImageIcon(TelaPrincipal01.class.getResource("/icones/icons8-calendar-50.png")));
		menuBar.add(mnAgenda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new SpringLayout());
	}

}
