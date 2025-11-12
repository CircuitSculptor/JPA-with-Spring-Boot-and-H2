package ie.atu.week7sem1.jpawithspringbootandh2;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person) {
        return service.create(person);
    }

    @GetMapping("/{employeeId}")
    public Person byEmployeeId(@PathVariable String id) {   // Error messages about remaining can be ignored, does not affect code functionality
        return service.findByEmployeeId(id);
    }

    @GetMapping
    public List<Person> all() {
        return service.findAll();
    }

    @PutMapping("/{employeeId}")
    public Person update(@PathVariable String id, @Valid @RequestBody Person updatePerson) {
        return service.update(id, updatePerson);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteByEmployeeId(id);
    }
}
