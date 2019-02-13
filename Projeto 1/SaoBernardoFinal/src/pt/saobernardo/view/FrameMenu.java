package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pt.saobernardo.controller.GestorUtilizador;
import pt.saobernardo.controller.SaoBernardo;

import javax.swing.JEditorPane;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameMenu() {
		
		setTitle("Login S\u00E3oBernardo - Perdidos e achados ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 160, 154));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReclamacaoObjeto = new JButton("");
		btnReclamacaoObjeto.setRolloverIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Reclamacao_do_objeto_balao_30_pixeis.png")));
		btnReclamacaoObjeto.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Reclamacao_do_objeto_clareado_30_pixeis.png")));
		btnReclamacaoObjeto.setFocusable(false);
		btnReclamacaoObjeto.setContentAreaFilled(false);
		btnReclamacaoObjeto.setBorder(null);
		btnReclamacaoObjeto.setBackground(SystemColor.menu);
		btnReclamacaoObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameReclamacao fr = new FrameReclamacao();
				fr.setVisible(true);
				//dispose();
			}
		});
		btnReclamacaoObjeto.setBounds(157, 95, 170, 23);
		contentPane.add(btnReclamacaoObjeto);
		
		
		JButton btnListagens = new JButton("");
		btnListagens.setRolloverIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Listagens_balao_30_pixeis.png")));
		btnListagens.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Listagens_clareado_30_pixeis.png")));
		btnListagens.setFocusable(false);
		btnListagens.setContentAreaFilled(false);
		btnListagens.setBorder(null);
		btnListagens.setBackground(SystemColor.menu);
		btnListagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameListagemObjetos flo = new FrameListagemObjetos();
				flo.setVisible(true);
				//dispose();
				
			}
		});
		btnListagens.setBounds(202, 136, 170, 23);
		contentPane.add(btnListagens);
		
		JButton btnDoacoes = new JButton("");
		btnDoacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameDoacoes fd = new FrameDoacoes();
				fd.setVisible(true);
			}
		});
		btnDoacoes.setRolloverIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Doacoes_balao_30_pixeis.png")));
		btnDoacoes.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Doacoes_clareado_30_pixeis.png")));
		btnDoacoes.setFocusable(false);
		btnDoacoes.setContentAreaFilled(false);
		btnDoacoes.setBorder(null);
		btnDoacoes.setBackground(SystemColor.menu);
		btnDoacoes.setBounds(202, 180, 170, 23);
		contentPane.add(btnDoacoes);
		
		JButton btnImportacao = new JButton("");
		btnImportacao.setRolloverIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Importacao_balao_30_pixeis.png")));
		btnImportacao.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Importacao_30_pixeis_clariado.png")));
		btnImportacao.setFocusable(false);
		btnImportacao.setContentAreaFilled(false);
		btnImportacao.setBorder(null);
		btnImportacao.setBackground(SystemColor.menu);
		btnImportacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameImportacao fi = new FrameImportacao();
				fi.setVisible(true);
				//dispose();
			}
		});
		btnImportacao.setBounds(157, 222, 170, 23);
		contentPane.add(btnImportacao);
		
		JButton btnConfiguracoes = new JButton("");
		btnConfiguracoes.setRolloverIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Configuracoes_balao_30_pixeis.png")));
		btnConfiguracoes.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Configuracoes_30_pixeis_clariado.png")));
		btnConfiguracoes.setFocusable(false);
		btnConfiguracoes.setContentAreaFilled(false);
		btnConfiguracoes.setBorder(null);
		btnConfiguracoes.setBackground(SystemColor.menu);
		btnConfiguracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameConfiguracoesMenu fcm = new FrameConfiguracoesMenu();
				fcm.setVisible(true);
				//dispose();
			}
		});
		btnConfiguracoes.setBounds(90, 263, 170, 23);
		contentPane.add(btnConfiguracoes);
		
		JButton btnRegistoObjeto = new JButton("");
		btnRegistoObjeto.setRolloverIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Registo_do_objeto_balao_30_pixeis.png")));
		btnRegistoObjeto.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Registo_do_objeto_30_pixeis_clariado.png")));
		btnRegistoObjeto.setFocusable(false);
		btnRegistoObjeto.setContentAreaFilled(false);
		btnRegistoObjeto.setBorder(null);
		btnRegistoObjeto.setBackground(SystemColor.menu);
		btnRegistoObjeto.setForeground(Color.BLACK);
		btnRegistoObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameRegisto fr = new FrameRegisto();
				fr.setVisible(true);
				//dispose();
			}
		});
		btnRegistoObjeto.setBounds(90, 54, 170, 23);
		contentPane.add(btnRegistoObjeto);
		
		JLabel lblOl = new JLabel("Ol\u00E1!");
		lblOl.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOl.setForeground(Color.WHITE);
		lblOl.setBounds(396, 126, 66, 23);
		contentPane.add(lblOl);
		
		JLabel lblNewLabel_1 = new JLabel("Bem-vindo ao sistema");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(396, 151, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDePerdidosE = new JLabel("de perdidos e achados");
		lblDePerdidosE.setForeground(Color.WHITE);
		lblDePerdidosE.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblDePerdidosE.setVerticalAlignment(SwingConstants.TOP);
		lblDePerdidosE.setBounds(396, 175, 130, 23);
		contentPane.add(lblDePerdidosE);
		
		JLabel lblDaEseig = new JLabel("da ESEIG.");
		lblDaEseig.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblDaEseig.setForeground(Color.WHITE);
		lblDaEseig.setBounds(396, 191, 130, 23);
		contentPane.add(lblDaEseig);
		
		JButton btnTerminarSessao = new JButton("");
		btnTerminarSessao.setRolloverIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Terminar_sessao_30_pixeis.png")));
		btnTerminarSessao.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/Terminar_sessao_Clareado_30_pixeis.png")));
		btnTerminarSessao.setFocusable(false);
		btnTerminarSessao.setContentAreaFilled(false);
		btnTerminarSessao.setBorder(null);
		btnTerminarSessao.setBackground(SystemColor.menu);
		btnTerminarSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameLogin fl = new FrameLogin();
				fl.setVisible(true);
				//dispose();
				try {
				SaoBernardo.saveInstituicoes();
				SaoBernardo.saveObjeto();
				SaoBernardo.saveSalas();
				SaoBernardo.saveUtilizadores();
				SaoBernardo.saveRegisto();
				SaoBernardo.saveDoacao();
				
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTerminarSessao.setBounds(393, 296, 140, 23);
		contentPane.add(btnTerminarSessao);
		
		
		
		//Mostra o dia a data e a hora quando é iniciado o programa
		JLabel lblDataHora = new JLabel("");
		lblDataHora.setText(SaoBernardo.dataHoraFormato);
		lblDataHora.setForeground(Color.WHITE);
		lblDataHora.setBounds(368, 22, 140, 14);
		contentPane.add(lblDataHora);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/cara.png")));
		label.setBounds(10, 95, 150, 150);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrameMenu.class.getResource("/pt/saobernardo/resource/IconUser.png")));
		label_1.setBounds(503, 18, 23, 23);
		contentPane.add(label_1);
		
		JLabel labelFundo = new JLabel("");
		labelFundo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundo.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		labelFundo.setBounds(-11, -12, 563, 370);
		contentPane.add(labelFundo);
		
	}
}
