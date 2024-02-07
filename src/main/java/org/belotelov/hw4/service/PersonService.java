package org.belotelov.hw4.service;

import org.belotelov.hw4.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private static int PEOPLE_COUNT;
    private List<Person> persons = new ArrayList<>();

    {
        persons = new ArrayList<>();
        persons.add(new Person(++PEOPLE_COUNT, "Katty", "+79998887766","kate@mail.com", "Next door girl"));
        persons.add(new Person(++PEOPLE_COUNT, "John", "+79001112233","long_johnt@mail.com", "Work"));
        persons.add(new Person(++PEOPLE_COUNT, "Tom", "+79115554463","tommygun@mail.com", "Running together"));
        persons.add(new Person(++PEOPLE_COUNT, "Alice", "+79223334567","alison@mail.com", ""));
    }

    public void addPerson(Person person) {
        person.setId(++PEOPLE_COUNT);
        persons.add(person);
    }

    public List<Person> findAllPersons() {
        return persons;
    }
}
