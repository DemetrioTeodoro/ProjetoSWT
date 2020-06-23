package helpers;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldSomenteNumeros extends JTextField {

	private int maximoCaracteres = -1;// definição de -1 como valor normal de um textfield sem limite de caracters
	
	public JTextFieldSomenteNumeros() {
		        super();
		        addKeyListener(new java.awt.event.KeyAdapter() {
		            @Override
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        jTextFieldKeyTyped(evt);}});
		    }
	
	private void jTextFieldKeyTyped(KeyEvent evt) {
		       
		String caracteres="0987654321";// lista de caracters que não devem ser aceitos
		if(!caracteres.contains(evt.getKeyChar()+"")){// se o caracter que gerou o evento estiver não estiver na lista
		
		evt.consume();//aciona esse propriedade para eliminar a ação do evento
		}
		if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
		
		evt.consume();
		setText(getText().substring(0,getMaximoCaracteres()));
		
		}
		        }

	public int getMaximoCaracteres() {
		return maximoCaracteres;
	}

	public void setMaximoCaracteres(int maximoCaracteres) {
		this.maximoCaracteres = maximoCaracteres;
	}
}
