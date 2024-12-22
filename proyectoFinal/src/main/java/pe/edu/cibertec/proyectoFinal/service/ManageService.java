package pe.edu.cibertec.proyectoFinal.service;

import pe.edu.cibertec.proyectoFinal.dto.ArticuloDetailDto;
import pe.edu.cibertec.proyectoFinal.dto.ArticuloDto;
import pe.edu.cibertec.proyectoFinal.dto.ArticuloInsertDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<ArticuloDto> getAllArticulos() throws Exception; //listsa todos los articulos

    Optional<ArticuloDetailDto> getArticuloById(int id) ; //busca por Id (articulo)

    void saveArticulo(ArticuloDetailDto articuloDetailDto); //guarda articulo(param-->objArticuloDetailDto)

    boolean updateArticulo(ArticuloDto carDto) throws Exception;//actualiza

    boolean deleteArticuloById(int id) throws Exception;//elimina por id

    boolean addArticulo(ArticuloDetailDto articuloDetailDto) throws Exception; // añade nuevo articulo


}