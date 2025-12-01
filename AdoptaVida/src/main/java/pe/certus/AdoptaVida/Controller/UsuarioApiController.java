package pe.certus.AdoptaVida.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.certus.AdoptaVida.Security.JwtUtil;
import pe.certus.AdoptaVida.dto.LoginRequest;
import pe.certus.AdoptaVida.dto.UsuarioRegisterRequest;
import pe.certus.AdoptaVida.model.Usuario;
import pe.certus.AdoptaVida.service.UsuarioService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class UsuarioApiController {

    private final UsuarioService service;
    private final JwtUtil jwtUtil;

    public UsuarioApiController(UsuarioService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioRegisterRequest req) {

        Usuario u = service.registrar(
                req.nombres,
                req.apellido,
                req.email,
                req.dni,
                req.telefono,
                req.password
        );

        return ResponseEntity.ok(u);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        Usuario usuario = service.obtenerPorEmail(req.email);

        if (usuario == null)
            return ResponseEntity.status(401).body("Usuario no encontrado");

        if (!service.checkPassword(req.password, usuario.getPassword()))
            return ResponseEntity.status(401).body("Contraseña incorrecta");

        String token = jwtUtil.generateToken(usuario.getEmail());

        return ResponseEntity.ok(
                Map.of(
                        "token", token,
                        "email", usuario.getEmail(),
                        "nombre", usuario.getNombres()
                )
        );
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@RequestHeader("Authorization") String authHeader) {

        String token = authHeader.replace("Bearer ", "");
        String email = jwtUtil.extractUsername(token);

        Usuario u = service.obtenerPorEmail(email);

        return ResponseEntity.ok(u);
    }
}
