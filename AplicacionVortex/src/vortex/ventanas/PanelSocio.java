package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.Constantes;

import javax.swing.border.LineBorder;

public class PanelSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelSocio frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelSocio frame8 = new PanelSocio();
					frame8.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelSocio() {
		setTitle("Vortex Socio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Cerrar Sesion");
		button.setForeground(Color.RED);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(269, 11, 113, 23);
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

		JLabel label = new JLabel("Bienvenido:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(10, 43, 111, 29);
		contentPane.add(label);

		JButton btnModNick = new JButton("Modificar Nick");
		btnModNick.setForeground(Color.BLACK);
		btnModNick.setFont(new Font("Dialog", Font.BOLD, 11));
		btnModNick.setBounds(30, 117, 146, 23);
		contentPane.add(btnModNick);

		btnModNick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelSocio_Nick frame9 = new PanelSocio_Nick();
				frame9.setVisible(true);
				dispose();
			}

		});

		JButton btnInternet = new JButton("Acceder a Internet");
		btnInternet.setForeground(Color.BLACK);
		btnInternet.setFont(new Font("Dialog", Font.BOLD, 11));
		btnInternet.setBounds(30, 170, 146, 23);
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

		JButton btnSteam = new JButton("Acceder a Steam");
		btnSteam.setForeground(Color.BLACK);
		btnSteam.setFont(new Font("Dialog", Font.BOLD, 11));
		btnSteam.setBounds(31, 223, 145, 23);
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
		btnOrigin.setBounds(217, 223, 146, 23);
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

		JButton btnCorreo = new JButton("Acceder a correo");
		btnCorreo.setForeground(Color.BLACK);
		btnCorreo.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCorreo.setBounds(217, 170, 146, 23);
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

		JLabel label_2 = new JLabel("Vortex\u2122");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(315, 339, 67, 23);
		contentPane.add(label_2);

		JLabel label_1 = new JLabel(Constantes.user);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(120, 43, 111, 29);
		contentPane.add(label_1);
		
		JLabel Timer = new JLabel("");
		Timer.setFont(new Font("Dialog", Font.BOLD, 11));
		Timer.setForeground(Color.WHITE);
		Timer.setOpaque(true);
		Timer.setBorder(new LineBorder(new Color(0, 0, 0)));
		Timer.setBackground(Color.BLACK);
		Timer.setBounds(0, 339, 105, 34);
		contentPane.add(Timer);
		
		JButton btnModPass = new JButton("Modificar Password");
		btnModPass.setForeground(Color.BLACK);
		btnModPass.setFont(new Font("Dialog", Font.BOLD, 11));
		btnModPass.setBounds(216, 117, 146, 23);
		contentPane.add(btnModPass);
		
		btnModPass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelSocio_Pass frame10 = new PanelSocio_Pass();
				frame10.setVisible(true);
				dispose();
			}

		});
	}
}
