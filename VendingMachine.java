     package cp213;

import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class VendingMachine extends A05Frames {

	public VendingMachine(Storage<Item> itemInventory, Storage<Cash> vendingBalance) {
		setResizable(false);
		setTitle("JAVA Vending Machine");
		setSize(750, 775);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
        GridLayout layout = new GridLayout(1,3);
        layout.setHgap(55);
        layout.setVgap(55);


		Storage<Cash> userBalance = new Storage<Cash>();

		
        A05Listeners listener = new A05Listeners("Listener");
        
		listener.setInventory(itemInventory);
		listener.setuserBalance(userBalance);
		listener.setVendingBalance(vendingBalance);
        A05Labels text = new A05Labels();
        A05Labels selectionField = new A05Labels();
        KeypadPanel keys = new KeypadPanel(listener);
        
        listener.setField(selectionField);
        add(keys);
        VendingMachinePanel t = new VendingMachinePanel();
        text.setText("Selected Item: ");
        text.setBounds(485,110,100,20);
        keys.setBackground(this.getBackground());
        selectionField.setText(""); 
        selectionField.setBounds(640,110,100,20);
        add(text);        add(selectionField);
        add(t);
        A05Buttons checkout = new A05Buttons("CHECKOUT");
        checkout.setBounds(485,360,200,40);

        add(checkout);
        PaymentPanel payment = new PaymentPanel(listener);
        
        checkout.addActionListener(listener.new checkout
        		("checkout",listener, payment.getFunds(),
        				selectionField, this, t.getIndexes()));

        add(payment);

		
	}

	 public static void main(String[] args) {
	 }
	 }

