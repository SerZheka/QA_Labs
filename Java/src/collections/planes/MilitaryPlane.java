package collections.planes;

import collections.models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private final MilitaryType type;

    public MilitaryPlane(String model, int maxPassengersCapacity, int maxFlightDistance, int maxLoadCapacity, int fuelConsumptionInHour, MilitaryType type) {
        super(model, maxPassengersCapacity, maxFlightDistance, maxLoadCapacity, fuelConsumptionInHour);
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                        '}');
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof MilitaryPlane)) return false;
        if (!super.equals(other)) return false;
        MilitaryPlane otherPlane = (MilitaryPlane) other;
        return type == otherPlane.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
