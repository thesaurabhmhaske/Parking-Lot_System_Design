import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String args[]) {
        Admin adminA = new Admin(1, "Raja");

        List<VehicleSlot> slots = new ArrayList<>(List.of(
                new VehicleSlot(1, VehicleType.BIKE),
                new VehicleSlot(2, VehicleType.BIKE),
                new VehicleSlot(3, VehicleType.CAR),
                new VehicleSlot(3, VehicleType.CAR)));
        adminA.addVehicleSlotsInParking(slots);

        Parking parkingA = adminA.parking;
        Vehicle carA = new Vehicle("UP16LP1234", VehicleType.CAR);
        Vehicle carB = new Vehicle("UP17MP1334", VehicleType.CAR);
        Vehicle carC = new Vehicle("HR02MP6543", VehicleType.CAR);

        // Vehicle entering the Parking..
        parkingA.addVehicleInParking(carA, System.currentTimeMillis());
        parkingA.addVehicleInParking(carB, System.currentTimeMillis());
        parkingA.addVehicleInParking(carC, System.currentTimeMillis());

        //GetAvaliable Parkinng lots
        printAvaliableSlot(parkingA.avaliableSlots);

        // Vehicle exiting the Parking..
        parkingA.removeVehicleFromParking(carA, System.currentTimeMillis());

        printAvaliableSlot(parkingA.avaliableSlots);

        // print the biling details of Vehicle..
        BillingDetails billingDetails = carA.getBillingDetails();
        printBillingDetails(billingDetails);

    }

    private static void printBillingDetails(BillingDetails billingDetails){
        System.out.println("Bill No." + billingDetails.billId + "\n" + "Tickte Price:" + billingDetails.ticketPrice);
    }

    private static void printAvaliableSlot(List<VehicleSlot> vehicleSlots){
        System.out.println("Following Slots are Avaliable");
        for(VehicleSlot vs: vehicleSlots){
            System.out.println(vs.slotId + " " + vs.vehicleSlotType.toString());
        }
    }
}