package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JComboBox;

import pt.saobernardo.controller.GestorObjeto;
import pt.saobernardo.controller.GestorSala;
import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.InstituicaoSolidariedade;
import pt.saobernardo.model.ObjetoPerdido;
import pt.saobernardo.model.Sala;
import java.awt.SystemColor;

public class FrameGestaoObjetos extends JFrame {

	private JPanel contentPane;
	private JTextField txtObjeto;

	/**
	 * Create the frame.
	 */
	public FrameGestaoObjetos() {
		
		setTitle("Gest\u00E3o de Objetos - S\u00E3o Bernardo Perdidos e Achados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 160, 154));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxIS = new JComboBox();
		for (InstituicaoSolidariedade is : SaoBernardo.instituicoes) {
			comboBoxIS.addItem(is);
		}
		comboBoxIS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		comboBoxIS.setBounds(310, 69, 210, 20);
		contentPane.add(comboBoxIS);		
		
		DefaultListModel<ObjetoPerdido> dlm = new DefaultListModel<ObjetoPerdido>();
		for (ObjetoPerdido op : SaoBernardo.objetos) {
			dlm.addElement(op);
		}

		
		JList<ObjetoPerdido> list = new JList<ObjetoPerdido>(dlm);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				txtObjeto.setText(list.getSelectedValue().toString());
				ObjetoPerdido objPerdido = list.getSelectedValue();
				InstituicaoSolidariedade is = objPerdido.getIs();
				comboBoxIS.setSelectedItem(is);
			}
		});
		list.setBounds(310, 109, 210, 124);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setRolloverIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Remover_20_pixeis.png")));
		btnNewButton.setIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Remover_clareado_20_pixeis.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					if (GestorObjeto.removerObjeto(txtObjeto.getText()) == true) {
						JOptionPane.showMessageDialog(null, "Objeto removido com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "Objeto não existente!");
					}
			}
		});
		btnNewButton.setBounds(431, 244, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnInserir = new JButton("");
		btnInserir.setRolloverIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Inserir_20_pixeis.png")));
		btnInserir.setIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Inserir_clareado_20_pixeis.png")));
		btnInserir.setFocusable(false);
		btnInserir.setContentAreaFilled(false);
		btnInserir.setBorder(null);
		btnInserir.setBackground(SystemColor.menu);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (GestorObjeto.inserirObjeto(txtObjeto.getText(),comboBoxIS.getSelectedItem()) == true) {
					JOptionPane.showMessageDialog(null, "Objeto inserido com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Objeto já existente!");
				}
			}
		});
		btnInserir.setBounds(189, 244, 89, 23);
		contentPane.add(btnInserir);
		
		
		
		JButton btnSair = new JButton("");
		btnSair.setRolloverIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Sair_20_pixeis.png")));
		btnSair.setIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Sair_clareado_20_pixeis.png")));
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
		btnSair.setBounds(431, 280, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setRolloverIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Alterar_20_pixeis.png")));
		btnAlterar.setIcon(new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Alterar_clareado_20_pixeis.png")));
		btnAlterar.setFocusable(false);
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(SystemColor.menu);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (GestorObjeto.alterarObjeto(list.getSelectedValue().toString(), txtObjeto.getText(), comboBoxIS.getSelectedItem()) == true){
					JOptionPane.showMessageDialog(null, "Objeto alterado com sucesso!");
				} else if (GestorObjeto.alterarObjeto(list.getSelectedValue().toString(), txtObjeto.getText(), comboBoxIS.getSelectedItem()) == false){
					JOptionPane.showMessageDialog(null, "Instituição alterada com sucesso!");
				}
			}
		});
		btnAlterar.setBounds(310, 244, 89, 23);
		contentPane.add(btnAlterar);
		
		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o");
		lblInstituio.setBounds(189, 69, 115, 14);
		contentPane.add(lblInstituio);
		
		JLabel lblObjetoTipo = new JLabel("Objeto Tipo");
		lblObjetoTipo.setBounds(189, 38, 89, 14);
		contentPane.add(lblObjetoTipo);
		
		txtObjeto = new JTextField();
		txtObjeto.setColumns(10);
		txtObjeto.setBounds(310, 38, 210, 20);
		contentPane.add(txtObjeto);
		
		
		JLabel lblNewLabel = new JLabel("", new ImageIcon(FrameGestaoObjetos.class.getResource("/pt/saobernardo/resource/Logo s fundo.png")), JLabel.CENTER);
		lblNewLabel.setBounds(12, 38, 167, 152);
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
