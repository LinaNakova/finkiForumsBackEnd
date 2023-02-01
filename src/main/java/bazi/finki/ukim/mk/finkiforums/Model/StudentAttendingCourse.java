package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="moze_da_slusa", schema = "project")
@Entity
public class StudentAttendingCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mds_id")
    Long id;
    @JoinColumn(name="s_id")
    @ManyToOne
    Student student;
    @JoinColumn(name="ku_id")
    @ManyToOne
    Course course;

    public StudentAttendingCourse() {
    }

    public StudentAttendingCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
