package co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter;

import co.edu.unisbana.Biblioteca.domain.entity.Libro;
import co.edu.unisbana.Biblioteca.domain.repository.PrestamoPort;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter.repository.LibroJPARepository;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter.repository.PrestamoJPARepository;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm.LibroORM;
import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm.PrestamoORM;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrestamoAdapterRepository implements PrestamoPort {
    private PrestamoJPARepository prestamoJPARepository;
    private LibroJPARepository libroJPARepository;

    public PrestamoAdapterRepository(PrestamoJPARepository prestamoJPARepository, LibroJPARepository libroJPARepository) {
        this.prestamoJPARepository = prestamoJPARepository;
        this.libroJPARepository = libroJPARepository;
    }

    @Override
    public UUID guardarPrestamo(Libro libro) {
        Optional<LibroORM> libroORMOptional = libroJPARepository.findById(libro.getIsbn());
        if (libroORMOptional.isPresent()) {
            LibroORM libroORM = libroORMOptional.get();
            PrestamoORM prestamo = new PrestamoORM();
            prestamo.setUuid(UUID.randomUUID());
            prestamo.setLibro(libroORM);
            prestamo.setFechaPrestamo(LocalDate.now());
            prestamo.setFechaDevolucion(null);
            prestamoJPARepository.save(prestamo);
        }
        return UUID.randomUUID();
    }
}
