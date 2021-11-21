package collections.planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private final int passengersCapacity;

    public PassengerPlane(String model, int maxPassengersCapacity, int maxFlightDistance, int maxLoadCapacity, int fuelConsumptionInHour, int passengersCapacity) {
        super(model, maxPassengersCapacity, maxFlightDistance, maxLoadCapacity, fuelConsumptionInHour);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                        '}');
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof PassengerPlane)) return false;
        if (!super.equals(other)) return false;
        PassengerPlane otherPlane = (PassengerPlane) other;
        return passengersCapacity == otherPlane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
