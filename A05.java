package cp213;

import javax.swing.JFrame;
//Author: Arman Aryanpour
//student ID: 180825150
//This is the main class to initiate the program.
//It is recommended that you have implemented main()only in this class, unless otherwise required.
public class A05 {

	public static void main(String[] args) {

		Storage<Cash> vendingBalance = new Storage<Cash>();
		for (Cash each: Cash.values()) {
				vendingBalance.putItems(each, 10);
			}
        Storage<Item> itemInventory = new Storage<Item>();

		for (Item item : Item.values()) {
			itemInventory.putItems(item, 10);
		}
		
		 JFrame vendingWindow = new VendingMachine(itemInventory, vendingBalance); 
		 vendingWindow.setVisible(true);
		
	}
	

}
