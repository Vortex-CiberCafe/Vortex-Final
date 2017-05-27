package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.Constantes;
import vortex.bbdd.BD_Vortex;
import vortex.modelos.Socio;

public class PanelAdmin_CajaTotal extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin_CajaTotal frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin_CajaTotal frame9 = new PanelAdmin_CajaTotal();
					frame9.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin_CajaTotal() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int inicioalto=alto/4;
		int inicioancho=ancho/3;
		ancho = ancho / 4;
		alto = alto / 2;

		setTitle(" Vortex Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, ancho, alto);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuarios = new JLabel("Caja Admin:");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuarios.setBounds(40, 70, 142, 29);
		contentPane.add(lblUsuarios);
		
		JLabel label_1 = new JLabel(" " + Constantes.cajaAdmin + "€");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(192, 70, 131, 29);
		contentPane.add(label_1);
		
		JLabel lblCajaDependiente = new JLabel("Caja Dependiente:");
		lblCajaDependiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCajaDependiente.setForeground(Color.WHITE);
		lblCajaDependiente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCajaDependiente.setBounds(40, 118, 142, 29);
		contentPane.add(lblCajaDependiente);
		
		JLabel label_3 = new JLabel(" " + Constantes.cajaDependiente + "€");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setBounds(192, 118, 131, 29);
		contentPane.add(label_3);
		
		JLabel lblCajaTotal = new JLabel("Caja Total:");
		lblCajaTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCajaTotal.setForeground(Color.WHITE);
		lblCajaTotal.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCajaTotal.setBounds(40, 166, 142, 29);
		contentPane.add(lblCajaTotal);
		
		JLabel label_4 = new JLabel(" " + Constantes.cajaTotal + "€");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 14));
		label_4.setBounds(192, 166, 131, 29);
		contentPane.add(label_4);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(300, 240, 113, 23);
		contentPane.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin frame2 = new PanelAdmin();
				frame2.setVisible(true);
				dispose();

			}

		});
		
		JLabel label = new JLabel("Vortex\u2122");
		label.setForeground(Color.RED);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(390, 401, 67, 23);
		contentPane.add(label);
		
	}
}
