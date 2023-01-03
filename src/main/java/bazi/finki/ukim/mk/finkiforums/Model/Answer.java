package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table(name = "odgovori", schema = "project")
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    Long id;
    @Column(name = "o_sodrzina")
    String content;
    @Column(name = "o_validen")
    Boolean valid;
    @Column(name = "o_datum")
    Timestamp dateAnswered;
    @JoinColumn(name="pra_id")
    @ManyToOne
    Question question;
    @JoinColumn(name="s_id")
    @ManyToOne
    Student student;
    @JoinColumn(name="p_id")
    @ManyToOne
    Professor professor;

    public Answer() {
    }
}
