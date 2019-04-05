import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Selector extends JPanel  implements ActionListener{

	boolean[][] handSelection; 
	ArrayList<String> pressed;
	
	public enum Rank{  
		ACE,TWO,THREE,FOUR, FIVE, SIX, SEVEN,EIGHT, NINE,TEN,JACK,KING,QUEEN
	}
	
	public Selector(int height, int width, int hStart, int wStart) {
		this.setLayout(new GridLayout(13, 13));
		pressed = new ArrayList<String>();
		
		for(int x = 14; x > 1; x--) {
			boolean suited = true;
			for(int y = 14; y > 1; y--) {
			JToggleButton add = new JToggleButton();
			add.addActionListener(this);
			String text = "" + x + y;
			if(x == y) {
				suited = false;
			}
			text = suited? "s": "o" ;
			if(x == y) {
				text = "";
			}
			add.setText(intToString(x) + intToString(y) + text);
			this.add(add);
			}
		}
		
	}
	
	
	public void readComponets() {
		for(int i = 0; i < this.getComponentCount(); i++) {
			if(this.getComponent(i) instanceof JToggleButton)
			System.out.println(((JToggleButton) (this.getComponent(i))).getText());
		}
	}
	/**
	 * changes x from an int to a string
	 * ie: 1 returns "A"
	 * 
	 * 	for ACE
	 * @param x
	 * @return
	 */
	private String intToString(int x) {
		switch (x) {
		case 14:
			return "A";
		case 10: 
			return "T";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13: 
			return "K";
			
		default: 
			return Integer.toString(x);
		}
	}
	
	
	/**
	 * @return the pressed
	 */
	public ArrayList<String> getPressed() {
		return pressed;
	}


	/**
	 * converts r to a string
	 * IE Rank.TWO returns "2"
	 * @param r
	 * @return
	 */
	private String rankToString( Rank r) {
		switch(r) {
		case TWO:
			return "2";
		case ACE:
			return "A" ;
		case EIGHT:
			return "8" ;
		case FIVE:
			return "5" ;
		case FOUR:
			return "4" ;
		case JACK:
			return "J" ;
		case KING:
			return "K" ;
		case NINE:
			return "9" ;
		case QUEEN:
			return "Q" ;
		case SEVEN:
			return "7" ;
		case SIX:
			return "6" ;
		case TEN:
			return "T" ;
		case THREE:
			return "3" ;
		default:
			return " " ;
			
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton work;
		if(arg0.getSource() instanceof JToggleButton) {
				work = (JToggleButton) arg0.getSource();
		}else {
			return;
		}
		String text = work.getText();
		if(work.isSelected()) {
			pressed.add(text);
		}else {
			pressed.remove(text);
		}
	
		
	}
}
