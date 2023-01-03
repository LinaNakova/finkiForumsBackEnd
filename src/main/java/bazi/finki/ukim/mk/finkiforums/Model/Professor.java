package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "profesori", schema = "project")
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    Long id;
    @Column(name = "p_ime")
    String name;
    @Column(name = "p_prezime")
    String lastName;
    @Column(name = "p_korisnicko_ime")
    String username;
    @Column(name = "p_email")
    String email;
    @Column(name = "p_lozinka")
    String password;

    public Professor() {
    }
}
