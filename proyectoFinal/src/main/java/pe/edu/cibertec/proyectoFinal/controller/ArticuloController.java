package pe.edu.cibertec.proyectoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoFinal.dto.ArticuloDetailDto;
import pe.edu.cibertec.proyectoFinal.dto.ArticuloDto;
import pe.edu.cibertec.proyectoFinal.dto.ArticuloInsertDto;
import pe.edu.cibertec.proyectoFinal.model.Articulos;
import pe.edu.cibertec.proyectoFinal.service.ManageService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/manage")
public class ArticuloController {

    @Autowired
    private ManageService manageService;


    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<ArticuloDto> articulos = manageService.getAllArticulos();
            model.addAttribute("articulos", articulos);
            model.addAttribute("error",null);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error","No se obtuvieron los articulos debido a un error");
        }

        return "manage";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<ArticuloDetailDto> articulos = manageService.getArticuloById(id);
        model.addAttribute("articulos", articulos);
        return "manage-edit";
    }

    @GetMapping("/insert")
    public String insertArticuloForm(Model model) {
        ArticuloInsertDto articuloInsertDto = new ArticuloInsertDto(
                null,
                "",
                "",
                "",
                "",
                "",
                0.0,
                null,
                null
        );
        model.addAttribute("articuloInsertDto", articuloInsertDto);
        return "manage-insert";
    }

    @PostMapping("/save")
    public String saveArticulo(ArticuloDetailDto articuloDetailDto) {
        manageService.saveArticulo(articuloDetailDto);
        return "redirect:/manage/start";
    }

    @PostMapping("/delete/{id}")
    public String deleteArticulo(@PathVariable int id) throws Exception {
        manageService.deleteArticuloById(id);
        return "redirect:/manage/start";
    }
}