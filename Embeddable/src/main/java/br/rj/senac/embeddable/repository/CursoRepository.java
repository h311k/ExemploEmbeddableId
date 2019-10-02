package br.rj.senac.embeddable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rj.senac.embeddable.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso,Integer> {

}
