import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Parking {
    List<Vehicle> parkedVehicles = new ArrayList<>();
    List<VehicleSlot> avaliableSlots = new ArrayList<>();
    Double ticketPricePerHr;
    int currBillId;

    public void addVehicleInParking(Vehicle vehicle, Long timestamp) {
        if (!this.avaliableSlots.isEmpty()) {
            Optional<VehicleSlot> avaliableSlot = this.avaliableSlots.stream()
                    .filter(vehicleSlot -> vehicleSlot.vehicleSlotType.equals(vehicle.vehicleType)).findFirst();
            if (avaliableSlot.isPresent()) {
                VehicleSlot vehicleSlot = avaliableSlot.get();
                avaliableSlots.remove(vehicleSlot);
                updateVehicleDetailsInitially(vehicle, avaliableSlot.get(), timestamp);
                parkedVehicles.add(vehicle);
                System.out.println(vehicle.vehicleNumber + " is Successfully Parked");
                return;
            }
        }
        System.out.println("All Parking Slots are occupied for " + vehicle.vehicleType.toString());
    }

    private void updateVehicleDetailsInitially(Vehicle vehicle, VehicleSlot vehicleSlot, Long timestamp) {
        vehicle.entryTime = timestamp;
        vehicle.vehicleSlot = vehicleSlot;
        vehicle.entryTime = timestamp;
    }

    public void removeVehicleFromParking(Vehicle vehicle, Long timestamp) {
        this.parkedVehicles.remove(vehicle);
        updateVehicleDetailsAfterExiting(vehicle, timestamp);
        this.parkedVehicles.add(vehicle);
        this.avaliableSlots.add(vehicle.vehicleSlot);
    }

    private void updateVehicleDetailsAfterExiting(Vehicle vehicle, Long timestamp) {
        vehicle.exitTime = timestamp;
        calculateBill(vehicle, this.ticketPricePerHr);
    }

    private void calculateBill(Vehicle vehicle, Double ticketPricePerHr) {
        Long totalParkedDurationInMillis = vehicle.exitTime - vehicle.entryTime;

        Double totalDurationInHr = totalParkedDurationInMillis.doubleValue() / 3600000;
        Double finalTicketPrice = totalDurationInHr > 1 ? totalDurationInHr * ticketPricePerHr : ticketPricePerHr;
        vehicle.billingDetails.billId = currBillId;
        vehicle.billingDetails.ticketPrice = finalTicketPrice;
        this.currBillId++;
    }

}
