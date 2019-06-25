package tictactoe;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener {
	JButton play,sound,instruction,exit,resume,score,restart;
	@SuppressWarnings("static-access")
	Menu()
	{
		System.out.println("menu class loading...");
		setLayout(null);
		restart = new JButton("Restart");
		resume = new JButton("Resume");
		play = new JButton("Play");
		instruction = new JButton("Instruction");
		exit = new JButton("Exit");
		score = new JButton("score");
		restart.setBounds(200,150,100,40);
		resume.setBounds(200,100,100,40);
		play.setBounds(200,150,100,40);
		instruction.setBounds(200,200,100,40);
		score.setBounds(200,250,100,40);
		exit.setBounds(200,300,100,40);
		exit.addActionListener(this);
		add(resume);
		add(restart);
		restart.setVisible(false);
		resume.setVisible(false);
		add(play);
		add(instruction);
		add(score);
		add(exit);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()  == exit) {
			System.out.println("Exiting");
			System.exit(0);
		}
	}

}
