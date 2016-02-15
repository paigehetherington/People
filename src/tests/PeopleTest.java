import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by vajrayogini on 2/15/16.
 */
public class PeopleTest {
    @Test
    public void testReadFile() throws FileNotFoundException {
        HashMap<String, ArrayList<Person>> countryPeople = new HashMap<>();
        People.readFile(countryPeople);
        assertTrue(countryPeople.size() > 0);
    }

    @Test
    public void testSortByNames() throws FileNotFoundException {
        HashMap<String, ArrayList<Person>> countryPeople = new HashMap<>();
        People.readFile(countryPeople);
        People.sortByNames(countryPeople);
        assertTrue(countryPeople.get("Paraguay").get(0).firstName.equals("Victor"));

    }
}
