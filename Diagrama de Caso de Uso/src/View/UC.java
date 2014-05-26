package View;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;

public class UC extends JFrame {
	private JTextField textField;

	public UC() {
		setTitle("UC Diagram");

		iniciarMenuNORTH();
		iniciarMenuWEST();
		iniciarMenuCENTER();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 768);
		setVisible(true);

	}

	private void iniciarMenuWEST() {

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);

		String projeto = "Projeto";
		String ator = "Ator";
		String casoDeUso = "Caso de Uso";

		DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(projeto);
		treeNode.add(new DefaultMutableTreeNode(ator));
		treeNode.add(new DefaultMutableTreeNode(casoDeUso));

		DefaultTreeModel treeModel = new DefaultTreeModel(treeNode);

		JTree tree = new JTree(treeModel);

		getContentPane().add(panel, BorderLayout.WEST);

		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNome = new JLabel("Nome");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnOk = new JButton("OK");

		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														tree,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		btnOk)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		btnCancelar))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblNome)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		textField,
																		GroupLayout.DEFAULT_SIZE,
																		97,
																		Short.MAX_VALUE))
												.addComponent(lblEditar))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(tree, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED,
										549, Short.MAX_VALUE)
								.addComponent(lblEditar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNome)
												.addComponent(
														textField,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(btnOk)
												.addComponent(btnCancelar))
								.addGap(52)));
		panel.setLayout(gl_panel);

	}

	private void iniciarMenuCENTER() {

		JInternalFrame internalFrame = new JInternalFrame("Tela");
		internalFrame.setEnabled(false);
		internalFrame.getContentPane().setBackground(SystemColor.text);

		JToolBar toolBar = new JToolBar();
		toolBar.setToolTipText("Barra de Ferramentas");
		toolBar.setBackground(SystemColor.text);

		JToggleButton tgButtonSelectionar = new JToggleButton("");
		tgButtonSelectionar.setToolTipText("Selecionar");
		tgButtonSelectionar
				.setIcon(new ImageIcon(
						"C:\\Users\\Leon Dias\\Documents\\GitHub\\UCDiagram\\Diagrama de Caso de Uso\\src\\Images\\CursorIcon.gif"));
		toolBar.add(tgButtonSelectionar);

		JToggleButton tgButtonActor = new JToggleButton("");
		tgButtonActor.setToolTipText("Ator");
		tgButtonActor
				.setIcon(new ImageIcon(
						"C:\\Users\\Leon Dias\\Documents\\GitHub\\UCDiagram\\Diagrama de Caso de Uso\\src\\Images\\Actor.png"));
		toolBar.add(tgButtonActor);

		JToggleButton tgButtonElipse = new JToggleButton("");
		tgButtonElipse.setToolTipText("Use Case");
		tgButtonElipse
				.setIcon(new ImageIcon(
						"C:\\Users\\Leon Dias\\Documents\\GitHub\\UCDiagram\\Diagrama de Caso de Uso\\src\\Images\\elipse.png"));
		toolBar.add(tgButtonElipse);

		JToggleButton tgButtonArrow = new JToggleButton("");
		tgButtonArrow
				.setIcon(new ImageIcon(
						"C:\\Users\\Leon Dias\\Documents\\GitHub\\UCDiagram\\Diagrama de Caso de Uso\\src\\Images\\right_arrow.png"));
		toolBar.add(tgButtonArrow);

		JToggleButton tgButtonExtends = new JToggleButton("");
		tgButtonExtends.setToolTipText("extends");
		tgButtonExtends
				.setIcon(new ImageIcon(
						"C:\\Users\\Leon Dias\\Documents\\GitHub\\UCDiagram\\Diagrama de Caso de Uso\\src\\Images\\extends.jpg"));
		toolBar.add(tgButtonExtends);

		ButtonGroup buttonGroup = new ButtonGroup();

		buttonGroup.add(tgButtonActor);
		buttonGroup.add(tgButtonElipse);
		buttonGroup.add(tgButtonArrow);
		buttonGroup.add(tgButtonExtends);
		buttonGroup.add(tgButtonSelectionar);

		// CONFIG. LAYOUT

		GroupLayout groupLayout = new GroupLayout(
				internalFrame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(toolBar,
				GroupLayout.PREFERRED_SIZE, 1266, GroupLayout.PREFERRED_SIZE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(613, Short.MAX_VALUE)));
		internalFrame.getContentPane().setLayout(groupLayout);

		internalFrame.setVisible(true);
		internalFrame.setClosable(false);

		getContentPane().add(internalFrame, BorderLayout.CENTER);
	}

	private void iniciarMenuNORTH() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('a');
		menuBar.add(mnArquivo);

		JMenuItem mntmNovo = new JMenuItem("Novo");
		mntmNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnArquivo.add(mntmNovo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				InputEvent.CTRL_MASK));
		mnArquivo.add(mntmSair);

		JMenu mnHelp = new JMenu("Help");
		JMenuItem mntmSobreOUc = new JMenuItem("Sobre o UC...");
		mnHelp.add(mntmSobreOUc);

		Component glue = Box.createGlue();
		glue.setBackground(SystemColor.text);
		menuBar.add(glue);
		menuBar.add(mnHelp);

	}

}
