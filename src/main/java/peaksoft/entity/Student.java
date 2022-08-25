package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="students")
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(generator = "student_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="student_gen",sequenceName = "student_seq",allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="phone_number")
    private String phoneNumber;

    private String email;
    Enum ONLINE,
    OFFLINE;

    public Student(String firstName, String lastName, String phoneNumber, String email, Enum ONLINE, Enum OFFLINE) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ONLINE = ONLINE;
        this.OFFLINE = OFFLINE;
    }

    @ManyToOne
    private Course course;
}
