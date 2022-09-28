package br.pucbr.exemplo.category.repository;

import br.pucbr.exemplo.category.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
