package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "kategorii", schema = "project")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ka_id")
    Long id;
    @Column(name = "ka_ime")
    String name;
    @Column(name = "ka_opis")
    String description;
    @JoinColumn(name = "a_id")
    @ManyToOne
    Admin aId;

    public Category() {
    }
}
