public class StandardService implements DeliveryService {
    @Override
    public String getName() {
        return "Standard";
    }

    @Override
    public boolean isAllowed(Parcel parcel) {
        return true;
    }

    @Override
    public double calculateFee(double baseFee) {
        return baseFee;
    }
}
