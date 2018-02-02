package pkg.spring.basic.model.doctor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "qualification")
@Data
public class Qualification {
    @Id
    @GeneratedValue
    private int qualID;
    private String name;

    //private int docID;
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToMany(mappedBy = "qualifications")
    private Set<Doctor> doctors = new HashSet<>();
}
