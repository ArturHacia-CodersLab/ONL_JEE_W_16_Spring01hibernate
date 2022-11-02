package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
    private final PersonDao personDao;

    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

    public Person findById(long id) {
        return personDao.findById(id);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void delete(long id) {
        Person person = findById(id);
        personDao.delete(person);
    }
}
