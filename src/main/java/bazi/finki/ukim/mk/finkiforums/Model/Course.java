package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "kursevi", schema = "project")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ku_id")
    Long id;
    @Column(name = "ku_ime")
    String name;
    @Column(name = "ku_opis")
    String description;
    @JoinColumn(name = "pr_id")
    @ManyToOne
    Subject prId;

    public Course() {
    }
}
