package br.rj.senac.embeddable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rj.senac.embeddable.domain.AlunoCurso;
import br.rj.senac.embeddable.domain.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,AlunoCurso> {

}
