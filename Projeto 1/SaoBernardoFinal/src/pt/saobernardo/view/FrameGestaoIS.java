package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pt.saobernardo.controller.GestorIS;
import pt.saobernardo.controller.GestorSala;
import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.InstituicaoSolidariedade;
import pt.saobernardo.model.Sala;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class FrameGestaoIS extends JFrame {

	private JPanel contentPane;
	private JTextField txtIS;

	

	/**
	 * Create the frame.
	 */
	public FrameGestaoIS() {
		setTitle("Gest\u00E3o de Institui\u00E7\u00F5es de Solidariedade - S\u00E3o Bernardo Perdidos e Achados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 160, 154));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSala = new JLabel("Institui\u00E7\u00E3o de Solidariedade");
		lblSala.setHorizontalAlignment(SwingConstants.LEFT);
		lblSala.setBounds(179, 43, 160, 14);
		contentPane.add(lblSala);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (InstituicaoSolidariedade is : SaoBernardo.instituicoes) {
			dlm.addElement(is.getNomeIs());
		}
		
		
		
		JList list = new JList(dlm);
		JScrollPane scrollPane = new JScrollPane(list);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				txtIS.setText(list.getSelectedValue().toString());
			}
		});
		scrollPane.setBounds(337, 86, 173, 142);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Remover_20_pixeis.png")));
		btnNewButton.setIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Remover_clareado_20_pixeis.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorIS.removerIS(txtIS.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Instituição removida com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Instituição não existente!");
				}
				
			}
		});
		
		
		btnNewButton.setBounds(421, 247, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnInserir = new JButton("");
		btnInserir.setRolloverIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Inserir_20_pixeis.png")));
		btnInserir.setIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Inserir_clareado_20_pixeis.png")));
		btnInserir.setFocusable(false);
		btnInserir.setContentAreaFilled(false);
		btnInserir.setBorder(null);
		btnInserir.setBackground(SystemColor.menu);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorIS.inserirIS(txtIS.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Instituição inserida com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Instituição já existente!");
				}
			}
		});
		btnInserir.setBounds(179, 247, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnSair = new JButton("");
		btnSair.setRolloverIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Sair_20_pixeis.png")));
		btnSair.setIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Sair_clareado_20_pixeis.png")));
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
		btnSair.setBounds(421, 293, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setRolloverIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Alterar_20_pixeis.png")));
		btnAlterar.setIcon(new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Alterar_clareado_20_pixeis.png")));
		btnAlterar.setFocusable(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GestorIS.alterarIS(list.getSelectedValue().toString(),txtIS.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Instituição alterada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro na alteração!");
				}
			}
		});
		btnAlterar.setBounds(300, 247, 89, 23);
		contentPane.add(btnAlterar);
		
		txtIS = new JTextField();
		txtIS.setBounds(337, 43, 173, 20);
		contentPane.add(txtIS);
		txtIS.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("", new ImageIcon(FrameGestaoIS.class.getResource("/pt/saobernardo/resource/Logo s fundo.png")), JLabel.CENTER);
		lblNewLabel.setBounds(10, 43, 167, 152);
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
