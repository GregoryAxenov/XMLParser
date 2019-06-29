import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    List<ApartmentLocation> listOfApartmentsLocations = new ArrayList<>();
    private static final int NUMBER_OF_PROPERTIES = 4;
    private static final char QUOTE = '\"';
    private static final String LAST_LINE = "</root>";

    public void parse(String filename) {
        try (
              FileReader fileReader = new FileReader(new File(filename));
              BufferedReader reader = new BufferedReader(fileReader);
              ) {
            String lineWithEncoding = reader.readLine();
            String lineWithRoot = reader.readLine();
            String line = reader.readLine();

            while (!line.equals(LAST_LINE)) {
                char[] symbols = line.toCharArray();
                boolean isInQuotes = false;
                int indexOfProperty = 0;
                int[] lengthsOfProperties = new int[NUMBER_OF_PROPERTIES];
                char[][] properties = new char[NUMBER_OF_PROPERTIES][line.length()];
                int numberOfSymbol = 0;

                for (int i = 0; i < line.length(); i++) {
                    if (symbols[i] != QUOTE && isInQuotes) {
                        properties[indexOfProperty][numberOfSymbol] = symbols[i];
                        numberOfSymbol++;
                    } else if (symbols[i] == QUOTE) {
                        if (isInQuotes) {
                            lengthsOfProperties[indexOfProperty] = numberOfSymbol;
                            indexOfProperty++;
                            numberOfSymbol = 0;
                        }
                        isInQuotes = !isInQuotes;
                    }
                }

                String city = new String(properties[0],0, lengthsOfProperties[0]);
                String street = new String(properties[1],0, lengthsOfProperties[1]);
                int house = Integer.parseInt(new String(properties[2],0, lengthsOfProperties[2]));
                int floor = Integer.parseInt(new String(properties[3],0, lengthsOfProperties[3]));
                ApartmentLocation apartmentLocation = new ApartmentLocation(city, street, house, floor);
                listOfApartmentsLocations.add(apartmentLocation);
                line = reader.readLine();
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
