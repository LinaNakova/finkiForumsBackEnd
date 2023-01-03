package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "reagira_na", schema = "project")
@Entity
public class StudentReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rn_id")
    Long id;
    @JoinColumn(name="s_id")
    @ManyToOne
    Student student;
    @JoinColumn(name="o_id")
    @ManyToOne
    Answer answer;
    @Column(name = "reakcija")
    Boolean reaction;

    public StudentReaction() {
    }
}
