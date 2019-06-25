package tictactoe;

import javax.swing.*;

import tictactoe.Time;
import tictactoe.TimePanel.ThreadDemo;
import tictactoe.Menu;
import tictactoe.Players;
import tictactoe.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame implements ActionListener {
	Menu m;
	Players p;
	PlayZone pz;
	Time t;
	ThreadDemo td;

	TicTacToe() {
		System.out.println("TicTacToe class called");
		setLayout(null);
		m = new Menu();
		p = new Players();
		pz = new PlayZone();
		m.setBounds(0, 0, 500, 500);

		add(m);
		m.play.addActionListener(this);
		m.resume.addActionListener(this);
		m.restart.addActionListener(this);

		p.setBounds(0, 0, 500, 500);
		add(p);
		p.setVisible(false);
		p.start.addActionListener(this);

		pz.setBounds(0, 0, 500, 500);
		add(pz);
		pz.menu.addActionListener(this);
		pz.setVisible(false);
		setBounds(30, 30, 500, 500);
		setTitle("Tic Tac Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == m.play) {
			p.setVisible(true);
			m.setVisible(false);
		}
		if (ae.getSource() == p.start) {
			pz.player1 = p.plr1.getText();
			pz.player2 = p.plr2.getText();
			pz.plr1.setText(pz.player1 + " win = " + pz.win1);
			pz.plr2.setText(pz.player2 + " win = " + pz.win2);
			pz.turn.setText(pz.player1 + " turn");
			if (pz.player1.length() > 0 && pz.player2.length() > 0) {
				p.setVisible(false);

				pz.setVisible(true);
				

			} else
				p.error.setText("please Enter players name");
		}
		if (ae.getSource() == pz.menu) {
			pz.setVisible(false);
			m.resume.setVisible(true);
			m.play.setVisible(false);
			m.restart.setVisible(true);
			m.setVisible(true);
		}
		if (ae.getSource() == m.resume) {
			m.setVisible(false);
			pz.setVisible(true);
		}
		if (ae.getSource() == m.restart) {
			m.setVisible(false);
			reset();
			p.setVisible(true);
		}
	}

	void reset() {
		System.out.println("reset function called from tictactoe class");
		p.plr1.setText("");
		p.plr2.setText("");
		pz.turn.setText(pz.player1 + " turn");

		pz.win1 = 0;
		pz.win2 = 0;
		pz.playerturn = pz.player1;
		pz.player = 1;
		for (int i = 0; i < 9; i++) {
			pz.b[i].setText("");
			pz.a[i] = 3 + i;
			pz.b[i].removeActionListener(this);
			pz.b[i].addActionListener(this);
		}
		pz.bool = true;
	}

	public static void main(String args[]) {
		System.out.println("Loading gui.....");
		new TicTacToe();
		System.out.println("all classes and function loaded " + new java.util.Date());
	}

}
