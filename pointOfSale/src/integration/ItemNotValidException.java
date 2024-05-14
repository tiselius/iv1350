package integration;

public class ItemNotValidException extends Exception {
    public ItemNotValidException(String errorMessage) {
        super(errorMessage);
    }
}