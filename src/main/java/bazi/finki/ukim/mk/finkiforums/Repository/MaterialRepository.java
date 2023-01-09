package bazi.finki.ukim.mk.finkiforums.Repository;

import bazi.finki.ukim.mk.finkiforums.Model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}
