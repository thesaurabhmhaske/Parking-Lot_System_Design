public class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    VehicleSlot vehicleSlot;
    Long entryTime;
    Long exitTime;
    BillingDetails billingDetails;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.billingDetails = new BillingDetails();

    }

    public BillingDetails getBillingDetails(){
        return this.billingDetails;
    }
}
