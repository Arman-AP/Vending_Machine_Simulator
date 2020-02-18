package cp213;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

public class VendingMachinePanel extends A05Panels{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] alphabet = {"A","B","C","D","E","F","G","H"};
	private int rows;
	private int columns;
	private String[] types = new String[Item.values().length];
	private String[] items = new String[Item.values().length];
	private String[] prices = new String[Item.values().length];
    public VendingMachinePanel() {
    	super();
		this.layoutView();
		this.setBounds(50,40,400,600);
		this.setBorder(BorderFactory.
    			createLineBorder(Color.GRAY, 5));
    	populateItems();
	}
    private void populateItems(){
    	
    	int count = 0;
    	for (int x = 0; x < rows;x++) {
    		String rowLetter = alphabet[x];
        	for (int y = 1; y < columns + 1;y++) {
        		if(count < Item.values().length) {
            		indexes[count] = rowLetter + 
            				Integer.toString(y);
            		count++;
        		}
        	}
    	}

    	count =0;
		for (Item item : Item.values()) {
			items[count] = item.getName();
			types[count]= item.getType();
			prices[count]= "$" + Double.toString(item.getPrice());
			A05Panels numHolder = new A05Panels();
			A05Panels cardHolder = new A05Panels();

	    	A05Labels l1 = new A05Labels(prices[count]);
	    	A05Labels l2 = new A05Labels(items[count]);
	    	A05Labels l3 = new A05Labels(types[count]);
	    	A05Labels l4 = new A05Labels(indexes[count]);

	    	numHolder.setLayout(new GridLayout(4, 1));
	    	
	    	l1.setAlignmentX(SwingConstants.CENTER);
	    	l1.setAlignmentY(SwingConstants.CENTER);
	    	l1.setVerticalAlignment(SwingConstants.CENTER);
	    	l1.setHorizontalAlignment(SwingConstants.CENTER);
	    	l2.setAlignmentX(SwingConstants.CENTER);
	    	l2.setAlignmentY(SwingConstants.CENTER);
	    	l2.setVerticalAlignment(SwingConstants.CENTER);
	    	l2.setHorizontalAlignment(SwingConstants.CENTER);
	    	l3.setAlignmentX(SwingConstants.CENTER);
	    	l3.setAlignmentY(SwingConstants.CENTER);
	    	l3.setVerticalAlignment(SwingConstants.CENTER);
	    	l3.setHorizontalAlignment(SwingConstants.CENTER);
	    	l4.setAlignmentX(SwingConstants.CENTER);
	    	l4.setAlignmentY(SwingConstants.CENTER);
	    	l4.setVerticalAlignment(SwingConstants.CENTER);
	    	l4.setHorizontalAlignment(SwingConstants.CENTER);
	    	l4.setOpaque(true);
	    	l4.setBackground(Color.gray);
	    	l4.setBorder(BorderFactory
	    			.createMatteBorder(0, 3, 0, 3, Color.WHITE));
	    	numHolder.add(l1);    
	    	numHolder.add(l2);
	    	numHolder.add(l3);
	    	numHolder.add(l4);

	    	numHolder.setBorder(BorderFactory
	    			.createLineBorder(Color.GRAY,4));
	    	numHolder.setBackground(Color.WHITE);
	    	cardHolder.add(numHolder);
	    	this.add(numHolder); 
			count++;
		}

    	
      }
    
    // ---------------------------------------------------------------
    /**
     * Uses the GridLayout to place the labels and buttons.
     */
    private void layoutView() {

    	this.columns =(int)Math.round( 
        		Math.sqrt(
            			Item.values().length));
    	this.rows =(int) Math.ceil(
        		Math.sqrt(
            			Item.values().length));
        GridLayout layout = new GridLayout(rows, columns);

		this.setLayout(layout);

		
    }
	public String[] getIndexes() {
		return indexes;
	}
	public void setIndexes(String[] indexes) {
		this.indexes = indexes;
	}

	private String[] indexes = new String[Item.values().length];

}
