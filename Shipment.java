package Ecommerce;

import java.time.LocalDateTime;

public class Shipment {

    private static int numberCounter = 0;
    private int shipmentNumber;
    private LocalDateTime date;
    private LocalDateTime estimatedArrival;
    private Order orderDetails;

    public Shipment(Order orderDetails) {
        numberCounter += 1;
        this.shipmentNumber = numberCounter;
        this.date = LocalDateTime.now();
        this.estimatedArrival = this.date.plusDays(3);
        this.orderDetails = orderDetails;
        orderDetails.setOrderStatus(OrderStatus.SHIPPED);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentNumber=" + shipmentNumber +
                ", date=" + date +
                ", estimatedArrival=" + estimatedArrival +
                ", orderDetails=" + orderDetails +
                '}';
    }

}
