package pkg.spring.basic.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pkg.spring.basic.model.doctor.Doctor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prescription")
@Data
public class Prescription {
    @Id
    @GeneratedValue
    private long prescriptionID;

    private Date thisVisit;
    private Date nextVisit;

    //int patientID;
    @ManyToOne
    @JoinColumn(name = "patientID")
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    private Patient patient;

    //int docID;
    @ManyToOne
    @JoinColumn(name = "docID")
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) // exclude this field from Lombok
    private Doctor doctor;

    //int medicineID;
    @ManyToMany
    @JoinTable(
            name = "prescription_medicine",
            joinColumns = @JoinColumn(name = "prescriptionID"),
            inverseJoinColumns = @JoinColumn(name = "medicineID")
    )
    private Set<Medicine> medicines = new HashSet<>();

}
