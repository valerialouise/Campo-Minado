package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.CampoMinadoVVAL.jogo.CampoMinado;
import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtDigiteOSeu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("CAMPO MINADO\r\n");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel.setBounds(275, 40, 350, 100);
		contentPane.add(lblNewLabel);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(785, 827, 89, 23);
		contentPane.add(btnSair);
		
		txtDigiteOSeu = new JTextField();
		txtDigiteOSeu.setText("Digite o seu nome");
		txtDigiteOSeu.setBounds(393, 151, 96, 20);
		contentPane.add(txtDigiteOSeu);
		txtDigiteOSeu.setColumns(10);
		
		JButton btnFacil = new JButton("FACIL");
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDeJogo facil = new MenuDeJogo(new CampoMinado(txtDigiteOSeu.getText(),Dificuldade.FACIL));
				facil.setVisible(true);
				dispose();
			}
		});
		btnFacil.setBounds(62, 277, 203, 218);
		contentPane.add(btnFacil);
		
		JButton btnMedio = new JButton("MEDIO");
		btnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDeJogo medio = new MenuDeJogo(new CampoMinado(txtDigiteOSeu.getText(),Dificuldade.MEDIO));
				medio.setVisible(true);
				dispose();
			}
		});
		btnMedio.setBounds(316, 277, 237, 218);
		contentPane.add(btnMedio);
		
		JButton btnDificil = new JButton("DIFICIL");
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDeJogo dificil = new MenuDeJogo(new CampoMinado(txtDigiteOSeu.getText(),Dificuldade.DIFICIL));
				dificil.setVisible(true);
				dispose();

			}
		});
		btnDificil.setBounds(634, 277, 187, 218);
		contentPane.add(btnDificil);
	}
}
