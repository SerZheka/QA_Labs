package collections;

import collections.planes.Plane;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public void sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public int getTotalCapacity() {
        return planes.stream().mapToInt(Plane::getMaxLoadCapacity).sum();
    }

    public int getTotalPassengersCapacity() {
        return planes.stream().mapToInt(Plane::getMaxPassengersCapacity).sum();
    }

    public List<? extends Plane> getPlanesInRangeFuelConsumption(int minFuelConsumption, int maxFuelConsumption) {
        return planes.stream()
                .filter(plane -> plane.getFuelConsumptionInHour() > minFuelConsumption && plane.getFuelConsumptionInHour() < maxFuelConsumption)
                .collect(Collectors.toList());
    }

    public List<Plane> getPlanes() {
        return (List<Plane>) planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
