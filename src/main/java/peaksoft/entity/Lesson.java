package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue(generator = "lesson_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lesson_gen",sequenceName =
            "lesson_seq",allocationSize = 1)
    private Long id;
    @Column(name = "lesson_name")
    private String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }

    @ManyToOne
    private Course course;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "lesson")
    private List<Task>tasks;

    @OneToOne
    private Video video;
}
