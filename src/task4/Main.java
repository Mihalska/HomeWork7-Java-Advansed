package task4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Cities cities = new Cities() ;
        cities.add(new City("Kiev", "Vasylkivska",1, "big"));
        cities.add(new City("Kharkiv", "Shevchenkа",2,"big" ));
        cities.add(new City("Odesa", "Deribasivska",3, "big"));
        try {
            File file = new File("C:\\Users\\Public\\Homework4.7\\src\\task4\\city.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Cities.class ) ;
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , true );
            marshaller.marshal(cities, file );
            marshaller.marshal(cities, System.out );
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }
}
