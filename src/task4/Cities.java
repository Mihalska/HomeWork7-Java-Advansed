package task4;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "cities")
public class Cities {

    @XmlElement (name = "city")
    private List<City> cit = new ArrayList<>();
    public void add (City city ){
        cit.add(city );
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cit.toArray() ) ;
    }
}
