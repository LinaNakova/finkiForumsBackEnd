package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="dava_reakcija", schema = "project")
@Entity
public class ProfessorReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dr_id")
    Long id;
    @JoinColumn(name="p_id")
    @ManyToOne
    Professor professor;
    @JoinColumn(name="o_id")
    @ManyToOne
    Answer answer;
    @Column(name = "reakcija")
    Boolean reaction;

    public ProfessorReaction() {
    }

    public ProfessorReaction(Professor professor, Answer answer, Boolean reaction) {
        this.professor = professor;
        this.answer = answer;
        this.reaction = reaction;
    }
}
