package pe.certus.AdoptaVida.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.certus.AdoptaVida.service.UsuarioService;


@Controller
public class AuthController {

    private final UsuarioService servicio;

    public AuthController(UsuarioService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/register")
    public String registrar(
            @RequestParam String nombres,
            @RequestParam String apellido,
            @RequestParam String email,
            @RequestParam String dni,
            @RequestParam String telefono,
            @RequestParam String password
    ) {
        servicio.registrar(nombres, apellido, email, dni, telefono, password);

        return "redirect:/login?registrado";
    }
}
