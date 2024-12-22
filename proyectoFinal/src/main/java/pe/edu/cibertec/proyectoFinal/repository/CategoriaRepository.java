package pe.edu.cibertec.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.proyectoFinal.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
