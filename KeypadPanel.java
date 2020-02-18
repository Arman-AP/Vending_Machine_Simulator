package cp213;

import java.awt.Color;
import java.awt.GridLayout;



// ---------------------------------------------------------------
/**
 * View and update the right triangle model with buttons that increment the base
 * and height by 5.
 *
 * @author David Brown from Byron Weber-Becker
 * @version 2017-06-19
 */
@SuppressWarnings("serial")
public class KeypadPanel extends A05Panels {

	A05Buttons[] digits = new A05Buttons[(int)Math.round( 
    		Math.sqrt(
        			Item.values().length))];
	A05Listeners listener ;
	A05Buttons clear = new A05Buttons("Clear");
	String[] alphabet = {"A","B","C","D","E","F","G","H"};
	A05Buttons[] letters = new A05Buttons[(int) Math.ceil(
    		Math.sqrt(
        			Item.values().length))];

    /**
     * The view constructor.
     *
     * @param newModel
     *            The right triangle model.
     */
    public KeypadPanel(A05Listeners listen ) {
    	super();
		this.layoutView();
    	this.setBounds(485,140,200,200);
    	
    	this.listener = listen;
    	populateButtons();
	}

    // ---------------------------------------------------------------
    /**
     * Uses the GridLayout to place the labels and buttons.
     */
    private void layoutView() {
        GridLayout layout = new GridLayout(letters.length + 1,
        		digits.length);
		this.setLayout(layout);
		this.setBackground(Color.white);
		
    }

    // ---------------------------------------------------------------
    /**
     * Assigns listeners to the view widgets and the model.
     */

    private void populateButtons() {
		
		Integer count = 1;
		for (int x = 0; x< digits.length; x++) {
			digits[x] = new A05Buttons(count.toString());
			digits[x].addActionListener(listener.new SelectedItem (count.toString()));
			this.add(digits[x]);
			
			count++;

		}
		count = 0;
		for (int x = 0; x< letters.length; x++) {
			letters[x] = new A05Buttons(alphabet[x]);
			letters[x].addActionListener(listener.new SelectedItem (alphabet[x]));
			this.add(letters[x]);
			count ++;
		}
		
		clear.addActionListener(listener.new ClearSelectedItem ("CLR"));
		clear.setBackground(Color.gray);
		this.add(clear);
	}
    // ---------------------------------------------------------------
}