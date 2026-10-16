public class SameDayService implements DeliveryService {
    @Override
    public String getName() {
        return "Same Day";
    }

    // Only for parcels with a chargeable weight of 10 kg or less
    @Override
    public boolean isAllowed(Parcel parcel) {
        return parcel.getChargeableWeight() <= 10;
    }

    @Override
    public double calculateFee(double baseFee) {
        return (baseFee * 2) + 100;
    }
}
