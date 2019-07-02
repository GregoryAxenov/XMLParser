public class XMLParserTestDrive {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        XMLParser.parse("/home/gregory/Downloads/file.xml");
        ApartmentLocationHandler.showRepeats(Root.apartmentLocations);
        ApartmentLocationHandler.showCitiesWithFloors(ApartmentLocationHandler.removeDuplicates(Root.apartmentLocations));
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
