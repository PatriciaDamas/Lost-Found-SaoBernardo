package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameAlterarPasse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	

	/**
	 * Create the frame.
	 */
	public FrameAlterarPasse() {
		setTitle("Alterar Utilizador - S\u00E3o Bernardo Perdidos e Achados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameInserirUtilizador.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(330, 86, 162, 20);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(330, 170, 162, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(330, 129, 162, 20);
		contentPane.add(passwordField_1);
		
		JButton button = new JButton("Inserir");
		button.setBounds(330, 207, 73, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Sair");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameGestaoUtilizador fgu = new FrameGestaoUtilizador();
				fgu.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(419, 207, 73, 23);
		contentPane.add(button_1);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUtilizador.setBounds(229, 86, 91, 14);
		contentPane.add(lblUtilizador);
		
		JLabel lblNovaPassword = new JLabel("Nova Password");
		lblNovaPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaPassword.setBounds(229, 129, 91, 14);
		contentPane.add(lblNovaPassword);
		
		JLabel lblConfirmarNovaPassword = new JLabel("Confirmar Nova Password");
		lblConfirmarNovaPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarNovaPassword.setBounds(178, 170, 142, 14);
		contentPane.add(lblConfirmarNovaPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrameAlterarPasse.class.getResource("/pt/saobernardo/resource/Fundo Login.png")));
		lblNewLabel_1.setBounds(16, 52, 518, 211);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameInserirUtilizador.class.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		lblNewLabel.setBounds(-9, -13, 575, 376);
		contentPane.add(lblNewLabel);
		
		
		
		
	}
}
