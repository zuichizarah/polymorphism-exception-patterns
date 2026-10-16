// Thrown when a tracking number does not exist
public class ParcelNotFoundException extends Exception {
    public ParcelNotFoundException(String message) {
        super(message);
    }
}
