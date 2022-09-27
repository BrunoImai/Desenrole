package br.pucbr.exemplo.evento.service;

import br.pucbr.exemplo.evento.entity.Evento;
import br.pucbr.exemplo.evento.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public void salvar(Evento evento) {
        eventoRepository.save(evento);
    }

    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    public Evento buscarPorId(Integer id) {
        return eventoRepository.findById(id).get();
    }

    public void excluir(Integer id) {
        eventoRepository.deleteById(id);
    }

}
