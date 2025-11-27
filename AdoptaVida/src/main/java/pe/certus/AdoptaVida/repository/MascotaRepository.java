package pe.certus.AdoptaVida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.certus.AdoptaVida.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}