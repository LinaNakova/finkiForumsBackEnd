package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String Username);
}
