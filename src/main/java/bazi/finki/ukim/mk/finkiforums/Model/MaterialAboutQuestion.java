package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "project", name = "e_vo_vrska_so")
public class MaterialAboutQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vs_id")
    Long id;
    @JoinColumn(name="m_id")
    @OneToOne
    Material material;
    @JoinColumn(name="pra_id")
    @ManyToOne
    Question question;

    public MaterialAboutQuestion() {
    }
}
