package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class NovoController implements ActionListener{

	private String var = "";
	
	public String getVar() {
		return var;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		var = JOptionPane.showInputDialog("Nome do Projeto:");
		
	}

}
