/**
 * ID: U10316015 
 * Ex: 16.1
 * Information:
 *		PickFourCards class is written according to the requirements on P656.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PickFourCards extends JFrame{
	int[] deck = new int[52];
	ImageIcon[] pokerCards = new ImageIcon[52];
	
	//create a JPanel called ShowCards and four cards label
	JPanel ShowCards = new JPanel();
	JLabel card1 = new JLabel();
	JLabel card2 = new JLabel();
	JLabel card3 = new JLabel();
	JLabel card4 = new JLabel();
	
	//create a JPanel called ButtonRefresh and refresh button
	JPanel ButtonRefresh = new JPanel();	
	JButton refresh = new JButton("Refresh");
	
	//Creat constructor
	 PickFourCards(){
		// Initialize cards
		for ( int i = 0; i < deck.length ; i++ )
			deck[ i ] = i;

		for( int c = 1 ; c <= 52 ; c++ )
			pokerCards[ c - 1 ] = new ImageIcon( "cards/" +  c + ".png" );
			
		//set layout
		ShowCards.setLayout(new GridLayout(1,4));
		shuffle();
		
		ShowCards.add( card1 );	//add card1
		ShowCards.add( card2 );	//add card2		
		ShowCards.add( card3 );	//add card3
		ShowCards.add( card4 );	//add card4
		
		ButtonRefresh.add(refresh);	//create a button called Refresh
		
		add(ShowCards,BorderLayout.NORTH);	//add ShowCards in the north of the frame
		add(ButtonRefresh,BorderLayout.SOUTH);	//add ButtonRefresh in the south of the frame

		//register listener
		refresh.addActionListener(new FreshListener()); 
	}
	 
	 void shuffle(){
		// Shuffle the cards
		for (int i = 0; i < deck.length; i++) {
			// Generate an index randomly
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index]; 
			deck[index] = temp;
		}
		  
		card1.setIcon(pokerCards[deck[0]]);
		card2.setIcon(pokerCards[deck[1]]);
		card3.setIcon(pokerCards[deck[2]]);
		card4.setIcon(pokerCards[deck[3]]);
	}
	
	//class FreshListener implements ActionListener
	private class FreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			//refresh four cards
			shuffle();
		}
	}
	
  public static void main(String[] args) {
    	PickFourCards CARDS = new PickFourCards();	//create cards object 
		CARDS.setTitle("Pick Four Cards");	//set title
		CARDS.setSize(300,200);	//set size
		CARDS.setLocationRelativeTo(null);	//center the frame
		CARDS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//terminate when the frame is closed
		CARDS.setVisible(true);	//set visible
		
	}
 }
