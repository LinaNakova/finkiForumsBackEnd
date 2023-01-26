package bazi.finki.ukim.mk.finkiforums.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="studenti", schema = "project")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    Long id;
    @Column(name = "s_ime")
    String name;
    @Column(name = "s_prezime")
    String lastName;
    @Column(name = "s_korisnicko_ime")
    String username;
    @Column(name = "s_email")
    String email;
    @Column(name = "s_lozinka")
    String password;
    @Column(name = "s_index")
    String index;

    public Student() {
    }

    public Student(String name, String lastName, String username, String email, String password, String index) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.index = index;
    }
}
