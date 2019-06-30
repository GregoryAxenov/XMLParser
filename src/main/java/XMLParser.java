import java.io.*;

public class XMLParser {
    private static final int NUMBER_OF_PROPERTIES = 4;
    private static final char QUOTE = '\"';
    private static final String LAST_LINE = "</root>";

    public static void parse(String filename) {
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
                int positionOfSymbol = 0;

                for (int i = 0; i < line.length(); i++) {
                    if (symbols[i] != QUOTE && isInQuotes) {
                        properties[indexOfProperty][positionOfSymbol] = symbols[i];
                        positionOfSymbol++;
                    } else if (symbols[i] == QUOTE) {
                        if (isInQuotes) {
                            lengthsOfProperties[indexOfProperty] = positionOfSymbol;
                            indexOfProperty++;
                            positionOfSymbol = 0;
                        }
                        isInQuotes = !isInQuotes;
                    }
                }

                String city = new String(properties[0],0, lengthsOfProperties[0]);
                String street = new String(properties[1],0, lengthsOfProperties[1]);
                int house = Integer.parseInt(new String(properties[2],0, lengthsOfProperties[2]));
                int floor = Integer.parseInt(new String(properties[3],0, lengthsOfProperties[3]));
                ApartmentLocation apartmentLocation = new ApartmentLocation(city, street, house, floor);
                Root.apartmentLocations.add(apartmentLocation);
                line = reader.readLine();
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
