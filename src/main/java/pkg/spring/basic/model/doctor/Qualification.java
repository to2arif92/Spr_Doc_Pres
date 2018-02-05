package pkg.spring.basic.model.doctor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "qualification")
@Data
public class Qualification {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private int qualID;
    private String name;

    //private int docID;
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToMany(mappedBy = "qualifications")
    private Set<Doctor> doctors = new HashSet<>();
}
