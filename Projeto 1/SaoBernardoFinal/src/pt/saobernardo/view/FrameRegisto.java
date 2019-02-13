package pt.saobernardo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pt.saobernardo.controller.GestorRegisto;
import pt.saobernardo.controller.GestorSala;
import pt.saobernardo.controller.SaoBernardo;
import pt.saobernardo.model.InstituicaoSolidariedade;
import pt.saobernardo.model.ObjetoPerdido;
import pt.saobernardo.model.Sala;

import java.awt.Toolkit;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Point;
import java.awt.ComponentOrientation;

public class FrameRegisto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtDescricao;

	/**
	 * Create the frame.
	 */
	public FrameRegisto() {
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						FrameRegisto.class
								.getResource("/pt/saobernardo/resource/Log\u00F3tipo S\u00E3oBernardo_icon 3.png")));
		setTitle("Registo - S\u00E3o Bernardo Perdidos e Achados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(170, 50, 76, 30);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(170, 87, 76, 30);

		JLabel lblTipoDeObjeto = new JLabel("Tipo de objeto");
		lblTipoDeObjeto.setBounds(170, 122, 76, 30);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(373, 165, 28, 20);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(373, 121, 42, 30);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(170, 195, 70, 30);

		txtDescricao = new JTextField();
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setToolTipText("");
		txtDescricao.setBounds(252, 201, 270, 98);
		txtDescricao.setColumns(10);

		JButton btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(FrameRegisto.class.getResource("/pt/saobernardo/resource/Cancelar_20_pixeis.png")));
		btnCancelar.setIcon(new ImageIcon(FrameRegisto.class.getResource("/pt/saobernardo/resource/Cancelar_clareado_20_pixeis.png")));
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
		btnCancelar.setBounds(24, 274, 130, 25);

		
		
		contentPane.setLayout(null);
		contentPane.add(lblNome);
		contentPane.add(lblEmail);
		contentPane.add(lblTipoDeObjeto);
		contentPane.add(lblCor);
		contentPane.add(lblEstado);
		contentPane.add(lblDescrio);
		contentPane.add(btnCancelar);
		
				txtNome = new JTextField();
				txtNome.setBorder(null);
				txtNome.setBounds(263, 54, 250, 20);
				txtNome.setHorizontalAlignment(SwingConstants.LEFT);
				txtNome.setColumns(10);
				contentPane.add(txtNome);
		
				txtEmail = new JTextField();
				txtEmail.setBorder(null);
				txtEmail.setBounds(263, 90, 250, 20);
				txtEmail.setColumns(10);
				contentPane.add(txtEmail);
		
		JLabel labelFundoNome = new JLabel("");
		labelFundoNome.setBackground(SystemColor.menu);
		labelFundoNome.setIcon(new ImageIcon(FrameRegisto.class.getResource("/pt/saobernardo/resource/FundoComboBox_65_pixeis.png")));
		labelFundoNome.setBounds(252, 48, 275, 31);
		contentPane.add(labelFundoNome);
		
		JLabel labelFundoEmail = new JLabel("");
		labelFundoEmail.setIcon(new ImageIcon(FrameRegisto.class.getResource("/pt/saobernardo/resource/FundoComboBox_65_pixeis.png")));
		labelFundoEmail.setBackground(SystemColor.menu);
		labelFundoEmail.setBounds(252, 85, 275, 30);
		contentPane.add(labelFundoEmail);
		contentPane.add(txtDescricao);
		
		JComboBox comboBoxSala = new JComboBox();
		for (Sala s : SaoBernardo.salas) {
			comboBoxSala.addItem(s);
		}
		comboBoxSala.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		comboBoxSala.setBounds(252, 165, 100, 20);
		contentPane.add(comboBoxSala);

		JComboBox comboBoxCor = new JComboBox();
		comboBoxCor.setModel(new DefaultComboBoxModel(new String[] { "Azul",
				"Amarelo", "Branco", "Castanho", "Cinzento", "Cor-de-Laranja",
				"Cor-de-Rosa", "Preto", "Roxo", "Verde", "Vermelho" }));
		comboBoxCor.setBounds(422, 165, 100, 20);
		contentPane.add(comboBoxCor);

		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] { "Bom",
				"Mau", "Razo\u00E1vel" }));
		comboBoxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		comboBoxEstado.setBounds(422, 127, 100, 20);
		contentPane.add(comboBoxEstado);

		JComboBox comboBoxObjeto = new JComboBox();
		comboBoxObjeto.setBorder(null);
		comboBoxObjeto.setForeground(Color.BLACK);
		comboBoxObjeto.setBackground(Color.WHITE);
		for (ObjetoPerdido op : SaoBernardo.objetos) {
			comboBoxObjeto.addItem(op);
		}
		comboBoxObjeto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		comboBoxObjeto.setBounds(252, 127, 100, 20);
		contentPane.add(comboBoxObjeto);
		
		//Label que mostra a data
		JLabel lblDataHora = new JLabel("");
		lblDataHora.setText(SaoBernardo.dataFormato);
		lblDataHora.setBounds(254, 29, 70, 14);
		contentPane.add(lblDataHora);
		
		//Label que mostra a hora
		JLabel lblHora = new JLabel("");
		lblHora.setText(SaoBernardo.horaFormato);
		lblHora.setBounds(341, 29, 46, 14);
		contentPane.add(lblHora);
		
		JButton btnConf = new JButton("");
		btnConf.setRolloverIcon(new ImageIcon(FrameRegisto.class.getResource("/pt/saobernardo/resource/Confirmar_20_pixeis.png")));
		btnConf.setIcon(new ImageIcon(FrameRegisto.class.getResource("/pt/saobernardo/resource/Confirmar_clareado_20_pixeis.png")));
		btnConf.setFocusable(false);
		btnConf.setContentAreaFilled(false);
		btnConf.setBorder(null);
		btnConf.setBackground(SystemColor.menu);
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if (GestorRegisto.inserirRegisto(txtNome.getText(),
						txtEmail.getText(),comboBoxSala.getSelectedItem(),
						lblDataHora.getText(),lblHora.getText(), comboBoxCor.getSelectedItem().toString(), comboBoxEstado.getSelectedItem().toString(), txtDescricao.getText(), comboBoxObjeto.getSelectedItem()) == true) {
					JOptionPane.showMessageDialog(null,
							"Registo inserido com sucesso!");
				}
				 else {
				  
				  JOptionPane.showMessageDialog(null, "Erro");  }
				 
			}
			
		});
		btnConf.setBounds(24, 245, 130, 25);
		contentPane.add(btnConf);

		JLabel lblRegistoDo = new JLabel("Registo do");
		lblRegistoDo.setForeground(Color.WHITE);
		lblRegistoDo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistoDo.setBounds(29, 175, 100, 20);
		contentPane.add(lblRegistoDo);

		JLabel lblObjetoPerdido = new JLabel("objeto perdido!");
		lblObjetoPerdido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObjetoPerdido.setForeground(Color.WHITE);
		lblObjetoPerdido.setBounds(29, 195, 115, 25);
		contentPane.add(lblObjetoPerdido);

		JLabel lblSala_1 = new JLabel("Sala");
		lblSala_1.setBounds(170, 170, 28, 14);
		contentPane.add(lblSala_1);
		

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon(
						FrameRegisto.class
								.getResource("/pt/saobernardo/resource/Logo sem fundo Listagens.png")));
		lblNewLabel_1.setBounds(10, 29, 130, 128);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameRegisto.class
				.getResource("/pt/saobernardo/resource/Fundo Menus.png")));
		lblNewLabel.setBounds(-10, -13, 621, 371);
		contentPane.add(lblNewLabel);
	}
}
