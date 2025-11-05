package ie.atu.week7sem1.jpawithspringbootandh2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person testData = new Person("1","Bartek", "bartek@atu.ie", "1234", "Student", "Electronic Engineering");
        personRepository.save(testData);
    }
}
