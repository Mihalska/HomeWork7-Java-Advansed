package task4;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"cityName","streetName","houseNumber"})
@XmlRootElement(name = "city")
public class City {
    private String size;
    private String cityName;
    private String streetName;
    private int houseNumber;

    public City() {
    }
    public City(String cityName, String streetName, int houseNumber, String size ) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.size = size  ;
    }

    @Override
    public String toString() {
        return "City {" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
               ", houseNumber=" + houseNumber +
                '}';
    }

    @XmlAttribute
    public void setSize (String size) {  this.size  = size ;    }
    @XmlElement
    public void setCityName (String cityName ){
        this.cityName = cityName ;
    }
    @XmlElement
    public void setStreetName  (String streetName  ){
        this.streetName  = streetName ;
    }
    @XmlElement
    public void setHouseNumber (int houseNumber ){
        this.houseNumber = houseNumber ;
    }

    public String getCityName() {
        return cityName;
    }
    public String getStreetName() {
        return streetName;
    }
    public int getHouseNumber() {
        return houseNumber;
    }
    public String getSize () {
        return size ;
    }
}
