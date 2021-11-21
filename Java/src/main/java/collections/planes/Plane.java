package collections.planes;

import java.util.Objects;

public abstract class Plane {
    private final String model;
    private final int maxPassengersCapacity;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;
    private final int fuelConsumptionInHour;

    protected Plane(String model, int maxPassengersCapacity, int maxFlightDistance, int maxLoadCapacity, int fuelConsumptionInHour) {
        this.model = model;
        this.maxPassengersCapacity = maxPassengersCapacity;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
        this.fuelConsumptionInHour = fuelConsumptionInHour;
    }

    public String getModel() {
        return model;
    }

    public int getMaxPassengersCapacity() {
        return maxPassengersCapacity;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    public int getFuelConsumptionInHour() {
        return fuelConsumptionInHour;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxPassengersCapacity +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Plane)) return false;
        Plane plane = (Plane) other;
        return maxPassengersCapacity == plane.maxPassengersCapacity &&
                maxFlightDistance == plane.maxFlightDistance &&
                maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxPassengersCapacity, maxFlightDistance, maxLoadCapacity);
    }
}
