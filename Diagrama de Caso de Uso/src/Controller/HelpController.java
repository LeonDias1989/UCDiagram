package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class HelpController implements ActionListener {

	public void actionPerformed(ActionEvent actionEvent) {

		JOptionPane.showMessageDialog(null,
				"https://github.com/LeonDias1989/UCDiagram" + "\n\n"
						+ "\tVisite este Repositório no GitHub");
	}

}
