package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "project", name = "materijali")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    Long id;
    @Column(name = "m_ime")
    String name;
    @Column(name = "m_bytes")
    String bytes;
    @JoinColumn(name = "p_id")
    @ManyToOne
    Professor pId;
    @JoinColumn(name = "ka_id")
    @ManyToOne
    Category caId;
    @JoinColumn(name = "ku_id")
    @ManyToOne
    Course coId;

    public Material() {
    }
}
