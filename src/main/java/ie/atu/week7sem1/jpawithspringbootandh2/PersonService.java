package ie.atu.week7sem1.jpawithspringbootandh2;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person create(Person p) {
        return repo.save(p);
    }

    public List<Person> findAll() {
        return repo.findAll();
    }

    public Person findByEmployeeId(String id) {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " not found"));
                //.orElseThrow(() -> new IllegalArgumentException("Employee not found"));
    }

    public Person update(String id, Person updatePerson) {
        return repo.findByEmployeeId(id)
                .map(existingPerson -> {
                    existingPerson.setName(updatePerson.getName());
                    existingPerson.setEmail(updatePerson.getEmail());
                    existingPerson.setEmployeeId(updatePerson.getEmployeeId());
                    existingPerson.setPosition(updatePerson.getPosition());
                    existingPerson.setDepartment(updatePerson.getDepartment());
                    return repo.save(existingPerson);
                })
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " not found"));
    }

    public void deleteByEmployeeId(String id) {
        if (repo.findByEmployeeId(id).isPresent()) {
            repo.delete(repo.findByEmployeeId(id).get());
        } else {
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
    }

}
