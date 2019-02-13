package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

import pt.saobernardo.controller.GestorIS;
import pt.saobernardo.controller.GestorUtilizador;
import pt.saobernardo.controller.SaoBernardo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class FrameGestaoUtilizador extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNome;
	private JTextField txtUtilizador;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public FrameGestaoUtilizador() {
		setTitle("Gest\u00E3o de Utilizadores - S\u00E3o Bernardo Perdidos e Achados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setRolloverIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Inserir_20_pixeis.png")));
		button.setIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Inserir_clareado_20_pixeis.png")));
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBackground(SystemColor.menu);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameInserirUtilizador fiu = new FrameInserirUtilizador();
				fiu.setVisible(true);
				dispose();
			}
		});
		button.setBounds(205, 257, 89, 23);
		contentPane.add(button);
		
		JButton button_2 = new JButton("");
		button_2.setRolloverIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Alterar_20_pixeis.png")));
		button_2.setIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Alterar_clareado_20_pixeis.png")));
		button_2.setFocusable(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setBackground(SystemColor.menu);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAlterarPasse fap = new FrameAlterarPasse();
				fap.setVisible(true);
				dispose();
			}
		});
		
		JButton button_3 = new JButton("");
		button_3.setRolloverIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Remover_20_pixeis.png")));
		button_3.setIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Remover_clareado_20_pixeis.png")));
		button_3.setFocusable(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		button_3.setBackground(SystemColor.menu);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GestorUtilizador.removerUtilizador(txtUtilizador.getText(),txtNome.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Utilizador removida com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Utilizador não existente!");
				}
			}
		});
		button_3.setBounds(434, 257, 89, 23);
		contentPane.add(button_3);
		button_2.setBounds(320, 257, 89, 23);
		contentPane.add(button_2);
		
		JButton button_4 = new JButton("");
		button_4.setRolloverIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Sair_20_pixeis.png")));
		button_4.setIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Sair_clareado_20_pixeis.png")));
		button_4.setFocusable(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorder(null);
		button_4.setBackground(SystemColor.menu);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameConfiguracoesMenu fcm = new FrameConfiguracoesMenu();
				fcm.setVisible(true);
				dispose();
			}
		});
		button_4.setBounds(434, 291, 89, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setRolloverIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Acessos_20_pixeis.png")));
		button_5.setIcon(new ImageIcon(FrameGestaoUtilizador.class.getResource("/pt/saobernardo/resource/Acessos_clareado_20_pixeis.png")));
		button_5.setFocusable(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setBackground(SystemColor.menu);
		button_5.setBounds(55, 257, 89, 23);
		contentPane.add(button_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Seguran\u00E7a", "Institui\u00E7\u00E3o"}));
		comboBox.setBounds(310, 27, 213, 20);
		contentPane.add(comboBox);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(310, 58, 213, 20);
		contentPane.add(txtNome);
		
		txtUtilizador = new JTextField();
		txtUtilizador.setColumns(10);
		txtUtilizador.setBounds(310, 88, 213, 20);
		contentPane.add(txtUtilizador);
		
		table = new JTable();
		table.setBounds(205, 119, 318, 122);
		contentPane.add(table);
		
		JLabel label_2 = new JLabel("Tipo de Utilizador");
		label_2.setBounds(205, 33, 115, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Nome");
		label_3.setBounds(205, 64, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Utilizador");
		label_4.setBounds(205, 94, 57, 14);
		contentPane.add(label_4);
		
		JLabel label_1 = new JLabel("de cada utilizador!");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(41, 227, 140, 14);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("Gerir os acessos");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(50, 202, 122, 14);
		contentPane.add(label);
		
		
		
		
		JLabel lblNewLabel = new JLabel("", new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Logo s fundo.png")), JLabel.CENTER);
		lblNewLabel.setBounds(10, 27, 167, 152);
		lblNewLabel.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(0, -11, 546, 354);
		labelFundo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundo.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		contentPane.add(labelFundo);
		
		
	}
}
