package br.pucbr.exemplo.evento.service;

import br.pucbr.exemplo.evento.entity.Evento;
import br.pucbr.exemplo.evento.repository.EventoRepository;
import br.pucbr.exemplo.usuario.entity.Usuario;
import br.pucbr.exemplo.util.excecao.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public void salvar(Evento evento) throws ExceptionModel {
        if (evento.getNome() == null || evento.getNome().equals("")) {
            throw new ExceptionModel("ERR001","Campo NOME não pode ser nulo");
        } else if (evento.getCriador() == null || evento.getCriador().equals("")) {
            throw new ExceptionModel("ERR001","Campo CRIADOR não pode ser nulo");
        }
        else if (evento.getEndereco() == null || evento.getEndereco().equals("")) {
            throw new ExceptionModel("ERR001","Campo ENDERECO não pode ser nulo");
        }
        else if (evento.getNome().length() > 50) {
            throw new ExceptionModel("ERR002","Campo NOME não pode ter mais que 50 caracteres");
        }
        else if (evento.getCriador().length() > 50) {
            throw new ExceptionModel("ERR002","Campo CRIADOR não pode ter mais que 50 caracteres");
        }
        eventoRepository.save(evento);

    }

    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    public Evento buscarPorId(Integer id) throws ExceptionModel {
        try {
            Evento event = eventoRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ExceptionModel("ERR003","O evento não existe");
        }
        return eventoRepository.findById(id).get();
    }

    public void excluir(Integer id) throws ExceptionModel {
        try {
            Evento event = eventoRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ExceptionModel("ERR003","O evento não existe");
        }
        eventoRepository.deleteById(id);
    }

}
