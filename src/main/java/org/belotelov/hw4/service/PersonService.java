package org.belotelov.hw4.service;

import lombok.AllArgsConstructor;
import org.belotelov.hw4.model.Person;
import org.belotelov.hw4.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person getOne(int id) { return personRepository.getOne(id); }
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePersonById(int id) { personRepository.deleteById(id); }

    public Person updatePerson(Person person) { return personRepository.update(person); }
}
