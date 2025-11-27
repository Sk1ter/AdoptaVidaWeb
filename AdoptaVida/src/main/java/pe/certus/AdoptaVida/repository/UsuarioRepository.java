package pe.certus.AdoptaVida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.certus.AdoptaVida.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    Usuario findByDni(String dni);
}
