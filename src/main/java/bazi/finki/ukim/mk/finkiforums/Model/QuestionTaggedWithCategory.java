package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "e_oznaceno_so", schema = "project")
@Entity
public class QuestionTaggedWithCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "os_id")
    Long id;
    @JoinColumn(name="pra_id")
    @ManyToOne
    Question question;
    @JoinColumn(name="ka_id")
    @ManyToOne
    Category category;

    public QuestionTaggedWithCategory() {
    }
}
