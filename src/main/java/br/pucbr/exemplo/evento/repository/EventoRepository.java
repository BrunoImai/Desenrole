package br.pucbr.exemplo.evento.repository;

import br.pucbr.exemplo.evento.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Integer> {
}
