package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "e_prof_na", schema = "project")
@Entity
public class ProfessorTeachingCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pn_id")
    Long id;
    @JoinColumn(name="p_id")
    @ManyToOne
    Professor professor;
    @JoinColumn(name="ku_id")
    @ManyToOne
    Course course;

    public ProfessorTeachingCourse() {
    }
}
