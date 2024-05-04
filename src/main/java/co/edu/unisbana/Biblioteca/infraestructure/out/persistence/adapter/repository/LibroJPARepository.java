package co.edu.unisbana.Biblioteca.infraestructure.out.persistence.adapter.repository;


import co.edu.unisbana.Biblioteca.infraestructure.out.persistence.orm.LibroORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroJPARepository extends JpaRepository<LibroORM, String> {
}
