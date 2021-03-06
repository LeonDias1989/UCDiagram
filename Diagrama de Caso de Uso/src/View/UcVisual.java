package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import Controller.HelpController;
import Controller.NovoController;
import Controller.SairController;

public class UcVisual extends JFrame {
	private JTextField textField;

	public UcVisual() {
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
		GroupLayout groupLayoutPanel = new GroupLayout(panel);
		groupLayoutPanel.setHorizontalGroup(groupLayoutPanel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						groupLayoutPanel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										groupLayoutPanel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														tree,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														groupLayoutPanel.createSequentialGroup()
																.addComponent(
																		btnOk)
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addComponent(
																		btnCancelar))
												.addGroup(
														groupLayoutPanel.createSequentialGroup()
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
		groupLayoutPanel.setVerticalGroup(groupLayoutPanel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						groupLayoutPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(tree, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED,
										549, Short.MAX_VALUE)
								.addComponent(lblEditar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										groupLayoutPanel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNome)
												.addComponent(
														textField,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										groupLayoutPanel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(btnOk)
												.addComponent(btnCancelar))
								.addGap(52)));
		panel.setLayout(groupLayoutPanel);

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

		/**CONTRUIDO MENU-BAR*/
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('a');
		menuBar.add(mnArquivo);

		JMenuItem menuItemNovo = new JMenuItem("Novo");
		menuItemNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mnArquivo.add(menuItemNovo);
		
		/** Listener to new use case project*/
		menuItemNovo.addActionListener(new NovoController());

		JMenuItem menuItemSair = new JMenuItem("Sair");
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				InputEvent.CTRL_MASK));
		mnArquivo.add(menuItemSair);
		
		/** Listener to exit program*/
		menuItemSair.addActionListener(new SairController());

		JMenu menuItemHelp = new JMenu("Help");
		JMenuItem mntmSobreOUc = new JMenuItem("Sobre o UC...");
		
		menuItemHelp.add(mntmSobreOUc);
		
		/** Listener to Help Menu*/
		mntmSobreOUc.addActionListener(new HelpController());

		Component glue = Box.createGlue();
		glue.setBackground(SystemColor.text);
		menuBar.add(glue);
		menuBar.add(menuItemHelp);
		

	}

}
