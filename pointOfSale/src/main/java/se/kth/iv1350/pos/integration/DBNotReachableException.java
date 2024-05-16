package main.java.se.kth.iv1350.pos.integration;

/**
 * Exception for when the database is not reachable
 * 
 * 
 * 
 */
public class DBNotReachableException extends Exception {

    /**
     * Creates an instance of DBNotReachableException
     * 
     * @param errorMessage the error message to display
     */
    public DBNotReachableException(String errorMessage) {
        super(errorMessage);
    }
}