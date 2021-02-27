package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.CampoMinadoVVAL.jogo.CampoMinado;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDeJogo extends JFrame {
	private JPanel contentPane;
	private JButton botoes[][];

	/**
	 * Create the frame.
	 */
	public MenuDeJogo(CampoMinado teste) {
		
		setBounds(1, 1, 900, 900);
		this.botoes = new JButton[teste.getDificuldade().getNumero()][teste.getDificuldade().getNumero()];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 101, 750, 750);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(teste.getDificuldade().getNumero(),teste.getDificuldade().getNumero()));
		for (int i = 1; i <=teste.getDificuldade().getNumero(); i++) {
			for (int j = 1; j <= teste.getDificuldade().getNumero(); j++) {
				this.botoes[i - 1][j - 1] = new JButton(i + "|" + j);
				this.botoes[i - 1][j - 1].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				panel.add(this.botoes[i - 1][j - 1]);
			}
		}
		
		
		
	

			

			
	}
}
