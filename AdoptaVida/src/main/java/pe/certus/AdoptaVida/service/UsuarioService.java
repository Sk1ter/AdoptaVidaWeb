package pe.certus.AdoptaVida.service;

import java.time.LocalDateTime;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.certus.AdoptaVida.model.Usuario;
import pe.certus.AdoptaVida.repository.UsuarioRepository;


@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrar(String nombres, String apellido, String email, String dni, String telefono, String password) {

        if (repo.findByEmail(email) != null) {
            throw new RuntimeException("El correo ya existe");
        }

        Usuario u = new Usuario();
        u.setNombres(nombres);
        u.setApellido(apellido);
        u.setEmail(email);
        u.setDni(dni);
        u.setTelefono(telefono);
        u.setPassword(passwordEncoder.encode(password));
        u.setActivo(true);
        u.setCreadoEn(LocalDateTime.now());

        return repo.save(u);
    }

    public Usuario obtenerPorEmail(String email) {
        return repo.findByEmail(email);
    }
}
