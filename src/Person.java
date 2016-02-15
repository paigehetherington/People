import java.util.Comparator;

/**
 * Created by vajrayogini on 2/15/16.
 */
public class Person implements Comparable {
    int id;
    String firstName;
    String lastName;
    String email;
    String country;
    String ipAddress;

    public Person(int id, String firstName, String lastName, String email, String country, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
    public String formatPerson(){
        return String.format("%s, %s from %s \n", lastName, firstName, country);
    }

    @Override //automatically makes use of built in methods
    public int compareTo(Object o) {
        Person p = (Person) o;
        if (lastName.equalsIgnoreCase(p.lastName)) {
            return firstName.compareTo(p.firstName);
        }
        else {
            return lastName.compareTo(p.lastName);
        }


    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getIpAddress() {
        return ipAddress;
    }

}
