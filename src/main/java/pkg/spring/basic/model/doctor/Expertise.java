package pkg.spring.basic.model.doctor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "expertise")
@Data
public class Expertise {
    @Id
    @GeneratedValue
    private int expertiseID;
    private String name;

    //private int docID;
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToMany(mappedBy = "expertises")
    private Set<Doctor> doctors = new HashSet<>();
}
