package pt.saobernardo.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import pt.saobernardo.controller.GestorRegisto;
import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.ObjetoPerdido;
import pt.saobernardo.model.Registo;
import pt.saobernardo.model.Sala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.SystemColor;

public class FrameImportacao extends JFrame {

	private JPanel contentPane;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable tableImportação;

	/**
	 * Create the frame.
	 */
	public FrameImportacao() {
		setTitle("Importa\u00E7\u00E3o S\u00E3oBernardo - Perdidos e achados ");
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
		

		JButton btnCancelar = new JButton("");
		btnCancelar.setBounds(444, 288, 90, 23);
		btnCancelar
				.setRolloverIcon(new ImageIcon(
						FrameImportacao.class
								.getResource("/pt/saobernardo/resource/Cancelar_20_pixeis.png")));
		btnCancelar
				.setIcon(new ImageIcon(
						FrameImportacao.class
								.getResource("/pt/saobernardo/resource/Cancelar_clareado_20_pixeis.png")));
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
		
		// Cria os cabeçalhos da tabela
		dtm.addColumn("Objeto");
		dtm.addColumn("Cor");
		dtm.addColumn("Estado");
		dtm.addColumn("Sala");
		dtm.addColumn("Data");
		dtm.addColumn("Descrição");
		
		// Associa o TableModel à tabela
		tableImportação = new JTable(dtm);
		tableImportação.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 87, 362, 185);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableImportação);
		tableImportação.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableImportação.setPreferredScrollableViewportSize(new Dimension(500,
				50));
		tableImportação.setFillsViewportHeight(true);
		contentPane.add(btnCancelar);

		JButton btnGuardar = new JButton("");
		btnGuardar.setBounds(344, 288, 90, 23);
		btnGuardar
				.setRolloverIcon(new ImageIcon(
						FrameImportacao.class
								.getResource("/pt/saobernardo/resource/Guardar_20_pixeis.png")));
		btnGuardar
				.setIcon(new ImageIcon(
						FrameImportacao.class
								.getResource("/pt/saobernardo/resource/Guardar_clareado_20_pixeis.png")));
		btnGuardar.setFocusable(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(SystemColor.menu);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SaoBernardo.saveRegisto();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,
						"Ficheiro importado com sucesso!", "Importação",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
				JLabel lblNewLabel = new JLabel(
						"",
						new ImageIcon(
								FrameImportacao.class
										.getResource("/pt/saobernardo/resource/Logo s fundo.png")),
						JLabel.CENTER);
				lblNewLabel.setBounds(10, 42, 152, 152);
				lblNewLabel.setVerticalTextPosition(JLabel.BOTTOM);
				lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
				contentPane.add(lblNewLabel);
		
			
			JLabel lblParaOSaobernardo = new JLabel("para o SaoBernardo!");
			lblParaOSaobernardo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblParaOSaobernardo.setForeground(Color.WHITE);
			lblParaOSaobernardo.setBounds(20, 230, 137, 14);
			contentPane.add(lblParaOSaobernardo);
		
		JLabel lblImportarDados = new JLabel("Importar registos");
		lblImportarDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImportarDados.setForeground(Color.WHITE);
		lblImportarDados.setBounds(20, 217, 119, 14);
		contentPane.add(lblImportarDados);
		contentPane.add(btnGuardar);

		JButton btnImportarFicheiro = new JButton("");
		btnImportarFicheiro.setBounds(244, 42, 216, 23);
		btnImportarFicheiro
				.setRolloverIcon(new ImageIcon(
						FrameImportacao.class
								.getResource("/pt/saobernardo/resource/ImportarFicheiro_50_pixeis.png")));
		btnImportarFicheiro
				.setIcon(new ImageIcon(
						FrameImportacao.class
								.getResource("/pt/saobernardo/resource/ImportarFicheiro_clareado_50_pixeis.png")));
		btnImportarFicheiro.setFocusable(false);
		btnImportarFicheiro.setContentAreaFilled(false);
		btnImportarFicheiro.setBorder(null);
		btnImportarFicheiro.setBackground(SystemColor.menu);
		btnImportarFicheiro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// ESCOLHER O FICHEIRO
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(rootPane);// rootPane pode ser
														// null(centra em
														// relação ao ecra)
				File file = fileChooser.getSelectedFile();
				FileInputStream stream;// Procura e encontra o arquivo e lê o
										// arquivo em bytes
				try {

					stream = new FileInputStream(file);

					Reader streamReader = new InputStreamReader(stream);// traduz
																		// os
																		// bytes
																		// para
																		// caracteres
					BufferedReader reader = new BufferedReader(streamReader);// concatena
																				// os
																				// diversos
																				// caracteres
																				// da
																				// classe
																				// anterior
																				// para
																				// formar
																				// uma
																				// String

					// LÊ CONTEUDO DAS LINHAS
					String line;

					ArrayList<String[]> rows = new ArrayList<>();

					while ((line = reader.readLine()) != null) {
						String[] row = line.split(";");
						rows.add(row);
					}

					// ADICIONA O REGISTO À LISTA DE REGISTOS
					// Salas

					Sala s = null;
					ObjetoPerdido op = null;
					for (String[] fields : rows) {

						for (Sala sala : SaoBernardo.salas) {
							if (sala.getSala().equals(fields[4])) {
								s = sala;
							}
						}
						for (ObjetoPerdido objetoPerdido : SaoBernardo.objetos) {
							if (objetoPerdido.getCodigoTipo() == Integer
									.parseInt(fields[5])) {
								op = objetoPerdido;
							}

						}
						Registo r = new Registo(GestorRegisto
								.getUltimoCodigoRegisto(), fields[2],
								fields[3], s, fields[0], fields[1], fields[6],
								fields[7], fields[8], op);
						SaoBernardo.registos.add(r);
						
						dtm.addRow(new Object[] {op, fields[6], fields[7],s,fields[0],fields[8]});


						/*lblNome.setText(fields[2]);
						lblEmail.setText(fields[3]);
						lblSala.setText(s.getSala());
						lblData.setText(fields[0]);
						lblHora.setText(fields[1]);
						lblCor.setText(fields[6]);
						lblEstado.setText(fields[7]);
						lblDesc.setText(fields[8]);
						lblObj.setText(op.getObjetoTipo());*/

						
						
						
						
					}

					reader.close();
					streamReader.close();
					stream.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnImportarFicheiro);

		JLabel labelFundo = new JLabel("");
		labelFundo.setBounds(-11, -12, 563, 370);
		labelFundo.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundo.setIcon(new ImageIcon(FrameLogin.class
				.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		contentPane.add(labelFundo);

	}
}
