package pe.edu.cibertec.proyectoFinal.response;

import pe.edu.cibertec.proyectoFinal.dto.ArticuloDto;

public record FindArticulosResponse(String code, String error,
                                    Iterable<ArticuloDto> cars){
}
