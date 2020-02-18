package cp213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

//If you need to implement/use a listener in your program then it must be an instance of this class.
//You can add suitable Interfaces to the header/definition of this class using implements.

public class A05Listeners /*add your required Listener Interfaces here*/ {

	 String componentID;//your own unique way of identifying components that will be attached
	//to the A05Listener objects. This way you will be able to distinguish that which component has
	//invoked the action handler.
	private Storage<Item> inventory;
	private Storage<Cash> userBalance;
	private Storage<Cash> vendingBalance;

	private A05Labels field;
	public A05Listeners(String arg) {//DO NOT modify this line
		setComponentID(arg);//DO NOT modify this line
		//you can perform additional actions here.
	}
	
	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public Storage<Item> getInventory() {
		return inventory;
	}

	public void setInventory(Storage<Item> inventory) {
		this.inventory = inventory;
	}
	public A05Labels getField() {
		return field;
	}

	public void setField(A05Labels field) {
		this.field = field;
	}
	public Storage<Cash> getuserBalance() {
		return userBalance;
	}

	public void setuserBalance(Storage<Cash> userBalance) {
		this.userBalance = userBalance;
	}
	public class ClearSelectedItem extends A05Listeners implements ActionListener {

		public ClearSelectedItem(String arg) {
			super(arg);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			A05Listeners.this.getField()
			.setText("");

		}
	}
	public class SelectedItem extends A05Listeners implements ActionListener {
		
		public SelectedItem(String arg) {
			super(arg);

			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(A05Listeners.this.getField().getText().length()< 1) {
				if ( !getComponentID().matches("-?\\d+")) {
					A05Listeners.this.getField().setText(getComponentID());
				}
			} else if (A05Listeners.this.getField()
					.getText().length()<2) {
				if ( getComponentID().matches("-?\\d+")) {
					A05Listeners.this.getField().
					setText(A05Listeners.this.getField().getText() + getComponentID());
				}
			} else {
				if ( !getComponentID().matches("-?\\d+")) {
					A05Listeners.this.getField().setText(getComponentID());
				} else {
				A05Listeners.this.getField().setText("");
				}
			}
			
		}
		
	}
	public class addCash extends A05Listeners implements ActionListener {
		private A05Listeners listener;
		private A05Labels balance;
		private Cash amount;
		private A05Labels funds;
		public addCash(String arg ,A05Listeners listen, A05Labels balance, Cash each, A05Labels fund) {
			super(arg);
			this.amount = each;
			this.balance = balance;
			this.listener = listen;
			this.funds = fund;
			}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			listener.getuserBalance().addItem(amount);
			listener.getVendingBalance().addItem(amount);
			updateBalances(listener,this.balance, this.funds);
		}
		
	
	}
	public double updateBalances(A05Listeners listener,  A05Labels funds) {
		double total = 0;
        for (Cash items: Cash.values()) {
        	total = total + 
        		(listener.getuserBalance().getQuantityOfItem(items))
        		*
        		items.getValue()
        		;
        }

		total = Math.round(total*100.0)/100.0;

		funds.setText(Double.toString(total));
        return total;
	}
	public double updateBalances(A05Listeners listener, A05Labels balance, A05Labels funds) {
		double total = 0;
        for (Cash items: Cash.values()) {
        	total = total + 
        		(listener.getuserBalance().getQuantityOfItem(items))
        		*
        		items.getValue()
        		;
        	
        }
        
        total = Math.round(total*100.0)/100.0;
		funds.setText(Double.toString(total));
		balance.setText(Double.toString(total));

        return total;
	}
	public Storage<Cash> getVendingBalance() {
		return vendingBalance;
	}

	public void setVendingBalance(Storage<Cash> vendingBalance) {
		this.vendingBalance = vendingBalance;
	}
	public class cashHandler extends A05Listeners implements ActionListener {
		private A05Labels funds;
		private A05Listeners listener;
		public cashHandler(String arg, A05Listeners listen, A05Labels fund) {
			super(arg);
			this.listener = listen;
			this.funds = fund;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			cashFrame cash = new cashFrame(A05Listeners.this, funds);
			updateBalances(listener,cash.getbalance(), funds);
			cash.setVisible(true);
		}
        
	}
	
	public class ejectFunds extends A05Listeners implements ActionListener {
		private A05Listeners listener;
		private A05Labels funds;

		public ejectFunds(String arg, A05Listeners listen, A05Labels fund) {
			super(arg);
			this.listener = listen;
			this.funds = fund;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			listener.getuserBalance().getStorage().clear();
			updateBalances(listener, funds);
		}
		
	}
	public class creditHandler extends A05Listeners implements ActionListener {
		private A05Listeners listener;
		private A05Labels funds;

		public creditHandler(String arg, A05Listeners listen, A05Labels fund) {
			super(arg);
			this.listener = listen;
			this.funds = fund;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			listener.getuserBalance().getStorage().clear();
			updateBalances(listener, funds);
			funds.setText("Verifying...");
			try {

				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(Math.random() < 0.1){
				funds.setText("Card not valid");
				} else {
					funds.setText("Card Validated");

				}
		}
		
	}
	public class checkout extends A05Listeners implements ActionListener {
		private A05Listeners listener;
		private A05Labels funds;
		private A05Labels selection;
		private VendingMachine parent;
		private String[] typeIndex;
		public checkout(String arg, A05Listeners listen, A05Labels fund,
				A05Labels text2, VendingMachine container, String[] indexes) {
			super(arg);
			this.listener = listen;
			this.funds = fund;
			this.selection = text2;
			this.parent = container;
			this.typeIndex = indexes;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(selection.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this.parent,
						"Select a product first.");
			} else if (selection.getText().length()==1) {
				JOptionPane.showMessageDialog(this.parent,
						"Not a valid selection.");

			} else {
				int selectedIndex = 0;
				Item selectedItem = null;
				for(Item items:Item.values()) {
					if(typeIndex[selectedIndex].equals(selection.getText())) {

						selectedItem = items;
					}
					selectedIndex++;
				}
				int dialogResult = JOptionPane.showConfirmDialog(this.parent,
						"You have selected " + selectedItem.getName()
						+ "\nThis product is a " + selectedItem.getType()
						+"." + "\n" + "Price: $" + selectedItem.getPrice(),
						"Confirm Purchase", 
		                JOptionPane.OK_CANCEL_OPTION, 
		                JOptionPane.INFORMATION_MESSAGE);
				if(dialogResult == JOptionPane.YES_OPTION){
					if(this.funds.getText().equals("Card Validated")){
						cardCheckout(selectedItem);
					} else {
						cashCheckout(selectedItem);
					}
			}}
		}
		private void cardCheckout(Item selectedItem) {
			if(listener.getInventory()
					  .getQuantityOfItem(selectedItem) 
					  < 1) {
					JOptionPane.showMessageDialog(parent,
							"Product not in stock!");
			  } else {
				  String msg = "Your Payment Method: Card \n";
				  msg += "Your product: ";
				  msg+= selectedItem.getName();
				  listener.inventory.removeItem(selectedItem);
					updateBalances(listener,funds);

					JOptionPane.showMessageDialog(this.parent,
							msg);
				
			  }
		}	
		private void cashCheckout(Item selectedItem) {


			  if (Double.parseDouble(funds.getText()) 
					  < selectedItem.getPrice()) {
					JOptionPane.showMessageDialog(this.parent,
							"Not enough funds!");
					
			  }  else if(listener.getInventory()
					  .getQuantityOfItem(selectedItem) 
					  < 1) {
					JOptionPane.showMessageDialog(this.parent,
							"Product not in stock!");
			  } else {
				  Double returnChange = Double.parseDouble(funds.getText())
						  - selectedItem.getPrice();
				
				  returnChange = Math.round(returnChange*100.0)/100.0;

				  int[] change = cashToCoin(returnChange);
				  int counter = 0;
				  boolean gotChange = true;
				  for(Cash each: Cash.values()) {

					  if (listener.getVendingBalance()
							  .getQuantityOfItem(each) < change[counter]) {
						  gotChange = false;
					  }
					  counter ++;
				  }
				  					  if(gotChange) {
					  counter = 0;
					  String msg = "Your Funds:" + funds.getText() + "\n";
					  msg += "Cost of your Item:" + selectedItem.getPrice() + "\n";
					  msg += "Your change: " + returnChange;
					  msg += "\n";
					  for(Cash each: Cash.values()) {
						  if (change[counter]!=0){
							  for(int x=0; x<change[counter];x++) {
							  listener.getVendingBalance().removeItem(each);
							  }
							  msg +=each.toString();
							  msg +=": ";
							  msg += change[counter];
							  msg += "\n";
						  }
						  counter++;
					  }
					  listener.getuserBalance().getStorage().clear();
					  updateBalances(listener, funds);
					  listener.inventory.removeItem(selectedItem);
						JOptionPane.showMessageDialog(this.parent,
								msg);

				  } else {
						JOptionPane.showMessageDialog(this.parent,
								"Sorry, the machine does not have enough change");

				  }
			  }
		}
	}
	private int[] cashToCoin(Double cash ) {
		int[] money = new int[Cash.values().length];
		int count = 0;
		for(Cash each:Cash.values()) {
			money[count] = (int)(cash / each.getValue()); 
			Double temp = cash % each.getValue();
			temp = Math.round(temp*100.0)/100.0;
			cash = temp;
			count ++;
		}

		return money;
		
	}
//you can add/override additional methods here.
}
	
