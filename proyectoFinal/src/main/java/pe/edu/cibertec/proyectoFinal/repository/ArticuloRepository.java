package pe.edu.cibertec.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.proyectoFinal.model.Articulos;

public interface ArticuloRepository extends JpaRepository<Articulos,Integer> {
}
