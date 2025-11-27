package pe.certus.AdoptaVida.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.certus.AdoptaVida.model.Event;
import pe.certus.AdoptaVida.service.EventService;
import java.util.List;

@Controller
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping("/events")
    public String eventsPage(Model model) {
        List<Event> events = service.findAll();
        model.addAttribute("events", events);
        model.addAttribute("newEvent", new Event());
        return "events";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {
        List<Event> events = service.findAll();
        model.addAttribute("events", events);
        model.addAttribute("newEvent", new Event());
        return "dashboard";
    }

    @PostMapping("/events/register")
    @ResponseBody
    public ResponseEntity<?> registerEvent(@RequestBody Event newEvent) {
        try {
            service.save(newEvent);
            return ResponseEntity.ok("Evento registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar: " + e.getMessage());
        }
    }
}

	


