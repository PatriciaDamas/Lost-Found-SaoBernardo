package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pt.saobernardo.controller.GestorDoacao;
import pt.saobernardo.controller.GestorRegisto;
import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.Registo;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

public class FrameDoacoes extends JFrame {

	private JPanel contentPane;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable tableDoacoes;

	/**
	 * Create the frame.
	 */
	public FrameDoacoes() {
		setTitle("Doa\u00E7\u00F5es S\u00E3oBernardo - Perdidos e achados ");
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						FrameLogin.class
								.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Cria os cabeçalhos da tabela
		dtm.addColumn("Cor");
		dtm.addColumn("Estado");
		dtm.addColumn("Sala");
		dtm.addColumn("Data");
		dtm.addColumn("Descrição");
		dtm.addColumn("Código");

		// Associa o TableModel à tabela
		tableDoacoes = new JTable(dtm);
		tableDoacoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 70, 340, 150);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableDoacoes);
		tableDoacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDoacoes.setPreferredScrollableViewportSize(new Dimension(500, 50));
		tableDoacoes.setFillsViewportHeight(true);

		// Ocultar a coluna da descrição na tabela
		tableDoacoes.getColumnModel().getColumn(4).setMinWidth(0);
		tableDoacoes.getColumnModel().getColumn(4).setMaxWidth(0);

		// Ocultar a coluna do codigo na tabela
		tableDoacoes.getColumnModel().getColumn(5).setMinWidth(0);
		tableDoacoes.getColumnModel().getColumn(5).setMaxWidth(0);

		// Criar as linhas da tabela iterando sobre o Array Registo
		// Só estarão na tabela as datas cujo objeto já foi registado à pelo
		// menos 30 dias
		for (Registo reg : SaoBernardo.registos) {
			try {
				if (GestorDoacao.verificaData(reg.getData())
						&& (reg.getEstado().equals("Bom") || reg.getEstado()
								.equals("Razoável"))) {

					dtm.addRow(new Object[] { reg.getCor(), reg.getEstado(),
							reg.getS().getSala(), reg.getData(),reg.getDescricao(),reg.getCodigo() });

				}

			} catch (ParseException e) {
				e.printStackTrace();
			}
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
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnCancelar.setBounds(446, 309, 90, 23);
		contentPane.add(btnCancelar);

		JButton btnDoar = new JButton("Doar");
		btnDoar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tableDoacoes.getSelectedRow();
				String cod = tableDoacoes.getValueAt(row, 5).toString();
				int codigo = Integer.parseInt(cod);
				GestorDoacao.doarObjeto(codigo);
				JOptionPane.showMessageDialog(null, "Objeto Doado!");
			}
		});
		btnDoar.setBounds(331, 309, 89, 23);
		contentPane.add(btnDoar);

		JLabel lblDoados = new JLabel("serem doados!");
		lblDoados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoados.setForeground(Color.WHITE);
		lblDoados.setBounds(47, 216, 91, 14);
		contentPane.add(lblDoados);

		JLabel lblObjetosASerem = new JLabel("Objetos para");
		lblObjetosASerem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObjetosASerem.setForeground(Color.WHITE);
		lblObjetosASerem.setBounds(47, 201, 90, 15);
		contentPane.add(lblObjetosASerem);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				FrameListagemObjetos.class
						.getResource("/pt/saobernardo/resource/Logo sem fundo Listagens.png")));
		label.setBounds(20, 24, 128, 128);
		contentPane.add(label);

		JLabel label_Fundo = new JLabel("");
		label_Fundo.setIcon(new ImageIcon(FrameListagemObjetos.class
				.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		label_Fundo.setBounds(-8, -25, 600, 400);
		contentPane.add(label_Fundo);

	}

}
