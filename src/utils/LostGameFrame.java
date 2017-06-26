package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.image.Image;

public class LostGameFrame extends JFrame{
	
	private Game game;
	private JPanel mainPanel;
	
	public LostGameFrame(Game game){
		this.game = game;
		this.mainPanel = new JPanel(new GridLayout());
		this.setPreferredSize(new Dimension(500, 500));
		this.setResizable(false);
		mainPanel.setVisible(true);
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.black);
		GridBagConstraints g = new GridBagConstraints();
		JLabel message = new JLabel("You Lost");		
		message.setFont(new Font("arial", Font.BOLD, 60));
		message.setForeground(Color.white);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		g.gridx=1;
		g.gridy=0;
		this.add(mainPanel);
		mainPanel.add(message);
		pack();
	}	
	
	public class ButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton eventButton = ((JButton)e.getSource());
			if(eventButton.getName().equals("submitButton")){
				
			}	
			if(eventButton.getName().equals("returnButton")){
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
