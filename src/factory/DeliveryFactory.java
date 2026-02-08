package factory;

import model.Delivery;

public class DeliveryFactory {

    public static Delivery createScheduledDelivery(
            int id, int droneId, int packageId) {

        return new Delivery(id, droneId, packageId, "Scheduled");
    }
}
