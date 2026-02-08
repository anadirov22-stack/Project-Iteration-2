package factory;

import model.Drone;

public class DroneFactory {

    public static Drone createDrone(int id, String model, double payload) {
        return new Drone(id, model, payload, true);
    }
}
