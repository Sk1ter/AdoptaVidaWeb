package pe.certus.AdoptaVida.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.certus.AdoptaVida.model.Event;
import pe.certus.AdoptaVida.repository.EventRepository;
import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository repo;

    public EventServiceImpl(EventRepository repo) {
        this.repo = repo;
    }

    @Override
    public Event save(Event event) {
        if (event.getCreadoEn() == null) {
            event.setCreadoEn(java.time.LocalDateTime.now());
        }
        return repo.save(event);
    }

    @Override
    public List<Event> findAll() {
        return repo.findAll();
    }
}
