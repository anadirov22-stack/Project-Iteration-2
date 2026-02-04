package model;

public class Delivery {
    private int id;
    private int droneId;
    private int packageId;
    private String status;

    public Delivery(int id, int droneId, int packageId, String status) {
        this.id = id;
        this.droneId = droneId;
        this.packageId = packageId;
        this.status = status;
    }
}

