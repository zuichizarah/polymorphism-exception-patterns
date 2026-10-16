import java.util.ArrayList;

// SINGLETON PATTERN: only one ParcelManager exists in the whole program
public class ParcelManager {
    private static ParcelManager instance = new ParcelManager();
    private ArrayList<Parcel> parcels = new ArrayList<>();

    private ParcelManager() {
    }

    public static ParcelManager getInstance() {
        return instance;
    }

    public void checkDuplicate(String trackingNumber) throws DuplicateParcelException {
        for (Parcel p : parcels) {
            if (p.getTrackingNumber().equals(trackingNumber)) {
                throw new DuplicateParcelException("Tracking number already exists!");
            }
        }
    }

    public void addParcel(Parcel parcel) throws DuplicateParcelException {
        checkDuplicate(parcel.getTrackingNumber());
        parcels.add(parcel);
    }

    public Parcel findParcel(String trackingNumber) throws ParcelNotFoundException {
        for (Parcel p : parcels) {
            if (p.getTrackingNumber().equals(trackingNumber)) {
                return p;
            }
        }
        throw new ParcelNotFoundException("Parcel not found!");
    }

    public ArrayList<Parcel> getParcels() {
        return parcels;
    }
}
