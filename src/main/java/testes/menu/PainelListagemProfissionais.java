package testes.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelListagemProfissionais extends JPanel {
	
	private TelaCadastroProfissional telaCadastroProfissional = new TelaCadastroProfissional();
	

	/**
	 * Create the panel.
	 */
	public PainelListagemProfissionais() {
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastroProfissional.setVisible(true);
				telaCadastroProfissional.setLocationRelativeTo(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(172)
					.addComponent(btAdicionar)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(200, Short.MAX_VALUE)
					.addComponent(btAdicionar)
					.addGap(77))
		);
		setLayout(groupLayout);
		

	}
	
}
