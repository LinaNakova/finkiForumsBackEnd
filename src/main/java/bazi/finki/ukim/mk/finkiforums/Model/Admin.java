package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "project", name = "administratori")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    Long id;
    @Column(name = "a_ime")
    String name;
    @Column(name = "a_prezime")
    String lastName;
    @Column(name = "a_korisnicko_ime")
    String username;
    @Column(name = "a_email")
    String email;
    @Column(name = "a_lozinka")
    String password;

    public Admin() {
    }

}
