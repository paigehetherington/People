import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class People {
    public static void main(String[] args) throws IOException {

        HashMap<String, ArrayList<Person>> countryPeople = new HashMap<>();
        readFile(countryPeople);
        //countryPeople = readFile();
        sortByNames(countryPeople);
//        for (ArrayList<Person> persons : countryPeople.values()) {
//            Collections.sort(persons);
//        }





        System.out.println(countryPeople);

        saveJson(countryPeople);

        String s = new String(); //string formatting
        for (String country : countryPeople.keySet()){
            for (Person p : countryPeople.get(country)) {
                s += p.formatPerson();
            }
        }
        System.out.println(s);

    }
    public static void sortByNames(HashMap<String, ArrayList<Person>> mapToBeSorted){
        for (ArrayList<Person> persons : mapToBeSorted.values()) {
            Collections.sort(persons);
        }
    }


    public static void saveJson(HashMap<String, ArrayList<Person>> countryPeople) throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(countryPeople);

        File f = new File("People.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();

    }
    public static void readFile(HashMap<String, ArrayList<Person>> countryPeople) throws FileNotFoundException {
    File f = new File("people.csv"); //read file
    Scanner scanner = new Scanner(f);
    scanner.nextLine(); //skip over first line(doesn't contain data
    while (scanner.hasNext()) {
        String line = scanner.nextLine(); // grab a line and read it;
        String[] columns = line.split(","); //split into columns
        Person p = new Person(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);//moved values into an object
        if (!countryPeople.containsKey(p.country)) {
            countryPeople.put(p.country, new ArrayList<>());
        }
        countryPeople.get(p.country).add(p); //pass in person to array list
    }

    }
//public static HashMap<String, ArrayList<Person>> readFile() throws FileNotFoundException {
//    File f = new File("people.csv"); //read file
//    HashMap<String, ArrayList<Person>> countryPeople = new HashMap<>();
//    Scanner scanner = new Scanner(f);
//    scanner.nextLine(); //skip over first line(doesn't contain data
//    while (scanner.hasNext()) {
//        String line = scanner.nextLine(); // grab a line and read it;
//        String[] columns = line.split(","); //split into columns
//        Person p = new Person(Integer.valueOf(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);//moved values into an object
//        if (!countryPeople.containsKey(p.country)) {
//            countryPeople.put(p.country, new ArrayList<>());
//
//        }
//        countryPeople.get(p.country).add(p); //pass in person to array list
//    }
//    return countryPeople;
//
//}


}