package pkg.spring.basic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long patientID;
    private String fname;
    private String lName;
    private String address;
    private Date DOB;
}
