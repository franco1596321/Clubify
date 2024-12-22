package pe.edu.cibertec.proyectoFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectoFinal.dto.ArticuloDetailDto;
import pe.edu.cibertec.proyectoFinal.dto.ArticuloDto;
import pe.edu.cibertec.proyectoFinal.model.Articulos;
import pe.edu.cibertec.proyectoFinal.model.Categoria;
import pe.edu.cibertec.proyectoFinal.model.Proveedor;
import pe.edu.cibertec.proyectoFinal.repository.ArticuloRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements pe.edu.cibertec.proyectoFinal.service.ManageService{

    @Autowired
    ArticuloRepository articuloRepository;

    ///recupera todo lo almacenado en la base de datos
    @Override
    public List<ArticuloDto> getAllArticulos() throws Exception {
        List<ArticuloDto> articulos = new ArrayList<>();
        Iterable<Articulos> iterable = articuloRepository.findAll();
        iterable.forEach(articulo -> {
            articulos.add(new ArticuloDto(
                    articulo.getIdArticulo(),
                    articulo.getNomArt(),
                    articulo.getDescrpArt(),
                    articulo.getMarca(),
                    articulo.getModelo(),
                    articulo.getColor(),
                    articulo.getPrecio(),
                    articulo.getCategoria(),
                    articulo.getProveedor()));
        });

        return articulos;
    }


//    busca un articulo por ID
    @Override
    public Optional<ArticuloDetailDto> getArticuloById(int id)  {
        Optional<Articulos> optional = articuloRepository.findById(id);
        return optional.map(articulo -> new ArticuloDetailDto(articulo.getIdArticulo(),
                articulo.getNomArt(),
                articulo.getDescrpArt(),
                articulo.getMarca(),
                articulo.getModelo(),
                articulo.getColor(),
                articulo.getPrecio(),
                articulo.getCategoria(),
                articulo.getProveedor()));
    }

    //actualiza utilizando los campos de ArticuloDTO
    @Override
    public boolean updateArticulo(ArticuloDto articuloDto) throws Exception {
        Optional<Articulos> optional = articuloRepository.findById(articuloDto.id());
        return optional.map(articulo -> {
            articulo.setNomArt(articuloDto.nomArt());
            articulo.setMarca(articuloDto.marca());
            articulo.setModelo(articuloDto.modelo());
            articulo.setColor(articuloDto.color());
            articulo.setPrecio(articuloDto.precio());
            articulo.setCategoria(articuloDto.idCatgr());
            articulo.setProveedor(articuloDto.idProv());
            articuloRepository.save(articulo);
            return true;
        }).orElse(false);
    }


    //guarda o actualiza por su id
    @Override
    public void saveArticulo(ArticuloDetailDto articuloDetailDto) {
        Optional<Articulos> optionalArticulos = articuloRepository.findById(articuloDetailDto.id());

        if (optionalArticulos.isPresent()) {
            Articulos articulo = optionalArticulos.get();


            articulo.setNomArt(articuloDetailDto.nomArt());
            articulo.setDescrpArt(articuloDetailDto.descrpArt());
            articulo.setMarca(articuloDetailDto.marca());
            articulo.setModelo(articuloDetailDto.modelo());
            articulo.setColor(articuloDetailDto.color());
            articulo.setPrecio(articuloDetailDto.precio());
            articulo.setCategoria(articuloDetailDto.idCatgr());
            articulo.setProveedor(articuloDetailDto.idProv());


            articuloRepository.save(articulo);
        }
    }

//elimina por id
    @Override
    public boolean deleteArticuloById(int id) throws Exception {
        Optional<Articulos> optional = articuloRepository.findById(id);
        return optional.map(articulo -> {
            articuloRepository.delete(articulo);
            return true;
        }).orElse(false);
    }

    //agrega un nuevo registro(articulo)
    @Override
    public boolean addArticulo(ArticuloDetailDto articuloDetailDto) throws Exception {
        Optional<Articulos> optional = articuloRepository.findById(articuloDetailDto.id()); // Corregido
        if (optional.isEmpty()) {
            Articulos articulo = new Articulos();
            articulo.setNomArt(articuloDetailDto.nomArt());
            articulo.setMarca(articuloDetailDto.marca());
            articulo.setDescrpArt(articuloDetailDto.descrpArt());//sorrigente
            articulo.setModelo(articuloDetailDto.modelo());
            articulo.setColor(articuloDetailDto.color());
            articulo.setPrecio(articuloDetailDto.precio());
            articulo.setCategoria(articuloDetailDto.idCatgr());
            articulo.setProveedor(articuloDetailDto.idProv());
            articuloRepository.save(articulo);
            return true;
        }
        return false;

    }
}