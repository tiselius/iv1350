package integration;

/**
 * Exception for when the item is not valid
 * 
 */
public class ItemNotValidException extends Exception {

    /**
     * 
     * 
     * Creates an instance of ItemNotValidException
     * 
     * @param errorMessage the error message to display
     */
    public ItemNotValidException(String errorMessage) {
        super(errorMessage);
    }

}