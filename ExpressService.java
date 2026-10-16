public class ExpressService implements DeliveryService {
    @Override
    public String getName() {
        return "Express";
    }

    @Override
    public boolean isAllowed(Parcel parcel) {
        return true;
    }

    @Override
    public double calculateFee(double baseFee) {
        return baseFee * 1.5;
    }
}
