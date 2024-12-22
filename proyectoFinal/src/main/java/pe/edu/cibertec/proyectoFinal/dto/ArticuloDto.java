package pe.edu.cibertec.proyectoFinal.dto;

import pe.edu.cibertec.proyectoFinal.model.Categoria;
import pe.edu.cibertec.proyectoFinal.model.Proveedor;

public record ArticuloDto(Integer id,
                          String nomArt,
                          String descrpArt,
                          String marca,
                          String modelo,
                          String color,
                          Double precio,
                          Categoria idCatgr,
                          Proveedor idProv) {
}
