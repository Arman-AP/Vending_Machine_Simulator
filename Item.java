package cp213;

/**
 * Define collection of item constants
 */
public enum Item {
	
	// 4 Types of Chips
    Pringles("Pringles", "chips", 1),
	Ruffles("Ruffles", "chips", 1),
	MissVickies("Miss Vickies", "chips", 1),
	Lays("Lays", "chips", 1),
	
	// 6 Types of Chocolate Bars
	KitKat("KitKat", "chocolate", 1),
	Snickers("Snickers", "chocolate", 1),
	Twix("Twix", "chocolate", 1),
	Toblerone("Toblerone", "chocolate", 1),
	Hershey("Hershey", "chocolate", 1),
	Crunch("Crunch", "chocolate", 1),
	
	// 5 Types of Gum
	Excel("Excel", "gum", 1),
	JuicyFruit("Juicy Fruit", "gum", 1),
	Dentyne("Dentyne", "gum", 1),
	Trident("Trident", "gum", 1),
	DubbleBubble("DubbleBubble", "gum", 1),
	
	// Additional Item
	Oreos("Oreos", "cookies", 1),
	
	;
    private int price;
    private String name;
    private String type;
   
    
    /**
     * Create Item object with name, type, and price
     * @param String name of item
     * @param String type of item
     * @param int price of item
     */
    private Item(String name, String type, int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }
   
    /**
     * Return the name of the Item
     * @return name of item
     */
    public String getName(){
        return name;
    }
   
    /**
     * Return the price of the Item
     * @return price of item
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Return the type of the Item
     * @return type of item
     */
    public String getType(){
        return type;
    }
    
}
