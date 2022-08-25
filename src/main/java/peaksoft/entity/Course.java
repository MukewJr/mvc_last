package peaksoft.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "course_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;
    @Column(name="duration_month")
    private String durationMonth;
    private String image;
    private String description;

    public Course(String courseName, LocalDate dateOfStart, String durationMonth, String image, String description, Company company) {
        this.courseName = courseName;
        this.dateOfStart = dateOfStart;
        this.durationMonth = durationMonth;
        this.image = image;
        this.description = description;
        this.company = company;
    }

    @ManyToOne
    private Company company;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "course")
    private List<Lesson> lessons;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "course")
    private List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
    private List<Instructor> instructors;
}
