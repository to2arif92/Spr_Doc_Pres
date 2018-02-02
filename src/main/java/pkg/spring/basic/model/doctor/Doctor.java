package pkg.spring.basic.model.doctor;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue
    private long doctID;
    private String fname;
    private String lName;
    private String email;

    //int qualID;
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "doctor_qualification",
            joinColumns = @JoinColumn(name = "docID"),
            inverseJoinColumns = @JoinColumn(name = "qualID")
    )
    private Set<Qualification> qualifications = new HashSet<>();

    //int expertiseID;
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "doctor_expertise",
            joinColumns = @JoinColumn(name = "docID"),
            inverseJoinColumns = @JoinColumn(name = "expertiseID")
    )
    private Set<Expertise> expertises = new HashSet<>();
}
