package collections;

import collections.models.MilitaryType;
import collections.planes.MilitaryPlane;
import collections.planes.PassengerPlane;
import collections.planes.Plane;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MainTask {
    static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 200, 12000, 60500, 170, 164),
            new PassengerPlane("Boeing-737-800", 230, 12300, 63870, 180, 192),
            new PassengerPlane("Boeing-747", 300, 16100, 70500, 175, 242),
            new PassengerPlane("Airbus A320", 160, 11800, 65500, 150, 188),
            new PassengerPlane("Airbus A330", 180, 14800, 80500, 154, 222),
            new PassengerPlane("Embraer 190", 190, 8100, 30800, 145, 64),
            new PassengerPlane("Sukhoi Superjet 100", 150, 11500, 50500, 140, 140),
            new PassengerPlane("Bombardier CS300", 310, 11000, 60700, 170, 196),
            new MilitaryPlane("B-1B Lancer", 10, 21000, 80000, 180, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 8, 22000, 70000, 180, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 6, 20000, 80000, 175, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 2, 12000, 10000, 190, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 3, 13000, 11000, 200, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 80, 5000, 110000, 175, MilitaryType.TRANSPORT)
    );

    public static void main(String[] args) {
        Airport airport = new Airport(planes);

        System.out.printf("Общая вместимость груза самолетов: %d\n", airport.getTotalCapacity());
        System.out.printf("Общая вместимость пассажиров самолетов: %d\n", airport.getTotalPassengersCapacity());
        System.out.println("Самолеты, отсортированные по дальности полета:");
        airport.sortByMaxDistance();
        airport.getPlanes().forEach(System.out::println);
        System.out.println();
        Optional<? extends Plane> planeWithFuelConsumptionIn195_210 = airport.getPlanesInRangeFuelConsumption(195, 210).stream().findFirst();
        if (planeWithFuelConsumptionIn195_210.isPresent())
            System.out.printf("Самолет, потребление горючего которого лежит в диапазоне 195 - 210: %s", planeWithFuelConsumptionIn195_210.get());
        else
            System.out.print("Нет самолетов, потребление горючего которых лежит в диапазоне 195 - 210");

    }
}
