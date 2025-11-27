package pe.certus.AdoptaVida.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.certus.AdoptaVida.model.Mascota;
import pe.certus.AdoptaVida.service.MascotaService;
import java.util.List;

@Controller
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping("/dashboardAnimals")
    public String dashboardAnimals(Model model) {
        List<Mascota> mascotas = mascotaService.getAll();
        model.addAttribute("mascotas", mascotas);
        model.addAttribute("newMascota", new Mascota());
        return "dashboardAnimals";
    }

    @GetMapping("/animalAdopts")
    public String animalAdopts(Model model) {
        List<Mascota> mascotas = mascotaService.getAll();
        model.addAttribute("mascotas", mascotas);
        return "animalAdopts";
    }

    @PostMapping("/dashboardAnimals/register")
    @ResponseBody
    public String registerMascota(@RequestBody Mascota mascota) {
        mascotaService.save(mascota);
        return "Mascota creada correctamente";
    }
    
    @GetMapping("/mascota/{id}")
    public String verMascota(@PathVariable Integer id, Model model) {
        Mascota mascota = mascotaService.obtenerPorId(id);
        model.addAttribute("mascota", mascota);
        return "mascota";
    }
}
