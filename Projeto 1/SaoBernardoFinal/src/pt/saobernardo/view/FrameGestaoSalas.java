package pt.saobernardo.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pt.saobernardo.controller.GestorSala;
import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.Sala;
import java.awt.SystemColor;

public class FrameGestaoSalas extends JFrame {

	private JPanel contentPane;
	private JTextField txtSala;


	/**
	 * Create the frame.
	 */
	public FrameGestaoSalas() {
		setTitle("Gest\u00E3o de Salas - S\u00E3o Bernardo Perdidos e Achados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 160, 154));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setHorizontalAlignment(SwingConstants.LEFT);
		lblSala.setBounds(198, 70, 46, 14);
		contentPane.add(lblSala);
		
		
		
		txtSala = new JTextField();
		txtSala.setBounds(261, 67, 86, 20);
		contentPane.add(txtSala);
		txtSala.setColumns(10);
		
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (Sala s : SaoBernardo.salas) {
			dlm.addElement(s.getSala());
		}
		
		JList listsalas = new JList(dlm);
		JScrollPane scrollPaneList = new JScrollPane(listsalas);
		listsalas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				txtSala.setText(listsalas.getSelectedValue().toString());
			}
		});
		scrollPaneList.setBounds(382, 67, 127, 152);
		contentPane.add(scrollPaneList);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Remover_20_pixeis.png")));
		btnNewButton.setIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Remover_clareado_20_pixeis.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorSala.removerSala(txtSala.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Sala removida com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Sala não existente!");
				}
				
			}
		});
		btnNewButton.setBounds(420, 241, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnInserir = new JButton("");
		btnInserir.setRolloverIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Inserir_20_pixeis.png")));
		btnInserir.setIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Inserir_clareado_20_pixeis.png")));
		btnInserir.setFocusable(false);
		btnInserir.setContentAreaFilled(false);
		btnInserir.setBorder(null);
		btnInserir.setBackground(SystemColor.menu);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorSala.inserirSala(txtSala.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Sala inserida com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Sala já existente!");
				}
				
			}
		});
		btnInserir.setBounds(198, 241, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnSair = new JButton("");
		btnSair.setRolloverIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Sair_20_pixeis.png")));
		btnSair.setIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Sair_clareado_20_pixeis.png")));
		btnSair.setFocusable(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setBorder(null);
		btnSair.setBackground(SystemColor.menu);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameConfiguracoesMenu fcm = new FrameConfiguracoesMenu();
				fcm.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(420, 285, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setRolloverIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Alterar_20_pixeis.png")));
		btnAlterar.setIcon(new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Alterar_clareado_20_pixeis.png")));
		btnAlterar.setFocusable(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GestorSala.alterarSala(listsalas.getSelectedValue().toString(),txtSala.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Sala alterada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro na alteração da sala!");
				}
				
			}
		});
		btnAlterar.setBounds(310, 241, 89, 23);
		contentPane.add(btnAlterar);
		
		
		JLabel lblNewLabel = new JLabel("", new ImageIcon(FrameGestaoSalas.class.getResource("/pt/saobernardo/resource/Logo s fundo.png")), JLabel.CENTER);
		lblNewLabel.setBounds(21, 67, 167, 152);
		lblNewLabel.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
		contentPane.add(lblNewLabel);
		
		
		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(-11, -12, 563, 370);
		labelFundo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundo.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		contentPane.add(labelFundo);
		
		
	}
}
