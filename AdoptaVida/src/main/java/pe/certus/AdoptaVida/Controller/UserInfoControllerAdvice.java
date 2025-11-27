package pe.certus.AdoptaVida.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.certus.AdoptaVida.model.Usuario;
import pe.certus.AdoptaVida.repository.UsuarioRepository;


@ControllerAdvice
public class UserInfoControllerAdvice {

    private final UsuarioRepository repo;

    public UserInfoControllerAdvice(UsuarioRepository repo) {
        this.repo = repo;
    }

    @ModelAttribute("usuarioLogueado")
    public Usuario usuarioLogueado() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() ||
                auth.getPrincipal().toString().equals("anonymousUser")) {
            return null;
        }

        String email = auth.getName();
        return repo.findByEmail(email);
    }
}