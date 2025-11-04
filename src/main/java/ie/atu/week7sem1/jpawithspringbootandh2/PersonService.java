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

}
