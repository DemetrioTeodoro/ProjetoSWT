package testes.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.CategoriaController;
import controller.ProfissionalController;
import helpers.Estados;
import model.BO.CategoriaBO;
import model.entity.Categoria;
import model.entity.Profissional;

import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaCadEditProfissional extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JComboBox<Categoria> cbCategoria;
	private JComboBox<String> cbEstado;
	private JButton btnLimpar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadEditProfissional frame = new TelaCadEditProfissional();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TelaCadEditProfissional() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(21, 11, 86, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(112, 11, 86, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		final JRadioButton rdbDesativar = new JRadioButton("New radio button");
		rdbDesativar.setBounds(203, 10, 109, 23);
		getContentPane().add(rdbDesativar);
		
		
		
		txtRua = new JTextField();
		txtRua.setBounds(21, 78, 86, 20);
		getContentPane().add(txtRua);
		txtRua.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(127, 78, 86, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(223, 78, 86, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(31, 109, 86, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		Estados siglasEstados =new Estados();
		final JComboBox<String> cbEstado = new JComboBox(siglasEstados.consultarEstados().toArray());
		cbEstado.setBounds(137, 109, 41, 20);
		getContentPane().add(cbEstado);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(127, 168, 86, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(31, 168, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		CategoriaController catControl = new CategoriaController();
		
		final JComboBox<Categoria> cbCategoria = new JComboBox(catControl.listarCategorias().toArray());
		cbCategoria.setBounds(42, 212, 79, 20);
		getContentPane().add(cbCategoria);
		
		txtCep = new JTextField();
		txtCep.setBounds(223, 109, 86, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(63, 271, 63, 23);
		getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(172, 271, 63, 23);
		getContentPane().add(btnLimpar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfissionalController control = new ProfissionalController();
//				String mensagem = control.salvar(txtNome.getText(), txtCpf.getText(), rdbDesativar.isSelected(),
//				txtEmail.getText(), txtTelefone.getText(), txtCep.getText(), txtRua.getText(), txtNumero.getText(), 
//				txtBairro.getText(), txtCidade.getText(), (String)cbEstado.getSelectedItem(), (Categoria)cbCategoria.getSelectedItem());
//				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
	}
}
