public abstract class Parcel {
    private String trackingNumber;
    private String receiverName;
    private double weight;
    private DeliveryService service;
    private Status status;

    protected Parcel(String trackingNumber, String receiverName, double weight, double maxWeight)
            throws InvalidInputException {
        validateTrackingNumber(trackingNumber);
        validateReceiverName(receiverName);
        validateWeight(weight, maxWeight);
        this.trackingNumber = trackingNumber;
        this.receiverName = receiverName.trim();
        this.weight = weight;
        this.status = Status.PENDING;
    }

    // Validation methods are static so Main can check each input right away
    public static void validateTrackingNumber(String trackingNumber) throws InvalidInputException {
        boolean valid = trackingNumber != null && trackingNumber.length() == 7
                && trackingNumber.startsWith("ABC");
        if (valid) {
            // the last 4 characters must all be digits
            for (int i = 3; i < 7; i++) {
                char c = trackingNumber.charAt(i);
                if (c < '0' || c > '9') {
                    valid = false;
                }
            }
        }
        if (!valid) {
            throw new InvalidInputException("Tracking number must be \"ABC\" followed by 4 digits (e.g. ABC0001)!");
        }
    }

    public static void validateReceiverName(String receiverName) throws InvalidInputException {
        if (receiverName == null || receiverName.trim().isEmpty()) {
            throw new InvalidInputException("Receiver name cannot be empty!");
        }
    }

    public static void validateWeight(double weight, double maxWeight) throws InvalidInputException {
        if (weight <= 0) {
            throw new InvalidInputException("Weight must be greater than 0!");
        }
        if (weight > maxWeight) {
            throw new InvalidInputException("Weight cannot exceed " + maxWeight + " kg for this parcel type!");
        }
    }

    // Each parcel type has its own rules (polymorphism)
    public abstract String getType();
    public abstract double getChargeableWeight();
    public abstract double getBaseFee();

    // Delegates to the chosen delivery service (Strategy)
    public double getDeliveryFee() {
        return service.calculateFee(getBaseFee());
    }

    public String getTrackingNumber() { return trackingNumber; }
    public String getReceiverName() { return receiverName; }
    public double getWeight() { return weight; }
    public DeliveryService getService() { return service; }
    public Status getStatus() { return status; }

    public void setService(DeliveryService service) { this.service = service; }
    public void markDelivered() { this.status = Status.DELIVERED; }
}
