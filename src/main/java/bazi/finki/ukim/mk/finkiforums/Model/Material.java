package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;

@Entity
@Table(schema = "project", name = "materijali")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    Long id;
    @Column(name = "m_ime")
    String name;
    @JoinColumn(name = "p_id")
    @ManyToOne
    Professor professor;
    @JoinColumn(name = "ka_id")
    @ManyToOne
    Category category;
    @JoinColumn(name = "ku_id")
    @ManyToOne
    Course course;

    public Material() {
    }

    public Material(String name, Professor professor, Course course) {
        this.name = name;
        this.professor = professor;
        this.course = course;
    }

    public String getName() {
        return name;
    }
}
