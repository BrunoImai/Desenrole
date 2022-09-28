package br.pucbr.exemplo.evento.controller;

import br.pucbr.exemplo.evento.entity.Evento;
import br.pucbr.exemplo.evento.service.EventoService;
import br.pucbr.exemplo.util.excecao.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @PostMapping
    public void salvar(@RequestBody Evento evento) throws ExceptionModel {
        eventoService.salvar(evento);
    }

    @GetMapping
    public List<Evento> listar() {
        return eventoService.listar();
    }

    @GetMapping("/{id}")
    public Evento buscarPorId(@PathVariable("id") Integer id) throws ExceptionModel {
        return eventoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Integer id) throws ExceptionModel {
        eventoService.excluir(id);
    }
}
