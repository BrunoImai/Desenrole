package br.pucbr.exemplo.usuario.service;

import br.pucbr.exemplo.usuario.entity.Usuario;
import br.pucbr.exemplo.usuario.repository.UsuarioRepository;
import br.pucbr.exemplo.util.excecao.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) throws ExceptionModel {
        if (usuario.getNome() == null || usuario.getNome().equals("")) {
            //lanco um erro
            throw new ExceptionModel("ERR001","Campo NOME não pode ser nulo");
        } else if (usuario.getNome().length() > 50) {
            throw new ExceptionModel("ERR002","Campo NOME não pode ter mais que 50 caracteres");
        } else if (usuario.getLogin().length() > 50) {
            throw new ExceptionModel("ERR002","Campo LOGIN não pode ter mais que 50 caracteres");
        }else if (usuario.getLogin() == null || usuario.getLogin().equals("")) {
            throw new ExceptionModel("ERR001","Campo LOGIN não pode ter mais que 50 caracteres");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) throws ExceptionModel {

        if (id == null) {
            throw new ExceptionModel("ERR001","Campo ID não pode ser nulo");
        }

        try {
            Usuario user = usuarioRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ExceptionModel("ERR003","O usuario não existe");
        }
        return usuarioRepository.findById(id).get();
    }

    public void excluir(Integer id) throws ExceptionModel {

        try {
            Usuario user = usuarioRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ExceptionModel("ERR003","O usuario não existe");
        }
        usuarioRepository.deleteById(id);
    }

}
