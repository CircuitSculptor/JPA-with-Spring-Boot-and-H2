package ie.atu.week7sem1.jpawithspringbootandh2;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String employeeId;
    private String position;
    private String department;

    public Person(Long id, String name, String employeeId, String email, String position, String department) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.email = email;
        this.position = position;
        this.department = department;
    }
}

// TODO: Fix Getter & Setters and Constructors to get the DataLoader to work


