public class Document extends Parcel {
    public static final double MAX_WEIGHT = 0.5;
    private int numberOfPages;

    public Document(String trackingNumber, String receiverName, double weight, int numberOfPages)
            throws InvalidInputException {
        super(trackingNumber, receiverName, weight, MAX_WEIGHT);
        validatePages(numberOfPages);
        this.numberOfPages = numberOfPages;
    }

    public static void validatePages(int pages) throws InvalidInputException {
        if (pages < 1 || pages > 100) {
            throw new InvalidInputException("Number of pages must be from 1 to 100!");
        }
    }

    @Override
    public String getType() {
        return "Document";
    }

    @Override
    public double getChargeableWeight() {
        return getWeight();
    }

    @Override
    public double getBaseFee() {
        return 50;
    }

    public int getNumberOfPages() { return numberOfPages; }
}
