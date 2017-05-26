package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import vortex.Constantes;
import vortex.bbdd.BD_Vortex;

public class PanelSocio_Nick extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelSocio_Nick frame2;
	private JPanel contentPane;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelSocio_Nick frame10 = new PanelSocio_Nick();
					frame10.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelSocio_Nick() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");
		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int inicioalto=alto/4;
		int inicioancho=ancho/4;
		ancho = ancho / 4;
		alto = alto / 2;
		setTitle("Vortex Socio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, ancho, alto);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Cerrar Sesion");
		button.setForeground(Color.RED);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(344, 11, 113, 23);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}

		});

		JLabel lblAntiguoNick = new JLabel("Nick:");
		lblAntiguoNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblAntiguoNick.setForeground(Color.WHITE);
		lblAntiguoNick.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAntiguoNick.setBounds(40, 70, 111, 29);
		contentPane.add(lblAntiguoNick);
		
		JLabel label_1 = new JLabel(Constantes.user);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(161, 70, 111, 29);
		contentPane.add(label_1);

		JLabel lblNuevoNick = new JLabel("Nuevo Nick:");
		lblNuevoNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoNick.setForeground(Color.WHITE);
		lblNuevoNick.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNuevoNick.setBounds(40, 124, 111, 29);
		contentPane.add(lblNuevoNick);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 130, 113, 20);
		contentPane.add(textField_1);

		JLabel lblEstaSeguroDe = new JLabel("Esta seguro de que desea cambiar su nick?");
		lblEstaSeguroDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstaSeguroDe.setForeground(Color.WHITE);
		lblEstaSeguroDe.setFont(new Font("Dialog", Font.BOLD, 11));
		lblEstaSeguroDe.setBounds(63, 182, 316, 29);
		contentPane.add(lblEstaSeguroDe);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(Color.BLACK);
		btnContinuar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnContinuar.setBounds(245, 227, 113, 23);
		contentPane.add(btnContinuar);

		btnContinuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int filas = bd.updateNick(textField_1.getText());
				switch (filas) {
				case 1:
					Constantes.user = textField_1.getText();
					PanelSocio frame9 = new PanelSocio();
					frame9.setVisible(true);
					dispose();
					System.out.println("OK");
					break;
				case 0:
					System.out.println("El usuario no existe");
					break;
				case -1:
					System.out.println("Problemas tecnicos");
					break;
				}

			}

		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(245, 272, 113, 23);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelSocio frame9 = new PanelSocio();
				frame9.setVisible(true);
				dispose();

			}

		});

		JLabel Timer = new JLabel("");
		Timer.setFont(new Font("Dialog", Font.BOLD, 11));
		Timer.setForeground(Color.WHITE);
		Timer.setOpaque(true);
		Timer.setBorder(new LineBorder(new Color(0, 0, 0)));
		Timer.setBackground(Color.BLACK);
		Timer.setBounds(10, 390, 105, 34);
		contentPane.add(Timer);

		JLabel label_2 = new JLabel("Vortex\u2122");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(390, 401, 67, 23);
		contentPane.add(label_2);
		
	}
}
