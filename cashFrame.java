package cp213;

import java.awt.BorderLayout;


@SuppressWarnings("serial")
public class cashFrame extends A05Frames {
	private A05Listeners listener ;
	private A05Labels funds;

	private A05Buttons[] currencies = new A05Buttons[Cash.values().length];
	private A05Labels balance = new A05Labels();
	public A05Labels getBalance() {
		return balance;
	}
	
	public void setBalance(A05Labels balance) {
		this.balance = balance;
	}
	
	public cashFrame(A05Listeners listen, A05Labels funds) {
		super();
		this.listener = listen;
		this.setFunds(funds);
		
		A05Panels top = new A05Panels();
		A05Panels bottom = new A05Panels();
		A05Labels balanceStr = new A05Labels("Balance:");
		listen.updateBalances(listen, balance, funds);
		int counter = 0;
		for(Cash each : Cash.values()) {

			currencies[counter] = new A05Buttons(
					"$" + Double.toString(each.getValue()) 
					
					);
			bottom.add(currencies[counter]);
			currencies[counter].addActionListener(listener
					.new addCash("addcash",listener,
							this.balance, each, this.funds));
			counter++;
		}
		top.add(balanceStr);
		top.add(balance);

		this.add(top, BorderLayout.PAGE_START);
		this.add(bottom, BorderLayout.CENTER);

		this.setSize(200,200);
		this.setLocationRelativeTo(null);
		
	}
	public A05Labels getbalance() {
		return balance;
	}

	public void setbalance(A05Labels balance) {
		this.balance = balance;
	}

	public A05Labels getFunds() {
		return funds;
	}

	public void setFunds(A05Labels funds) {
		this.funds = funds;
	}
}
