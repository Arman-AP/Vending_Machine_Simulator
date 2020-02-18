package cp213;

/**
 * Define collection of cash constants (various values)
 */
public enum Cash {
	TEN(10.00),
	FIVE(5.00),
	TOONIE(2.00), 
	LOONIE(1.00),
	QUARTER(0.25),
	DIME(0.10),
	NICKEL(0.05);

	
    private double value;
  
    /**
     * Create Item object with value
     * @param double value of cash
     */
    Cash(double value){
        this.value = value;
    }
    
    public double getValue() {
    	return this.value;
    }
}
