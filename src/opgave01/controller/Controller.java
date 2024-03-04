package opgave01.controller;

import opgave01.models.Person;
import opgave01.models.Role;
import opgave01.storage.EaaaFileStorage;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    EaaaFileStorage eaaaStorage;

    public Controller() {
        this.eaaaStorage = new EaaaFileStorage();
    }

    /**
     * @param role
     * @return List<Person> where all person has the given role
     */
    public List<Person> filter(Role role) {

        return null;
    }

    /**
     * @return all persons
     */
    public static List<Person> getPeople() {
        ArrayList<Person> people = new ArrayList<>();
        return people;
    }

    /**
     * Adds a new person
     *
     * @param person
     */
    public void addPerson(Person person) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(person);
    }

    public Person createPerson(String name, Role role) {
        Person person = new Person(name, role);
        if(!eaaaStorage.getPeople().contains(person)) {
        eaaaStorage.addPerson(person);
        }
        return person;
    }
    public static List<Person> getPersons() {
        return EaaaFileStorage.getPersons();
    }

    /**
     * Persists all people
     */
    public void save() {
    }

}
