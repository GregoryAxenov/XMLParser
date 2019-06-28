public class XMLParserTestDrive {
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        long startTime = System.currentTimeMillis();
        //parser.parse("/home/gregory/Downloads/Address.xml");
        parser.parse("/home/gregory/Documents/address.xml");
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
