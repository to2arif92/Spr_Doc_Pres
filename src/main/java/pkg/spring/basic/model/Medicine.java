package pkg.spring.basic.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicine")
@Data
public class Medicine {
    @Id
    @GeneratedValue
    private int medicineID;
    private String name;

    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    @ManyToMany(mappedBy = "medicines")
    private Set<Prescription> prescriptions = new HashSet<>();

    //private int manufacturerID;
}
