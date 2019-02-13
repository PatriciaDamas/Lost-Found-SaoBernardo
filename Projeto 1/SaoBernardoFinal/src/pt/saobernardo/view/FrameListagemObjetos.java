package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;

import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.ObjetoPerdido;
import pt.saobernardo.model.Registo;
import pt.saobernardo.model.Sala;

import java.awt.Rectangle;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class FrameListagemObjetos extends JFrame {

	private JPanel contentPane;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable tableListagem;
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;

	/**
	 * Create the frame.
	 */
	public FrameListagemObjetos() {

		setTitle("Listagem de objetos S\u00E3oBernardo - Perdidos e achados ");
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
		dtm.addColumn("Objeto");
		dtm.addColumn("Cor");
		dtm.addColumn("Estado");
		dtm.addColumn("Sala");
		dtm.addColumn("Data");
		dtm.addColumn("Descrição");
		dtm.addColumn("Código");

		// Associa o TableModel à tabela
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 146, 350, 150);
		contentPane.add(scrollPane);
		tableListagem = new JTable(dtm);
		tableListagem.setLocation(174, 0);
		scrollPane.setViewportView(tableListagem);
		tableListagem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableListagem
				.setPreferredScrollableViewportSize(new Dimension(500, 50));
		tableListagem.setFillsViewportHeight(true);

		// Ocultar a coluna da descrição na tabela
		tableListagem.getColumnModel().getColumn(5).setMinWidth(0);
		tableListagem.getColumnModel().getColumn(5).setMaxWidth(0);

		// Ocultar a coluna do codigo na tabela
		tableListagem.getColumnModel().getColumn(6).setMinWidth(0);
		tableListagem.getColumnModel().getColumn(6).setMaxWidth(0);

		// Cria as linhas da tabela iterando sobre a lista de registos por
		// omissão
		// Faz com que apareçam todos os registos sem estar nenhum objeto na
		// comboBox selecionado
		for (int i = 0; i < SaoBernardo.registos.size(); i++) {
			Registo r = SaoBernardo.registos.get(i);
			dtm.addRow(new Object[] { r.getO().getObjetoTipo(), r.getCor(),
					r.getEstado(), r.getS().getSala(), r.getData(),
					r.getDescricao(), r.getCodigo() });

		}

		JButton btnCancelar = new JButton("");
		btnCancelar
				.setRolloverIcon(new ImageIcon(
						FrameListagemObjetos.class
								.getResource("/pt/saobernardo/resource/Cancelar_20_pixeis.png")));
		btnCancelar
				.setIcon(new ImageIcon(
						FrameListagemObjetos.class
								.getResource("/pt/saobernardo/resource/Cancelar_clareado_20_pixeis.png")));
		btnCancelar.setFocusable(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameMenu fm = new FrameMenu();
				fm.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(432, 309, 90, 23);
		contentPane.add(btnCancelar);
		

		JCheckBox chckbxOrdenarPorTipo = new JCheckBox(
				"Ordenar por tipo de objeto");
		chckbxOrdenarPorTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (ObjetoPerdido op : SaoBernardo.objetos) {

				}
			}
		});
		chckbxOrdenarPorTipo.setBounds(172, 116, 186, 23);
		contentPane.add(chckbxOrdenarPorTipo);

		JComboBox comboBoxSala = new JComboBox();
		// comboBoxSala.setToolTipText();
		comboBoxSala.setBounds(432, 89, 90, 20);
		for (Sala s : SaoBernardo.salas) {
			comboBoxSala.addItem(s);
		}
		comboBoxSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBoxSala.setSelectedIndex(-1);
		contentPane.add(comboBoxSala);

		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {
				"Estado", "Bom", "Mau", "Razo\u00E1vel" }));
		comboBoxEstado.setBounds(432, 40, 90, 20);
		comboBoxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxEstado.setSelectedIndex(-1);
		contentPane.add(comboBoxEstado);

		JComboBox comboBoxCor = new JComboBox();
		comboBoxCor.setBounds(302, 89, 90, 20);
		comboBoxCor.setModel(new DefaultComboBoxModel(new String[] { "Cor",
				"Azul", "Amarelo", "Branco", "Castanho", "Cinzento",
				"Cor-de-Laranja", "Cor-de-Rosa", "Preto", "Roxo", "Verde",
				"Vermelho" }));
		comboBoxCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		comboBoxCor.setSelectedIndex(-1);
		contentPane.add(comboBoxCor);

		JComboBox comboBoxObjeto = new JComboBox();
		comboBoxObjeto.setToolTipText("");
		comboBoxObjeto.setBounds(302, 40, 90, 20);
		for (ObjetoPerdido op : SaoBernardo.objetos) {
			comboBoxObjeto.addItem(op);
		}
		comboBoxObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBoxObjeto.setSelectedIndex(-1);
		contentPane.add(comboBoxObjeto);

		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(172, 40, 90, 20);
		contentPane.add(txtDataInicial);
		txtDataInicial.setColumns(10);

		txtDataFinal = new JTextField();
		txtDataFinal.setColumns(10);
		txtDataFinal.setBounds(172, 89, 90, 20);
		contentPane.add(txtDataFinal);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCor.setForeground(Color.WHITE);
		lblCor.setBounds(302, 74, 46, 14);
		contentPane.add(lblCor);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(432, 27, 46, 14);
		contentPane.add(lblEstado);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < SaoBernardo.registos.size(); i++) {
					Registo r = SaoBernardo.registos.get(i);
					if (r.getO()
							.getObjetoTipo()
							.contains(
									comboBoxObjeto.getSelectedItem().toString())
							&& r.getCor().contains(
									comboBoxCor.getSelectedItem().toString())
							&& r.getS()
									.getSala()
									.contains(
											comboBoxSala.getSelectedItem()
													.toString())
							&& r.getEstado()
									.contains(
											comboBoxEstado.getSelectedItem()
													.toString())) {
						dtm.setRowCount(0);
						dtm.addRow(new Object[] { r.getO().getObjetoTipo(),
								r.getCor(), r.getEstado(), r.getS().getSala(),
								r.getData(), r.getDescricao(), r.getCodigo() });
					}
				}
			}
		});
		btnFiltrar.setBounds(50, 273, 89, 23);
		contentPane.add(btnFiltrar);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setForeground(Color.WHITE);
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSala.setBounds(432, 74, 46, 14);
		contentPane.add(lblSala);

		JLabel lblObjeto = new JLabel("Objeto:");
		lblObjeto.setForeground(Color.WHITE);
		lblObjeto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObjeto.setBounds(302, 27, 46, 14);
		contentPane.add(lblObjeto);

		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setForeground(Color.WHITE);
		lblDataFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataFinal.setBounds(172, 74, 78, 14);
		contentPane.add(lblDataFinal);

		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataInicial.setForeground(Color.WHITE);
		lblDataInicial.setBounds(172, 27, 78, 14);
		contentPane.add(lblDataInicial);

		JLabel lblPerdidosNos = new JLabel("nos ultimos 30 dias");
		lblPerdidosNos.setForeground(Color.WHITE);
		lblPerdidosNos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPerdidosNos.setBounds(20, 220, 153, 23);
		contentPane.add(lblPerdidosNos);

		JLabel lblTodosOsObjetos = new JLabel("os objetos perdidos");
		lblTodosOsObjetos.setForeground(Color.WHITE);
		lblTodosOsObjetos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTodosOsObjetos.setBounds(20, 198, 153, 20);
		contentPane.add(lblTodosOsObjetos);

		JLabel lblListagemDe = new JLabel("Listagem de todos");
		lblListagemDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListagemDe.setForeground(Color.WHITE);
		lblListagemDe.setBounds(20, 178, 119, 20);
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

	private void refreshTable() {
		dtm.setRowCount(0);
		for (Registo r : SaoBernardo.registos) {

		}
	}
}
