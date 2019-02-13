package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import pt.saobernardo.controller.GestorRegisto;
import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.ObjetoPerdido;
import pt.saobernardo.model.Registo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class FrameReclamacao extends JFrame {

	private JPanel contentPane;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable tableReclamacao;
	private JTextField txtDescricao;

	/**
	 * Create the frame.
	 */
	public FrameReclamacao() {

		setTitle("Reclama\u00E7\u00E3o S\u00E3oBernardo - Perdidos e achados ");
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
		

		txtDescricao = new JTextField();
		txtDescricao.setBounds(190, 231, 340, 54);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		

		JLabel lblSB = new JLabel(
				"",
				new ImageIcon(
						FrameReclamacao.class
								.getResource("/pt/saobernardo/resource/Logo s fundo.png")),
				JLabel.CENTER);
		lblSB.setBounds(10, 33, 158, 159);
		lblSB.setVerticalTextPosition(JLabel.BOTTOM);
		lblSB.setHorizontalTextPosition(JLabel.CENTER);
		contentPane.add(lblSB);

		// Cria os cabeçalhos da tabela
		dtm.addColumn("Cor");
		dtm.addColumn("Estado");
		dtm.addColumn("Sala");
		dtm.addColumn("Data");
		dtm.addColumn("Descrição");
		dtm.addColumn("Código");

		// Associa o TableModel à tabela
		tableReclamacao = new JTable(dtm);
		tableReclamacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableReclamacao.getSelectedRow();
				String desc = tableReclamacao.getValueAt(row, 4).toString();
				txtDescricao.setText(desc);
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 70, 340, 150);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableReclamacao);
		tableReclamacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableReclamacao.setPreferredScrollableViewportSize(new Dimension(500,
				50));
		tableReclamacao.setFillsViewportHeight(true);
		
		//Ocultar a coluna da descrição na tabela
		tableReclamacao.getColumnModel().getColumn(4).setMinWidth(0);
		tableReclamacao.getColumnModel().getColumn(4).setMaxWidth(0);
		
		//Ocultar a coluna do codigo na tabela
		tableReclamacao.getColumnModel().getColumn(5).setMinWidth(0);
		tableReclamacao.getColumnModel().getColumn(5).setMaxWidth(0);
		

		// Cria as linhas da tabela iterando sobre a lista de registos por omissão
		//Faz com que apareçam todos os registos sem estar nenhum objeto na comboBox selecionado
		for (int i = 0; i < SaoBernardo.registos.size(); i++) {
			Registo r = SaoBernardo.registos.get(i);
			dtm.addRow(new Object[] { r.getCor(), r.getEstado(),
					r.getS().getSala(), r.getData(), r.getDescricao(),r.getCodigo()});

		}

		JComboBox comboBoxObjetoTipo = new JComboBox();
		comboBoxObjetoTipo.setToolTipText("");
		comboBoxObjetoTipo.setBounds(320, 33, 210, 20);
		for (ObjetoPerdido op : SaoBernardo.objetos) {
			comboBoxObjetoTipo.addItem(op);
		}
		comboBoxObjetoTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxObjetoTipo.getSelectedIndex() != -1) {

					// Limpa o TableModel
					dtm.setRowCount(0);

					// Itera sobre todos os registos e adiciona ao tableModel
					// apenas aqueles que contem o texto selecionado na
					// ComboBox

					for (int i = 0; i < SaoBernardo.registos.size(); i++) {
						Registo r = SaoBernardo.registos.get(i);
						if (r.getO()
								.getObjetoTipo()
								.contains(
										comboBoxObjetoTipo.getSelectedItem()
												.toString())) {
							dtm.addRow(new Object[] { r.getCor(),
									r.getEstado(), r.getS().getSala(),
									r.getData(), r.getDescricao(), r.getCodigo() });
						}
					}

				}
			}

		});
		comboBoxObjetoTipo.setSelectedIndex(-1);
		contentPane.add(comboBoxObjetoTipo);

		JLabel lblTipoDeObjeto = new JLabel("Tipo de objeto");
		lblTipoDeObjeto.setBounds(190, 33, 97, 14);
		lblTipoDeObjeto.setForeground(Color.WHITE);
		lblTipoDeObjeto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblTipoDeObjeto);

		JButton btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(FrameReclamacao.class.getResource("/pt/saobernardo/resource/Cancelar.png")));
		btnCancelar.setIcon(new ImageIcon(FrameReclamacao.class.getResource("/pt/saobernardo/resource/Cancelar_clareado.png")));
		btnCancelar.setFocusable(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(392, 296, 138, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

		JButton btnInformacao = new JButton("");
		btnInformacao.setRolloverIcon(new ImageIcon(FrameReclamacao.class.getResource("/pt/saobernardo/resource/EntregarObjeto_30_pixeis.png")));
		btnInformacao.setIcon(new ImageIcon(FrameReclamacao.class.getResource("/pt/saobernardo/resource/EntregarObjeto_clareado_30_pixeis.png")));
		btnInformacao.setFocusable(false);
		btnInformacao.setContentAreaFilled(false);
		btnInformacao.setBorder(null);
		btnInformacao.setBackground(SystemColor.menu);
		btnInformacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tableReclamacao.getSelectedRow();
				String cod = tableReclamacao.getValueAt(row, 5).toString();
				int codigo = Integer.parseInt(cod);
				GestorRegisto.entregarObjeto(codigo);
				JOptionPane.showMessageDialog(null, "Objeto Entregue!");
			}
		});
		btnInformacao.setBounds(190, 296, 138, 23);
		contentPane.add(btnInformacao);
		contentPane.add(btnCancelar);

		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(-23, -20, 582, 382);
		labelFundo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundo.setIcon(new ImageIcon(FrameLogin.class
				.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		contentPane.add(labelFundo);
	}
}
