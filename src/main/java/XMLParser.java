import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLParser {

    public static void parse(String filename) {
        try {
            File file = new File(filename);
            JAXBContext context = JAXBContext.newInstance(ApartmentLocation.class, Root.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Root root = (Root) unmarshaller.unmarshal(file);
        } catch (JAXBException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
