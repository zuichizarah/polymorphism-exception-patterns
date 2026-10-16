public class Fragile extends Box {
    public static final double MAX_WEIGHT = 30;
    private String handlingNote;

    public Fragile(String trackingNumber, String receiverName, double weight,
                   int length, int width, int height, String handlingNote) throws InvalidInputException {
        super(trackingNumber, receiverName, weight, length, width, height, MAX_WEIGHT);
        validateHandlingNote(handlingNote);
        this.handlingNote = handlingNote.trim();
    }

    public static void validateHandlingNote(String handlingNote) throws InvalidInputException {
        if (handlingNote == null || handlingNote.trim().isEmpty()) {
            throw new InvalidInputException("Handling note cannot be empty!");
        }
    }

    @Override
    public String getType() {
        return "Fragile";
    }

    // Box base fee + Php 100 handling fee
    @Override
    public double getBaseFee() {
        return super.getBaseFee() + 100;
    }

    public String getHandlingNote() { return handlingNote; }
}
