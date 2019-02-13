package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import pt.saobernardo.controller.GestorSala;
import pt.saobernardo.controller.GestorUtilizador;
import pt.saobernardo.controller.SaoBernardo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.JPasswordField;

public class FrameInserirUtilizador extends JFrame {

	private JPanel contentPane;
	private JTextField txtUtilizador;
	private JLabel lblPassword;
	private JLabel lblConfirmarPassword;
	private JButton btnSair;
	private JButton btnGravar;
	private JLabel label;
	private JPasswordField txtPasse;
	private JPasswordField txtConfirmarPasse;

	/**
	 * Create the frame.
	 */
	public FrameInserirUtilizador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameInserirUtilizador.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setTitle("Inserir Novo Utilizador - S\u00E3o Bernardo Perdidos e Achados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUtilizador = new JTextField();
		txtUtilizador.setBounds(313, 86, 183, 20);
		contentPane.add(txtUtilizador);
		txtUtilizador.setColumns(10);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameGestaoUtilizador fgu = new FrameGestaoUtilizador();
				fgu.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(423, 201, 73, 23);
		contentPane.add(btnSair);
		
		btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPasse.getText().equals(txtConfirmarPasse.getText())) {
					if (GestorUtilizador.inserirUtilizador(txtUtilizador.getText(),txtPasse.getText(),FrameGestaoUtilizador.txtNome.getText()) == true) {
						JOptionPane.showMessageDialog(null, "Utilizador inserido com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Utilizador já existente!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "As duas passwords não coincidem!");
				}
				
			}
		});
		btnGravar.setBounds(313, 201, 73, 23);
		contentPane.add(btnGravar);
		
		txtConfirmarPasse = new JPasswordField();
		txtConfirmarPasse.setBounds(313, 163, 183, 20);
		contentPane.add(txtConfirmarPasse);
		
		txtPasse = new JPasswordField();
		txtPasse.setBounds(313, 124, 183, 20);
		contentPane.add(txtPasse);
		
		lblConfirmarPassword = new JLabel("Confirmar Password");
		lblConfirmarPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarPassword.setBounds(172, 166, 151, 14);
		contentPane.add(lblConfirmarPassword);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(221, 127, 76, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Utilizador");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(221, 89, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrameInserirUtilizador.class.getResource("/pt/saobernardo/resource/Fundo Login.png")));
		label.setBounds(16, 52, 518, 211);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameInserirUtilizador.class.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		lblNewLabel.setBounds(-9, -13, 575, 376);
		contentPane.add(lblNewLabel);
	}

}
