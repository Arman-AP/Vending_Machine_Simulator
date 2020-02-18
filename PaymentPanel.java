package cp213;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;

@SuppressWarnings("serial")
public class PaymentPanel extends A05Panels {
	private A05Listeners listener;
	private A05Labels funds = new A05Labels("0.00");
	public PaymentPanel(A05Listeners listen) {
		super();
		this.listener = listen;
		this.setLayout(new GridLayout(3,1));
    	this.setBounds(485,420,200,200);
    	populate();
	}
    // ---------------------------------------------------------------
    /**
     * Uses the GridLayout to place the labels and buttons.
     * @return 
     */

	private void populate() {
		A05Panels top= new A05Panels();

		A05Panels mid= new A05Panels();
		A05Panels bottom = new A05Panels();
		A05Labels currentFunds = new A05Labels("Funds: $");

		A05Buttons ejectFunds = new A05Buttons("Eject Funds");
		A05Buttons credit = new A05Buttons("Credit");
		A05Buttons cash = new A05Buttons("Cash");
		top.add(currentFunds);		top.add(funds);
		mid.setBorder(BorderFactory
    			.createMatteBorder(3, 3, 0, 3, Color.BLACK));
		ejectFunds.addActionListener(listener.new ejectFunds("ejectfunds",listener, getFunds()));
		mid.setBackground(Color.WHITE);
		mid.add(ejectFunds);
		bottom.setBackground(Color.WHITE);

		bottom.setBorder(BorderFactory
    			.createMatteBorder(0, 3, 3, 3, Color.BLACK));
		bottom.add(credit);
		bottom.add(cash);
		credit.addActionListener(listener.new creditHandler("creditHandler", listener, getFunds()));
		cash.addActionListener(listener.new cashHandler("cashHandler", listener, getFunds()));
		this.add(top);
		this.add(mid);
		this.add(bottom);
	}
	public A05Labels getFunds() {
		return funds;
	}
	public void setFunds(A05Labels funds) {
		this.funds = funds;
	}
}
