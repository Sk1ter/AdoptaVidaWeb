package pe.certus.AdoptaVida.service;

import org.springframework.stereotype.Service;
import pe.certus.AdoptaVida.model.Mascota;
import pe.certus.AdoptaVida.repository.MascotaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository repository;

    public MascotaService(MascotaRepository repository) {
        this.repository = repository;
    }

    public List<Mascota> getAll() {
        return repository.findAll();
    }

    public Optional<Mascota> getById(Integer id) {
        return repository.findById(id);
    }

    public Mascota save(Mascota mascota) {
        return repository.save(mascota);
    }
    
    public Mascota obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con id: " + id));
    }
}
