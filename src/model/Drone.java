package model;

public class Drone {
    private int id;
    private String model;
    private double maxPayload;
    private boolean available;

    public Drone(int id, String model, double maxPayload, boolean available) {
        this.id = id;
        this.model = model;
        this.maxPayload = maxPayload;
        this.available = available;
    }
}
