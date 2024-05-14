package integration;

/**
 * Exception for when the database is not reachable
 * 
 * params: errorMessage the error message to display
 * 
 */
public class DBNotReachableException extends Exception {
    public DBNotReachableException(String errorMessage) {
        super(errorMessage);
    }
}