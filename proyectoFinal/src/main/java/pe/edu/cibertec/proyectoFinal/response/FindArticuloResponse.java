package pe.edu.cibertec.proyectoFinal.response;

import pe.edu.cibertec.proyectoFinal.dto.ArticuloDetailDto;

public record FindArticuloResponse(String code,
                                   String error,
                                   ArticuloDetailDto car) {
}
