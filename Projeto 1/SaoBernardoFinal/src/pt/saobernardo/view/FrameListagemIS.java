package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrameListagemIS extends JFrame {

	private JPanel contentPane;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable tableListagemDoacoes;
	/**
	 * Create the frame.
	 */
	public FrameListagemIS() {
		setTitle("Listagem de objetos Doados S\u00E3oBernardo - Perdidos e achados ");
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						FrameLogin.class
								.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 160, 154));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Cria os cabeçalhos da tabela
				/*dtm.addColumn("Objeto");
				dtm.addColumn("Cor");
				dtm.addColumn("Estado");
				dtm.addColumn("Sala");
				dtm.addColumn("Data");
				dtm.addColumn("Instituição");*/
				

		JLabel lblTodosOsObjetos = new JLabel("os objetos doados!");
		lblTodosOsObjetos.setForeground(Color.WHITE);
		lblTodosOsObjetos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTodosOsObjetos.setBounds(29, 195, 153, 20);
		contentPane.add(lblTodosOsObjetos);

		JLabel lblListagemDe = new JLabel("Listagem de todos");
		lblListagemDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListagemDe.setForeground(Color.WHITE);
		lblListagemDe.setBounds(29, 177, 119, 20);
		contentPane.add(lblListagemDe);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				FrameListagemObjetos.class
						.getResource("/pt/saobernardo/resource/Logo sem fundo Listagens.png")));
		label.setBounds(20, 24, 128, 128);
		contentPane.add(label);

		JLabel label_Fundo = new JLabel("");
		label_Fundo.setIcon(new ImageIcon(FrameListagemObjetos.class
				.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		label_Fundo.setBounds(-12, 0, 570, 354);
		contentPane.add(label_Fundo);
		
	}

}
