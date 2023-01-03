package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "predmeti", schema = "project")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id")
    Long id;
    @Column(name = "pr_ime")
    String name;
    @JoinColumn(name = "a_id")
    @ManyToOne
    Admin aId;

    public Subject() {
    }
}
