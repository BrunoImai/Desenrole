package br.pucbr.exemplo.category.service;

import br.pucbr.exemplo.category.entity.Categoria;
import br.pucbr.exemplo.category.repository.CategoriaRepository;
import br.pucbr.exemplo.usuario.entity.Usuario;
import br.pucbr.exemplo.util.excecao.ExceptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void salvar(Categoria categoria) throws ExceptionModel {
        if (categoria.getNome() == null || categoria.getNome().equals("")) {
            //lanco um erro
            throw new ExceptionModel("ERR001","Campo CATEGORIA não pode ser nulo");
        } else if (categoria.getNome().length() > 50) {
            throw new ExceptionModel("ERR002","Campo CATEGORIA não pode ter mais que 50 caracteres");
        }
        categoriaRepository.save(categoria);
    }

    public List<Categoria> listar() {

        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) throws ExceptionModel {
        try {
            Categoria categoria  = categoriaRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ExceptionModel("ERR003","A CATEGORIA não existe");
        }
        return categoriaRepository.findById(id).get();
    }

    public void excluir(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
