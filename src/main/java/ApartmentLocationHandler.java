import java.util.*;

public class ApartmentLocationHandler {
    public static final int MAX_FLOOR = 5;
    public static void showRepeats(List<ApartmentLocation> apartmentLocations) {
        Map<ApartmentLocation, Integer> apartmentLocationsWithRepeats = new HashMap<>();
         for (ApartmentLocation apartmentLocation : apartmentLocations) {
            if (apartmentLocationsWithRepeats.containsKey(apartmentLocation)) {
                apartmentLocationsWithRepeats.put(apartmentLocation, apartmentLocationsWithRepeats.get(apartmentLocation) + 1);
            } else {
                apartmentLocationsWithRepeats.put(apartmentLocation, 1);
             }
        }

        for (Map.Entry<ApartmentLocation, Integer> pairOfLocationAndCount: apartmentLocationsWithRepeats.entrySet()) {
            if (pairOfLocationAndCount.getValue() > 1) {
                System.out.println(pairOfLocationAndCount.getKey() + " - repeats = " + pairOfLocationAndCount.getValue());
            }
        }
    }

    public static void showCitiesWithFloors(List<ApartmentLocation> apartmentLocations) {
        Map<String, List<Integer>> citiesWithFloors = new HashMap<>();

        for (ApartmentLocation apartmentLocation : apartmentLocations) {

            String city = apartmentLocation.getCity();
            int floor = apartmentLocation.getFloor();

            if (citiesWithFloors.containsKey(city)) {
                citiesWithFloors.get(city).set(
                        floor, citiesWithFloors.get(city).get(floor) + 1
                );
            } else {
                List<Integer> listWithFloors = new ArrayList<>(MAX_FLOOR + 1);
                for (int i = 0; i <= MAX_FLOOR; i++) {
                    listWithFloors.add(i, 0);
                }
                listWithFloors.set(floor, 1);
                citiesWithFloors.put(city, listWithFloors);
            }
        }

        for (Map.Entry<String, List<Integer>> cityWithFloors: citiesWithFloors.entrySet()) {
            System.out.print(cityWithFloors.getKey() + " - ");
            for (int i = 1; i <= MAX_FLOOR; i++) {
                System.out.print(i + " floor - " + cityWithFloors.getValue().get(i) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ApartmentLocation> removeDuplicates(List<ApartmentLocation> apartmentLocations) {
        Set<ApartmentLocation> set = new HashSet<>(apartmentLocations);
        return new ArrayList<>(set);
    }

}