import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(propOrder={"city", "street" , "house", "floor"})
public class ApartmentLocation {
    private String city;
    private String street;
    private int house;
    private int floor;

    public ApartmentLocation () {
    }

    public ApartmentLocation(String city, String street, int house, int floor) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    public String getCity() {
        return city;
    }

    @XmlAttribute
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    @XmlAttribute
    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    @XmlAttribute
    public void setHouse(int house) {
        this.house = house;
    }

    public int getFloor() {
        return floor;
    }

    @XmlAttribute
    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "item" +
                " city=" + city +
                " street=" + street +
                " house=" + house +
                " floor=" + floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentLocation that = (ApartmentLocation) o;
        return house == that.house &&
                floor == that.floor &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, floor);
    }
}
