package br.pucbr.exemplo.category.controller;

import br.pucbr.exemplo.category.entity.Categoria;
import br.pucbr.exemplo.category.service.CategoriaService;
import br.pucbr.exemplo.util.excecao.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public void salvar(@RequestBody Categoria categoria) throws ExceptionModel {
        categoriaService.salvar(categoria);
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable("id") Integer id) throws ExceptionModel {
        return categoriaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Integer id) {
        categoriaService.excluir(id);
    }
}
