import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "root")
@XmlRootElement
public class Root {
    @XmlElement(name = "item")
    public List<ApartmentLocation> apartmentLocations = new ArrayList<>();

}
