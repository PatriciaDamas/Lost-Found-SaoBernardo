package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DropMode;
import javax.swing.SwingConstants;

import pt.saobernardo.controller.GestorUtilizador;

import java.awt.Toolkit;
import java.awt.Button;
import java.awt.event.KeyEvent;
import java.awt.Insets;
import java.awt.Component;
import java.awt.SystemColor;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUtilzador;
	private JPasswordField txtPalavraPasse;
	

	
	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		setTitle("Login S\u00E3oBernardo - Perdidos e achados ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 160, 154));
		contentPane.setBorder(null);
		contentPane.setBorder(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setHorizontalAlignment(SwingConstants.LEFT);
		lblUtilizador.setBounds(240, 100, 61, 30);
		contentPane.add(lblUtilizador);
		
		JLabel lblPalavrapasse = new JLabel("Palavra-passe");
		lblPalavrapasse.setHorizontalAlignment(SwingConstants.LEFT);
		lblPalavrapasse.setBounds(240, 141, 92, 30);
		contentPane.add(lblPalavrapasse);
		
		txtUtilzador = new JTextField();
		txtUtilzador.setHorizontalAlignment(SwingConstants.CENTER);
		txtUtilzador.setBackground(new Color(255, 255, 255));
		txtUtilzador.setBounds(342, 105, 152, 20);
		contentPane.add(txtUtilzador);
		txtUtilzador.setColumns(10);
		
		txtPalavraPasse = new JPasswordField();
		txtPalavraPasse.setHorizontalAlignment(SwingConstants.CENTER);
		txtPalavraPasse.setBackground(new Color(255, 255, 255));
		txtPalavraPasse.setBounds(342, 146, 152, 20);
		contentPane.add(txtPalavraPasse);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Sair_15_pixeis.png")));
		btnNewButton.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Sair_15_pixeis_clareado.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(425, 192, 69, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEntrar = new JButton("");
		btnEntrar.setRolloverIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Entrar_15_pixeis.png")));
		btnEntrar.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Entrar_15_pixeis_clareado.png")));
		btnEntrar.setFocusable(false);
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setBorder(null);
		btnEntrar.setBackground(SystemColor.menu);
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//if (GestorUtilizador.procuraUtilizador(txtUtilzador.getText(), txtPalavraPasse.getText()) == true) {
					FrameMenu fm = new FrameMenu();
					fm.setVisible(true);
					dispose();
				//} else {
				//	JOptionPane.showMessageDialog(null, "Utilizador inexistente");
				//}
			}
		});
		btnEntrar.setBounds(342, 192, 69, 23);
		contentPane.add(btnEntrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Fundo Login.png")));
		label.setBounds(20, 55, 514, 198);
		contentPane.add(label);
		
		JLabel labelFundo = new JLabel("");
		labelFundo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundo.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		labelFundo.setBounds(0, 0, 534, 311);
		contentPane.add(labelFundo);
		
	}
}
