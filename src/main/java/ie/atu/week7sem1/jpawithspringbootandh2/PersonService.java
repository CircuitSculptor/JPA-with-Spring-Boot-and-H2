package ie.atu.week7sem1.jpawithspringbootandh2;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person create(Person p) {
        return repo.save(p);
    }

    public Person findByEmployeeId(String id) {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " not found"));
    }

}
