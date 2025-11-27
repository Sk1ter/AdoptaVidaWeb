package pe.certus.AdoptaVida.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.certus.AdoptaVida.model.Notification;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalNotificationController {

    @ModelAttribute
    public void addNotifications(Model model) {
        List<Notification> notificaciones = Arrays.asList(
            new Notification("fa-dog", "bg-success", "Nueva adopción", "Has adoptado a Luna.", "Hace 10 min", false),
            new Notification("fa-heart", "bg-danger", "Campaña solidaria", "Únete a la campaña ‘Abriga un amigo’.", "Hace 1 hora", false),
            new Notification("fa-bone", "bg-warning", "Nuevo evento", "Ven al evento de adopción este sábado.", "Hace 2 horas", false)
        );

        model.addAttribute("notificaciones", notificaciones);
    }
}