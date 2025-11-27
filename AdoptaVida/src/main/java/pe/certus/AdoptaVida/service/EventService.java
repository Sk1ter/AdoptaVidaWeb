package pe.certus.AdoptaVida.service;

import java.util.List;
import pe.certus.AdoptaVida.model.Event;

public interface EventService {
    Event save(Event event);
    List<Event> findAll();
}