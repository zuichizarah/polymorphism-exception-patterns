// STRATEGY PATTERN: each delivery service computes its own fee
public interface DeliveryService {
    String getName();
    boolean isAllowed(Parcel parcel);
    double calculateFee(double baseFee);
}
