package co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter.repository;

import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm.PrestamoORM;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PrestamoJPARepository extends JpaRepository<PrestamoORM, UUID> {
}
