package cp213;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a Storage Class
 * @param <T> The type of data to store
 */
public class Storage<T> {
	
	// Initialize storage for the respective items
    private Map <T, Integer> storage = new HashMap<T, Integer>();
    

    public Map<T, Integer> getStorage() {
		return storage;
	}

	public void setStorage(Map<T, Integer> storage) {
		this.storage = storage;
	}

	/**
     * Implements a Storage Class
     * @param <T> The type of item to retrieve
     * @return null or the number of items in the given key
     */
    public int getQuantityOfItem (T item) {
    	
    	Integer quantity = storage.get(item);
    	
    	if (quantity == null) {
        	return 0;
    	}
    	
    	return quantity;
    	
    }
    
    /**
     * Adds items to the Hash Map and increments based on quantity
     * @param <T> The type of item
     * @param int the number of items to add
     * 
     * @return void
     */
    public void putItems(T item, int quantity) {
    
        storage.put(item, quantity);    	
        
    }
    
    /**
     * Adds item to the Hash Map and increments by 1
     * @param <T> The type of item
     * 
     * @return void
     */
    public void addItem(T item) {
    	
    	Integer quantity = storage.get(item);
    	if (quantity ==null){
    		quantity = 0;
        	storage.put(item, quantity + 1);

    	} else {
        	storage.put(item, quantity + 1);
    	}
    	
    }
    

    /**
     * Removes a item from Hash Map and decreases total
     * @param <T> The type of item
     * 
     * @return void
     */
    public void removeItem (T item) {
    	
    	Integer quantity = storage.get(item);
    	storage.put(item, quantity - 1);
    	
    }
    
    /**
     * Verifies if any items are present in the given key
     * @param <T> The type of item
     * 
     * @return boolean
     */
    public boolean containsItem (T item) {
    	
    	return storage.get(item) > 0;
    }
    public  Integer getByValue (T item) {
    	
    	return storage.get(item);
    }

   
}