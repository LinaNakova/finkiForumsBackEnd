package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table(name = "prof_term_za_kons", schema = "project")
@Entity
public class ProfessorConsults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ptk_id")
    Long id;
    @JoinColumn(name="p_id")
    @ManyToOne
    Professor professor;
    @Column(name = "termin")
    Timestamp consultTime;

}
