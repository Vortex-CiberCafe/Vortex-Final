package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import vortex.Constantes;
import vortex.bbdd.BD_Vortex;

public class PanelSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelSocio frame10;
	private JPanel contentPane;
	private static Timer Tempo = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelSocio frame10 = new PanelSocio();
					frame10.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelSocio() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");
		int salidaTimer = 0;
		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int inicioalto = alto / 4;
		int inicioancho = ancho / 3;
		ancho = ancho / 4;
		alto = alto / 2;
		setTitle(" Vortex Socio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 475, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* Icono Ventana */
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\coffeeV.png"));

		JButton button = new JButton("Cerrar Sesion");
		button.setForeground(Color.RED);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(344, 11, 113, 23);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bd.guardarConexion(Constantes.user, Constantes.minutos);
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}

		});

		JLabel label = new JLabel("Bienvenido:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(40, 70, 111, 29);
		contentPane.add(label);

		JLabel label_1 = new JLabel(Constantes.user);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(150, 70, 111, 29);
		contentPane.add(label_1);

		JButton btnModNick = new JButton("Modificar Nick");
		btnModNick.setForeground(Color.BLACK);
		btnModNick.setFont(new Font("Dialog", Font.BOLD, 11));
		btnModNick.setBounds(60, 144, 146, 23);
		contentPane.add(btnModNick);

		btnModNick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelSocio_Nick frame11 = new PanelSocio_Nick();
				frame11.setVisible(true);
				dispose();
			}

		});

		JButton btnModPass = new JButton("Modificar Password");
		btnModPass.setForeground(Color.BLACK);
		btnModPass.setFont(new Font("Dialog", Font.BOLD, 11));
		btnModPass.setBounds(246, 144, 146, 23);
		contentPane.add(btnModPass);

		btnModPass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelSocio_Pass frame12 = new PanelSocio_Pass();
				frame12.setVisible(true);
				dispose();
			}

		});

		JButton btnInternet = new JButton("Acceder a Internet");
		btnInternet.setForeground(Color.BLACK);
		btnInternet.setFont(new Font("Dialog", Font.BOLD, 11));
		btnInternet.setBounds(60, 197, 146, 23);
		contentPane.add(btnInternet);

		btnInternet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] cmd = { "C:\\Program Files\\Mozilla Firefox\\firefox.exe" };
				Process p = null;
				try {
					p = Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					p.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		JButton btnCorreo = new JButton("Acceder a correo");
		btnCorreo.setForeground(Color.BLACK);
		btnCorreo.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCorreo.setBounds(247, 197, 146, 23);
		contentPane.add(btnCorreo);

		btnCorreo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String url = "https://accounts.google.com";
				Process p3 = null;
				try {
					p3 = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					p3.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		JButton btnSteam = new JButton("Acceder a Steam");
		btnSteam.setForeground(Color.BLACK);
		btnSteam.setFont(new Font("Dialog", Font.BOLD, 11));
		btnSteam.setBounds(61, 250, 145, 23);
		contentPane.add(btnSteam);

		btnSteam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String url = "http://store.steampowered.com";
				Process p1 = null;
				try {
					p1 = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					p1.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		JButton btnOrigin = new JButton("Acceder a Origin");
		btnOrigin.setForeground(Color.BLACK);
		btnOrigin.setFont(new Font("Dialog", Font.BOLD, 11));
		btnOrigin.setBounds(247, 250, 146, 23);
		contentPane.add(btnOrigin);

		btnOrigin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String url = "https://www.origin.com/esp/es-es/store";
				Process p2 = null;
				try {
					p2 = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					p2.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		JLabel segundosR = new JLabel("");
		segundosR.setHorizontalAlignment(SwingConstants.CENTER);
		segundosR.setFont(new Font("Dialog", Font.BOLD, 11));
		segundosR.setForeground(Color.WHITE);
		segundosR.setOpaque(true);
		segundosR.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		segundosR.setBackground(Color.BLACK);
		segundosR.setBounds(120, 379, 31, 34);
		contentPane.add(segundosR);

		JLabel minutosR = new JLabel("");
		minutosR.setHorizontalAlignment(SwingConstants.CENTER);
		minutosR.setOpaque(true);
		minutosR.setForeground(Color.WHITE);
		minutosR.setFont(new Font("Dialog", Font.BOLD, 11));
		minutosR.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		minutosR.setBackground(Color.BLACK);
		minutosR.setBounds(70, 379, 31, 34);
		contentPane.add(minutosR);

		JLabel horasR = new JLabel("");
		horasR.setHorizontalAlignment(SwingConstants.CENTER);
		horasR.setOpaque(true);
		horasR.setForeground(Color.WHITE);
		horasR.setFont(new Font("Dialog", Font.BOLD, 11));
		horasR.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		horasR.setBackground(Color.BLACK);
		horasR.setBounds(20, 379, 31, 34);
		contentPane.add(horasR);

		JLabel label_3 = new JLabel(":");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 15));
		label_3.setBounds(51, 379, 19, 32);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel(":");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 15));
		label_4.setBounds(101, 379, 19, 32);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel((String) null);
		label_5.setBackground(new Color(0, 102, 153));
		label_5.setOpaque(true);
		label_5.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Dialog", Font.BOLD, 14));
		label_5.setBounds(10, 370, 151, 54);
		contentPane.add(label_5);

		Constantes.minutos = bd.getMinutoSocio(Constantes.user);
		
		Timer Tempo = new Timer(1000, new ActionListener() {
			int horas = Constantes.minutos / 60;
			int minutos = Constantes.minutos % 60;
			int segundos = 0;

			public void actionPerformed(ActionEvent e) {

				if (horas == 0 && minutos == 0 && segundos == 1) {
					horasR.setText(String.valueOf(horas));
					minutosR.setText(String.valueOf(0));
					segundosR.setText(String.valueOf(0));
					
					((Timer)e.getSource()).stop();
					
					bd.guardarConexion(Constantes.user, 0);
					
					PanelSocio_NoTime frame19 = new PanelSocio_NoTime();
					frame19.setVisible(true);
					dispose();
					
					return;
					
				} else {
					if (minutos == 0 && horas > 0) {
						horas--;
						minutos = 59;
					}

					if (segundos == 0 && minutos > 0) {
						minutos--;
						segundos = 59;
					} else {
						horasR.setText(String.valueOf(horas));
						minutosR.setText(String.valueOf(minutos));
						segundosR.setText(String.valueOf(segundos));
						segundos--;
					}
					Constantes.minutos = horas * 60 + minutos;
				}
			}
			
		});
		Tempo.start();

		JLabel label_2 = new JLabel("Vortex\u2122");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(390, 401, 67, 23);
		contentPane.add(label_2);

	}
}
