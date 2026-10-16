public class Box extends Parcel {
    public static final double MAX_WEIGHT = 50;
    private int length;
    private int width;
    private int height;

    public Box(String trackingNumber, String receiverName, double weight, int length, int width, int height)
            throws InvalidInputException {
        this(trackingNumber, receiverName, weight, length, width, height, MAX_WEIGHT);
    }

    // Used by Fragile, which has a different maximum weight
    protected Box(String trackingNumber, String receiverName, double weight,
                  int length, int width, int height, double maxWeight) throws InvalidInputException {
        super(trackingNumber, receiverName, weight, maxWeight);
        validateDimension(length);
        validateDimension(width);
        validateDimension(height);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public static void validateDimension(int value) throws InvalidInputException {
        if (value <= 0) {
            throw new InvalidInputException("Length, width, and height must be greater than 0!");
        }
    }

    public double getVolumetricWeight() {
        // cast to double first so very large boxes do not overflow int
        return ((double) length * width * height) / 3500.0;
    }

    @Override
    public String getType() {
        return "Box";
    }

    // Bigger of actual and volumetric weight, rounded UP to the next whole kg
    @Override
    public double getChargeableWeight() {
        double bigger = Math.max(getWeight(), getVolumetricWeight());
        return Math.ceil(bigger);
    }

    @Override
    public double getBaseFee() {
        return 40 * getChargeableWeight();
    }
}
