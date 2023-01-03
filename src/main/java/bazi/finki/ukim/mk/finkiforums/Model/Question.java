package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table(name = "prasanja", schema = "project")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pra_id")
    Long id;
    @Column(name = "pra_naslov")
    String title;
    @Column(name = "pra_sodrzina")
    String content;
    @Column(name = "pra_datum")
    Timestamp dateAsked;
    @JoinColumn(name="s_id")
    @ManyToOne
    Student student;
    @JoinColumn(name="ku_id")
    @ManyToOne
    Course course;

    public Question() {
    }
}
