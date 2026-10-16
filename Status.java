public enum Status {
    PENDING("Pending"),
    DELIVERED("Delivered");

    private String label;

    Status(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
