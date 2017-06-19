package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AfterGamePanel extends JPanel{
	
	private JFrame _father;
	private Game _game;
	private boolean won;
	
	public AfterGamePanel(JFrame father , Game game){
		_father = father;
		_game = game;
		won = _game._lives>0;
		JButton submitScore = new JButton();
		submitScore.setName("submitButton");
		submitScore.setText("Submit Score");
		submitScore.setVisible(won);
		_father.removeAll();
		_father.add(this);
				
	}	
	
	public class ButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton eventButton = ((JButton)e.getSource());
			if(eventButton.getName().equals("submitButton")){
				
			}	
			if(eventButton.getName().equals("returnButton")){
				MainMenu menu = new MainMenu();
				((GameWindow)_father)._menu = menu;
				_father.removeAll();
				_father.getContentPane().add(menu);
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
