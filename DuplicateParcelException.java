// Thrown when a tracking number already exists
public class DuplicateParcelException extends Exception {
    public DuplicateParcelException(String message) {
        super(message);
    }
}
