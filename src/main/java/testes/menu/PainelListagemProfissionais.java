package testes.menu;

import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.event.ActionEvent;

public class PainelListagemProfissionais extends JPanel {
	
	PainelCadastroProfissional painelCadProf = new PainelCadastroProfissional();
	

	/**
	 * Create the panel.
	 */
	public PainelListagemProfissionais() {
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TODO
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addComponent(btAdicionar)
					.addContainerGap(193, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(138)
					.addComponent(btAdicionar)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		

	}
	
}
