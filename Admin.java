import java.util.List;

public class Admin {
    int adminId;
    String adminName;
    Parking parking;

    public Admin(int adminId, String adminName) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.parking = new Parking();
        this.parking.ticketPricePerHr = 40.00;
        this.parking.currBillId=0;
    }

    public void addVehicleSlotsInParking(List<VehicleSlot> newVehicleSlots) {
        this.parking.avaliableSlots = newVehicleSlots;
    }

    public void updateThePricePerHr(Double amount){
        this.parking.ticketPricePerHr = amount;
    }
}
