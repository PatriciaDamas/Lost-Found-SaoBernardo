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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class FrameConfiguracoesMenu extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FrameConfiguracoesMenu() {
		setTitle("Menu Configura\u00E7\u00F5es - S\u00E3o Bernardo Perdidos e Achados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 160, 154));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnGestaoSalas = new JButton("");
		btnGestaoSalas.setRolloverIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeSalas_balao_30_pixeis.png")));
		btnGestaoSalas.setIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeSalas_clareado_30_pixeis.png")));
		btnGestaoSalas.setFocusable(false);
		btnGestaoSalas.setContentAreaFilled(false);
		btnGestaoSalas.setBorder(null);
		btnGestaoSalas.setBackground(SystemColor.menu);
		btnGestaoSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameGestaoSalas fgs = new FrameGestaoSalas();
				fgs.setVisible(true);
				dispose();
			}
		});
		btnGestaoSalas.setBounds(90, 54, 170, 23);
		contentPane.add(btnGestaoSalas);
		
		JButton btnGestaoUtilizadores = new JButton("");
		btnGestaoUtilizadores.setRolloverIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeUtilizadores_balao_30_pixeis.png")));
		btnGestaoUtilizadores.setIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeUtilizadores_clareado_30_pixeis.png")));
		btnGestaoUtilizadores.setFocusable(false);
		btnGestaoUtilizadores.setContentAreaFilled(false);
		btnGestaoUtilizadores.setBorder(null);
		btnGestaoUtilizadores.setBackground(SystemColor.menu);
		btnGestaoUtilizadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameGestaoUtilizador fgu = new FrameGestaoUtilizador();
				fgu.setVisible(true);
				dispose();
			}
		});
		btnGestaoUtilizadores.setBounds(202, 180, 170, 23);
		contentPane.add(btnGestaoUtilizadores);
		
		JButton btnGestaoObjetos = new JButton("");
		btnGestaoObjetos.setRolloverIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeObjetos_balao_30_pixeis.png")));
		btnGestaoObjetos.setIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeObjetos_clareada_30_pixeis.png")));
		btnGestaoObjetos.setFocusable(false);
		btnGestaoObjetos.setContentAreaFilled(false);
		btnGestaoObjetos.setBorder(null);
		btnGestaoObjetos.setBackground(SystemColor.menu);
		btnGestaoObjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameGestaoObjetos fgo = new FrameGestaoObjetos();
				fgo.setVisible(true);
				dispose();
			}
		});
		btnGestaoObjetos.setBounds(202, 136, 170, 23);
		contentPane.add(btnGestaoObjetos);
		
		JButton btnGestaoIs = new JButton("");
		btnGestaoIs.setRolloverIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeIS_balao_30_pixeis.png")));
		btnGestaoIs.setIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/GestaoDeIS_clareada_30_pixeis.png")));
		btnGestaoIs.setFocusable(false);
		btnGestaoIs.setContentAreaFilled(false);
		btnGestaoIs.setBorder(null);
		btnGestaoIs.setBackground(SystemColor.menu);
		btnGestaoIs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameGestaoIS fgis = new FrameGestaoIS();
				fgis.setVisible(true);
				dispose();
			}
		});
		btnGestaoIs.setBounds(157, 95, 170, 23);
		contentPane.add(btnGestaoIs);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/Cancelar.png")));
		btnCancelar.setIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/Cancelar_clareado.png")));
		btnCancelar.setFocusable(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMenu fm = new FrameMenu();
				fm.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(393, 296, 138, 30);
		contentPane.add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrameConfiguracoesMenu.class.getResource("/pt/saobernardo/resource/cara.png")));
		label.setBounds(10, 95, 150, 150);
		contentPane.add(label);
		
		JLabel labelFundo = new JLabel("");
		labelFundo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundo.setIcon(new ImageIcon(FrameLogin.class.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		labelFundo.setBounds(-11, -12, 563, 370);
		contentPane.add(labelFundo);
		
	}
}
