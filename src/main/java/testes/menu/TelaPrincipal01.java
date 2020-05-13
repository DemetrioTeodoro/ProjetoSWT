package testes.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPrincipal01 extends JFrame {

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
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOS = new JMenu("Ordem de Servi\u00E7o");
		menuBar.add(mnOS);
		
		JMenuItem mnitCadOs = new JMenuItem("Cadastro");
		mnOS.add(mnitCadOs);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Edi\u00E7\u00E3o");
		mnOS.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta");
		mnOS.add(mntmNewMenuItem_1);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mnitCadCliente = new JMenuItem("Cadastro");
		mnClientes.add(mnitCadCliente);
		
		JMenuItem mnitEditCliente = new JMenuItem("Edi\u00E7\u00E3o");
		mnClientes.add(mnitEditCliente);
		
		JMenuItem mnitListCliente = new JMenuItem("Consulta");
		mnClientes.add(mnitListCliente);
		
		JMenu mnEmpresa = new JMenu("Empresa");
		menuBar.add(mnEmpresa);
		
		JMenuItem mnitCategorias = new JMenuItem("Categorias");
		mnEmpresa.add(mnitCategorias);
		
		JMenuItem mnitProfissionais = new JMenuItem("Profissionais");
		mnEmpresa.add(mnitProfissionais);
		
		JMenu mnAgenda = new JMenu("Agenda");
		menuBar.add(mnAgenda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
