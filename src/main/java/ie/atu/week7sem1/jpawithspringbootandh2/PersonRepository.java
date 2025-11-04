package ie.atu.week7sem1.jpawithspringbootandh2;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmployeeId(String employeeId);
}

